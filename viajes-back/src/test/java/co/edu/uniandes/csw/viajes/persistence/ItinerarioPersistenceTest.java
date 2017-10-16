package co.edu.uniandes.csw.viajes.persistence;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import co.edu.uniandes.csw.viajes.entities.ItinerarioEntity;
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
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author js.beltran14
 */
@RunWith(Arquillian.class)
public class ItinerarioPersistenceTest {
    
    /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de XYZ, el descriptor de la
     * base de datos y el archivo beans.xml para resolver la inyección de
     * dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ItinerarioEntity.class.getPackage())
                .addPackage(ItinerarioPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    /**
     * Inyección de la dependencia a la clase XYZPersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private ItinerarioPersistence persistence;

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
    private List<ItinerarioEntity> data = new ArrayList<ItinerarioEntity>();
    
    public ItinerarioPersistenceTest() {
    }
    
    /**
     * 
     */
    @BeforeClass
    public static void setUpClass() {
    }
    
    /**
     * 
     */
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     * 
     */
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
     * 
     */
    private void clearData() {
        em.createQuery("delete from ItinerarioEntity").executeUpdate();
    }

    /**
     * 
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            ItinerarioEntity entity = factory.manufacturePojo(ItinerarioEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }
    
    /**
     * 
     */
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class ItinerarioPersistence.
     */
    @Test
    public void testCreate() throws Exception {
        PodamFactory factory = new PodamFactoryImpl();
        ItinerarioEntity newEntity = factory.manufacturePojo(ItinerarioEntity.class);
        ItinerarioEntity result = persistence.create(newEntity);

        Assert.assertNotNull(result);
        ItinerarioEntity entity = em.find(ItinerarioEntity.class, result.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(newEntity.getFechaInicial(), entity.getFechaInicial());
        Assert.assertEquals(newEntity.getCostoTotal(), entity.getCostoTotal());
        Assert.assertEquals(newEntity.getFechaFinal(), entity.getFechaFinal());
        Assert.assertEquals(newEntity.getNumeroVisitantes(), entity.getNumeroVisitantes());
        Assert.assertEquals(newEntity.getGias(), entity.getGias());
        Assert.assertEquals(newEntity.getHospedajes(), entity.getHospedajes());
        Assert.assertEquals(newEntity.getEntretenimientos(), entity.getEntretenimientos());
        Assert.assertEquals(newEntity.getTransportes(), entity.getTransportes());
        
        entity.setGias(newEntity.getGias());
        Assert.assertEquals("Incoherencia de datos", entity.getGias(), newEntity.getGias());   
        
        entity.setHospedajes(newEntity.getHospedajes());
        Assert.assertEquals("Incoherencia de datos", entity.getHospedajes(), newEntity.getHospedajes());
        
        entity.setEntretenimientos(newEntity.getEntretenimientos());
        Assert.assertEquals("Incoherencia de datos", entity.getEntretenimientos(), newEntity.getEntretenimientos());
        
        entity.setTransportes(newEntity.getTransportes());
        Assert.assertEquals("Incoherencia de datos", entity.getTransportes(), newEntity.getTransportes());
        
        Assert.assertTrue(newEntity.equals(entity));
        Assert.assertEquals(newEntity.hashCode(), entity.hashCode());
    }

    /**
     * Test of update method, of class ItinerarioPersistence.
     */
    @Test
    public void testUpdate() throws Exception {
        ItinerarioEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        ItinerarioEntity newEntity = factory.manufacturePojo(ItinerarioEntity.class);

        newEntity.setId(entity.getId());

        persistence.update(newEntity);

        ItinerarioEntity resp = em.find(ItinerarioEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getFechaInicial(), resp.getFechaInicial());
        Assert.assertEquals(newEntity.getCostoTotal(), resp.getCostoTotal());
        Assert.assertEquals(newEntity.getFechaFinal(), resp.getFechaFinal());
        Assert.assertEquals(newEntity.getNumeroVisitantes(), resp.getNumeroVisitantes());
        Assert.assertEquals(newEntity.getGias(), resp.getGias());
        Assert.assertEquals(newEntity.getHospedajes(), resp.getHospedajes());
        Assert.assertEquals(newEntity.getEntretenimientos(), resp.getEntretenimientos());
        Assert.assertEquals(newEntity.getTransportes(), resp.getTransportes());
        Assert.assertTrue(newEntity.equals(resp));
        Assert.assertEquals(newEntity.hashCode(), resp.hashCode());
    }

    /**
     * Test of delete method, of class ItinerarioPersistence.
     */
    @Test
    public void testDelete() throws Exception {
        ItinerarioEntity entity = data.get(0);
        persistence.delete(entity.getId());
        ItinerarioEntity deleted = em.find(ItinerarioEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Test of find method, of class ItinerarioPersistence.
     */
    @Test
    public void testFind() throws Exception {
        ItinerarioEntity entity = data.get(0);
        ItinerarioEntity newEntity = persistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getFechaInicial(), newEntity.getFechaInicial());
        Assert.assertEquals(entity.getCostoTotal(), newEntity.getCostoTotal());
        Assert.assertEquals(entity.getFechaFinal(), newEntity.getFechaFinal());
        Assert.assertEquals(entity.getNumeroVisitantes(), newEntity.getNumeroVisitantes());
        Assert.assertEquals(entity.getGias(), newEntity.getGias());
        Assert.assertEquals(entity.getHospedajes(), newEntity.getHospedajes());
        Assert.assertEquals(entity.getEntretenimientos(), newEntity.getEntretenimientos());
        Assert.assertEquals(entity.getTransportes(), newEntity.getTransportes());
        Assert.assertTrue(newEntity.equals(entity));
        Assert.assertEquals(newEntity.hashCode(), entity.hashCode());
    }

    /**
     * Test of findAll method, of class ItinerarioPersistence.
     */
    @Test
    public void testFindAll() throws Exception {
        List<ItinerarioEntity> list = persistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (ItinerarioEntity ent : list) {
            boolean found = false;
            for (ItinerarioEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
            }
        }
        Assert.assertTrue(found);
    }
    }
}
