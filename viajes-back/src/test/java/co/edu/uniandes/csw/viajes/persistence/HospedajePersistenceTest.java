<<<<<<< HEAD:viajes-back/src/test/java/co/edu/uniandes/csw/viajes/persistence/HospedajePersistenceTest.java
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.persistence;

import co.edu.uniandes.csw.viajes.entities.HospedajeEntity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.runner.RunWith;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author ma.forero11
 */
@RunWith(Arquillian.class)
public class HospedajePersistenceTest {
    
    /**
     * Inyección de la dependencia a la clase XYZPersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private HospedajePersistence persistence;

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
    private List<HospedajeEntity> data = new ArrayList<HospedajeEntity>();
    
    @Deployment
    public static JavaArchive createDeployment(){
      return ShrinkWrap.create(JavaArchive.class)
                .addPackage(HospedajeEntity.class.getPackage())
                .addPackage(HospedajePersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");  
    }
    
    public HospedajePersistenceTest() {
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

    /**
     * Test of create method, of class HospedajePersistence.
     */
    @Test
    public void testCreate() {
            PodamFactory factory = new PodamFactoryImpl();
    HospedajeEntity newEntity = factory.manufacturePojo(HospedajeEntity.class);
    HospedajeEntity result = persistence.create(newEntity);

    Assert.assertNotNull(result);
    HospedajeEntity entity = em.find(HospedajeEntity.class, result.getId());
    Assert.assertNotNull(entity);
    Assert.assertEquals(newEntity.getNombre(), entity.getNombre());
    }

    /**
     * Test of update method, of class HospedajePersistence.
     */
    @Test
    public void testUpdate() {
    HospedajeEntity entity = data.get(0);
    PodamFactory factory = new PodamFactoryImpl();
    HospedajeEntity newEntity = factory.manufacturePojo(HospedajeEntity.class);
    
    newEntity.setId(entity.getId());
    
    persistence.update(newEntity);
    
    HospedajeEntity resp = em.find(HospedajeEntity.class, entity.getId());
    
    Assert.assertEquals(newEntity.getNombre(), resp.getNombre());
    }

    /**
     * Test of delete method, of class HospedajePersistence.
     */
    @Test
    public void testDelete() {
    HospedajeEntity entity = data.get(0);
    persistence.delete(entity.getId());
    HospedajeEntity deleted = em.find(HospedajeEntity.class, entity.getId());
    Assert.assertNull(deleted);
    }

    /**
     * Test of find method, of class HospedajePersistence.
     */
    @Test
    public void testFind() {
        HospedajeEntity entity = data.get(0);
    HospedajeEntity newEntity = persistence.find(entity.getId());
    Assert.assertNotNull(newEntity);
    Assert.assertEquals(entity.getNombre(), newEntity.getNombre());
    }

    /**
     * Test of findAll method, of class HospedajePersistence.
     */
    @Test
    public void testFindAll() {
    List<HospedajeEntity> list = persistence.findAll();
    Assert.assertEquals(data.size(), list.size());
    for (HospedajeEntity ent : list) {
        boolean found = false;
        for (HospedajeEntity entity : data) {
            if (ent.getNombre().equals(entity.getNombre())) {
                found = true;
            }
        }
        Assert.assertTrue(found);
    }
    }

    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            HospedajeEntity entity = factory.manufacturePojo(HospedajeEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }

    private void clearData() {
        em.createQuery("delete from HospedajeEntity").executeUpdate();
    }
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.persistence;

import co.edu.uniandes.csw.viajes.entities.HospedajeEntity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.runner.RunWith;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author ma.forero11
 */
@RunWith(Arquillian.class)
public class HospedajePersistenceTest {
    
    /**
     * Inyección de la dependencia a la clase XYZPersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private HospedajePersistence persistence;

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
    private List<HospedajeEntity> data = new ArrayList<HospedajeEntity>();
    
    @Deployment
    public static JavaArchive createDeployment(){
      return ShrinkWrap.create(JavaArchive.class)
                .addPackage(HospedajeEntity.class.getPackage())
                .addPackage(HospedajePersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");  
    }
    
    public HospedajePersistenceTest() {
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


    /**
     * Test of create method, of class HospedajePersistence.
     */
    @Test
    public void testCreate() {
        PodamFactory factory = new PodamFactoryImpl();
    HospedajeEntity newEntity = factory.manufacturePojo(HospedajeEntity.class);
    HospedajeEntity result = persistence.create(newEntity);

    Assert.assertNotNull(result);
    HospedajeEntity entity = em.find(HospedajeEntity.class, result.getId());
    Assert.assertNotNull(entity);
    Assert.assertEquals(newEntity.getNombre(), entity.getNombre());
    }

    /**
     * Test of update method, of class HospedajePersistence.
     */
    @Test
    public void testUpdate() {
            HospedajeEntity entity = data.get(0);
    PodamFactory factory = new PodamFactoryImpl();
    HospedajeEntity newEntity = factory.manufacturePojo(HospedajeEntity.class);
    newEntity.setId(entity.getId());
    persistence.update(newEntity);
    HospedajeEntity resp = em.find(HospedajeEntity.class, entity.getId());
    Assert.assertEquals(newEntity.getNombre(), resp.getNombre());
    }

    /**
     * Test of delete method, of class HospedajePersistence.
     */
    @Test
    public void testDelete() {
            HospedajeEntity entity = data.get(0);
    persistence.delete(entity.getId());
    HospedajeEntity deleted = em.find(HospedajeEntity.class, entity.getId());
    Assert.assertNull(deleted);
    }

    /**
     * Test of find method, of class HospedajePersistence.
     */
    @Test
    public void testFind() {
        HospedajeEntity entity = data.get(0);
    HospedajeEntity newEntity = persistence.find(entity.getId());
    Assert.assertNotNull(newEntity);
    Assert.assertEquals(entity.getNombre(), newEntity.getNombre());
    }

    /**
     * Test of findAll method, of class HospedajePersistence.
     */
    @Test
    public void testFindAll() {
    List<HospedajeEntity> list = persistence.findAll();
    Assert.assertEquals(data.size(), list.size());
    for (HospedajeEntity ent : list) {
        boolean found = false;
        for (HospedajeEntity entity : data) {
            if (ent.getNombre().equals(entity.getNombre())) {
                found = true;
            }
        }
        Assert.assertTrue(found);
    }
    }

    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            HospedajeEntity entity = factory.manufacturePojo(HospedajeEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }

    private void clearData() {
        em.createQuery("delete from HospedajeEntity").executeUpdate();
    }
>>>>>>> 54f081f4f297fb2275db5a2ba42454a9f1891aa1:viajes/viajes-back/src/test/java/co/edu/uniandes/csw/viajes/persistence/HospedajePersistenceTest.java
}