package br.com.acrtech.ecommerce;

import br.com.acrtech.ecommerce.model.Cliente;
import br.com.acrtech.ecommerce.model.Produto;
import br.com.acrtech.ecommerce.model.SexoCliente;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class MapeandoEntidadesTest extends EntityManagerTest{

    @Test
    public void impedirAlteracaoObjetoGerenciado(){
        Cliente cliente = new Cliente();
        cliente.setNome("Alberto Roberto");
        cliente.setSexo(SexoCliente.MASCULINO);

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Cliente clienteValidacao = entityManager.find(Cliente.class, cliente.getId());
        Assert.assertNotNull(clienteValidacao);
        Assert.assertEquals(cliente.getSexo(), clienteValidacao.getSexo());
    }
}
