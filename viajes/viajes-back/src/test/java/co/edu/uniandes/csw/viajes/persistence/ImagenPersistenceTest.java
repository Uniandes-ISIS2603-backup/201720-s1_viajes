/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.persistence;

import co.edu.uniandes.csw.viajes.entities.ImagenEntity;
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
 * @author js.beltran14
 */
@RunWith(Arquillian.class)
public class ImagenPersistenceTest {
    
    /**
     * Inyección de la dependencia a la clase XYZPersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private ImagenPersistence persistence;

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
    private List<ImagenEntity> data = new ArrayList<ImagenEntity>();
    
    public ImagenPersistenceTest() {
    }
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ImagenEntity.class.getPackage())
                .addPackage(ImagenPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
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
    
    @After
    public void tearDown() {
    }

    private void clearData() {
        em.createQuery("delete from ImagenEntity").executeUpdate();
    }


 private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            ImagenEntity entity = factory.manufacturePojo(ImagenEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }
    
    /**
     * Test of create method, of class ImagenPersistence.
     */
    @Test
    public void testCreate() throws Exception {
        PodamFactory factory = new PodamFactoryImpl();
        ImagenEntity newEntity = factory.manufacturePojo(ImagenEntity.class);
        ImagenEntity result = persistence.create(newEntity);

        Assert.assertNotNull(result);
        ImagenEntity entity = em.find(ImagenEntity.class, result.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(newEntity.getRuta(), entity.getRuta());
       // fail("testCreate");
    }

    /**
     * Test of update method, of class ImagenPersistence.
     */
    @Test
    public void testUpdate() throws Exception {
        ImagenEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        ImagenEntity newEntity = factory.manufacturePojo(ImagenEntity.class);

        newEntity.setId(entity.getId());

        persistence.update(newEntity);

        ImagenEntity resp = em.find(ImagenEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getRuta(), resp.getRuta());
        // fail("testUpdate");
    }

    /**
     * Test of delete method, of class ImagenPersistence.
     */
    @Test
    public void testDelete() throws Exception {
        ImagenEntity entity = data.get(0);
        persistence.delete(entity.getId());
        ImagenEntity deleted = em.find(ImagenEntity.class, entity.getId());
        Assert.assertNull(deleted);

        // fail("testDelete");
    }

    /**
     * Test of find method, of class ImagenPersistence.
     */
    @Test
    public void testFind() throws Exception {
        ImagenEntity entity = data.get(0);
        ImagenEntity newEntity = persistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getRuta(), newEntity.getRuta());
        //fail("testFind");
    }

    /**
     * Test of findAll method, of class ImagenPersistence.
     */
    @Test
    public void testFindAll() throws Exception {
        List<ImagenEntity> list = persistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (ImagenEntity ent : list) {
            boolean found = false;
            for (ImagenEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
            }
        }
        Assert.assertTrue(found);
    }
        //fail("testFindAll");
    }
    
}
