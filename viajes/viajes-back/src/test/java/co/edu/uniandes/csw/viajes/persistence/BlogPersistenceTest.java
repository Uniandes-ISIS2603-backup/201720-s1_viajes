/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.persistence;

import co.edu.uniandes.csw.viajes.entities.BlogEntity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author m.rodriguez21
 */
@RunWith(Arquillian.class)
public class BlogPersistenceTest {
    
    /**
     * Inyección de la dependencia a la clase BlogPersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private BlogPersistence persistence;

    /**
     * Contexto de Persistencia que se va a utilizar para acceder a la Base de
     * datos por fuera de los métodos que se están probando.
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * Variable para martcar las transacciones del em anterior cuando se
     * crean/borran datos para las pruebas.
     */
    @Inject
    UserTransaction utx;

     /**
     *
     */
    private List<BlogEntity> data = new ArrayList<BlogEntity>();
    
    /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Blog, el descriptor de la
     * base de datos y el archivo beans.xml para resolver la inyección de
     * dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(BlogEntity.class.getPackage())
                .addPackage(BlogPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    public BlogPersistenceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        try {
            utx.begin();
            em.joinTransaction();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
    
    private void clearData() {
        em.createQuery("delete from BlogEntity").executeUpdate();
    }


    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            BlogEntity entity = factory.manufacturePojo(BlogEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class BlogPersistence.
     */
    @Test
    public void createBlogEntityTest() {
    PodamFactory factory = new PodamFactoryImpl();
    BlogEntity newEntity = factory.manufacturePojo(BlogEntity.class);
    BlogEntity result = persistence.create(newEntity);

    Assert.assertNotNull(result);
    BlogEntity entity = em.find(BlogEntity.class, result.getId());
    Assert.assertNotNull(entity);
    Assert.assertEquals(newEntity.getNombreTitulo(), entity.getNombreTitulo());
    }

    /**
     * Test of update method, of class BlogPersistence.
     */
    @Test
    public void updateBlogTest() {
    BlogEntity entity = data.get(0);
    PodamFactory factory = new PodamFactoryImpl();
    BlogEntity newEntity = factory.manufacturePojo(BlogEntity.class);

    newEntity.setId(entity.getId());

    persistence.update(newEntity);

    BlogEntity resp = em.find(BlogEntity.class, entity.getId());

    Assert.assertEquals(newEntity.getNombreTitulo(), resp.getNombreTitulo());
    }

    /**
     * Test of delete method, of class BlogPersistence.
     */
    @Test
    public void deleteBlogTest() {
    BlogEntity entity = data.get(0);
    persistence.delete(entity.getId());
    BlogEntity deleted = em.find(BlogEntity.class, entity.getId());
    Assert.assertNull(deleted);
    }

    /**
     * Test of find method, of class BlogPersistence.
     */
    @Test
    public void getBlogTest() {
    BlogEntity entity = data.get(0);
    BlogEntity newEntity = persistence.find(entity.getId());
    Assert.assertNotNull(newEntity);
    Assert.assertEquals(entity.getNombreTitulo(), newEntity.getNombreTitulo());
    }

    /**
     * Test of findAll method, of class BlogPersistence.
     */
    @Test
    public void getBlogsTest() {
    List<BlogEntity> list = persistence.findAll();
    Assert.assertEquals(data.size(), list.size());
    for (BlogEntity ent : list) {
        boolean found = false;
        for (BlogEntity entity : data) {
            if (ent.getId().equals(entity.getId())) {
                found = true;
            }
        }
        Assert.assertTrue(found);
    }
    }
    
}
