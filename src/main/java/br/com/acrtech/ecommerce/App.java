package br.com.acrtech.ecommerce;

import br.com.acrtech.ecommerce.model.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ecommercePU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Produto produto = entityManager.find(Produto.class, 1);
        System.out.println( produto );
        entityManager.close();
        entityManagerFactory.close();
    }
}
