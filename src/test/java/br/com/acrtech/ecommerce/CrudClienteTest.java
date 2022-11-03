package br.com.acrtech.ecommerce;

import br.com.acrtech.ecommerce.model.Cliente;
import org.junit.Assert;
import org.junit.Test;

public class CrudClienteTest extends EntityManagerTest{

    @Test
    public void InserindoNovoCliente(){
        Cliente cliente = new Cliente();
        cliente.setNome("Jojô Colonia");

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Cliente clienteValidacao = entityManager.find(Cliente.class, cliente.getId());
        Assert.assertNotNull(clienteValidacao);
        Assert.assertEquals(cliente.getNome(), clienteValidacao.getNome());
    }

    @Test
    public void excluindoCliente(){
        Cliente cliente = entityManager.find(Cliente.class, 2);

        entityManager.getTransaction().begin();
        entityManager.remove(cliente);
        entityManager.getTransaction().commit();

        Cliente clienteValidacao = entityManager.find(Cliente.class, 2);
        Assert.assertNull(clienteValidacao);

    }

    @Test
    public void alterarObjetoGerenciado(){
        Cliente cliente = entityManager.find(Cliente.class, 1);

        entityManager.getTransaction().begin();
        cliente.setNome("Cezão da Bahia");
        entityManager.getTransaction().commit();
        entityManager.clear();

        Cliente clienteValidacao = entityManager.find(Cliente.class, 1);
        Assert.assertEquals(cliente.getNome(), clienteValidacao.getNome());
    }

    @Test
    public void buscarPorIdentificador(){
        Cliente cliente = entityManager.find(Cliente.class, 3);

        Assert.assertEquals("Teotônio Vilela", cliente.getNome());
    }
}
