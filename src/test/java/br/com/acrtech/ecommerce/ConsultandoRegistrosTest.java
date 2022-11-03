package br.com.acrtech.ecommerce;

import br.com.acrtech.ecommerce.model.Produto;
import org.junit.Assert;
import org.junit.Test;

public class ConsultandoRegistrosTest extends EntityManagerTest{

    @Test
    public void buscarPorIdentificador(){
        Produto produto = entityManager.find(Produto.class, 1);

        Assert.assertNotNull(produto);
        Assert.assertEquals("Kindle Papperwhite", produto.getNome());
    }
}
