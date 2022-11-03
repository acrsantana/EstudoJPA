package br.com.acrtech.ecommerce;

import br.com.acrtech.ecommerce.model.Produto;
import org.junit.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerTest {

    protected static EntityManagerFactory entityManagerFactory;
    protected EntityManager entityManager;

    @BeforeClass
    public static void setUpBeforeClass(){
        entityManagerFactory = Persistence.createEntityManagerFactory("ecommercePU");
    }

    @AfterClass
    public static void tearDownAfterClass(){
        entityManagerFactory.close();
    }

    @Before
    public void setUp(){
        entityManager = entityManagerFactory.createEntityManager();
    }

    @After
    public void tearDown(){
        entityManager.close();
    }
}
