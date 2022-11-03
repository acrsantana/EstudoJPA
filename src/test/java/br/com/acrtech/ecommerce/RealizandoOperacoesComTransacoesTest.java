package br.com.acrtech.ecommerce;

import br.com.acrtech.ecommerce.model.Produto;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class RealizandoOperacoesComTransacoesTest extends EntityManagerTest{

    @Test
    public void impedirAlteracaoObjetoGerenciado(){
        Produto produto = entityManager.find(Produto.class, 1);

        entityManager.detach(produto);

        entityManager.getTransaction().begin();
        produto.setNome("Kindle Papperwhite 3a Geração");
        produto.setPreco(new BigDecimal(480));
        entityManager.getTransaction().commit();

        Produto produtoValidacao = entityManager.find(Produto.class, produto.getId());
        Assert.assertEquals("Kindle Papperwhite", produtoValidacao.getNome());
    }

    @Test
    public void InserindoRegistroUsandoTransacoes(){
        Produto produto = new Produto();
        produto.setNome("Playstation 5");
        produto.setDescricao("Diversão para toda a família");
        produto.setPreco(new BigDecimal(4599));
        entityManager.getTransaction().begin();
        entityManager.persist(produto); //Devolve o objeto gerenciado
        entityManager.getTransaction().commit();
        entityManager.clear();
        Produto produtoValidacao = entityManager.find(Produto.class, produto.getId());
        Assert.assertNotNull(produtoValidacao);
        Assert.assertEquals(produto.getNome(), produtoValidacao.getNome());
    }

    @Test
    public void excluindoRegistrosUsandoTransacoes(){
        Produto produto = entityManager.find(Produto.class, 2);
        entityManager.getTransaction().begin();
        entityManager.remove(produto);
        entityManager.getTransaction().commit();

        Produto produtoValidacao = entityManager.find(Produto.class, 2);
        Assert.assertNull(produtoValidacao);
    }

    @Test
    public void alterarObjetoNaoGerenciado(){
        Produto produto = new Produto();
        produto.setId(1);
        produto.setNome("Kindle Papperwhite 2a Geração");
        produto.setDescricao("Novo Kindle");
        produto.setPreco(new BigDecimal(450));

        entityManager.getTransaction().begin();
        entityManager.merge(produto);
        entityManager.getTransaction().commit();

        Produto produtoValidacao = entityManager.find(Produto.class, produto.getId());
        Assert.assertEquals(produto.getNome(), produtoValidacao.getNome());
    }

    @Test
    public void alterarObjetoGerenciado(){
        Produto produto = entityManager.find(Produto.class, 1);

        entityManager.getTransaction().begin();
        produto.setNome("Kindle Papperwhite 3a Geração");
        produto.setPreco(new BigDecimal(480));
        entityManager.getTransaction().commit();

        Produto produtoValidacao = entityManager.find(Produto.class, produto.getId());
        Assert.assertEquals(produto.getNome(), produtoValidacao.getNome());
    }

    @Test
    public void InserirRegistroUsandoMerge(){
        Produto produto = new Produto();
        produto.setNome("Playstation 4");
        produto.setDescricao("Diversão para toda a família e a maior coleção de jogos");
        produto.setPreco(new BigDecimal(1800));
        entityManager.getTransaction().begin();
        produto = entityManager.merge(produto); //merge devolve uma copia não gerenciada do objeto
        entityManager.getTransaction().commit();
        entityManager.clear();
        Produto produtoValidacao = entityManager.find(Produto.class, produto.getId());
        Assert.assertNotNull(produtoValidacao);
        Assert.assertEquals(produto.getNome(), produtoValidacao.getNome());
    }
}
