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
    Assert.assertEquals(newEntity.getTipo(), entity.getTipo());
    Assert.assertEquals(newEntity.getCompania(), entity.getCompania());
    Assert.assertEquals(newEntity.getUbicacion(), entity.getUbicacion());
    Assert.assertEquals(newEntity.getImagenes(), entity.getImagenes());
    Assert.assertEquals(newEntity.getItinerario(), entity.getItinerario());
    Assert.assertEquals(newEntity.getNombre(), entity.getNombre());
    Assert.assertEquals(newEntity.getFechaInicio(), entity.getFechaInicio());
    Assert.assertEquals(newEntity.getFechaFinal(), entity.getFechaFinal());
    Assert.assertEquals(newEntity.getValor(), entity.getValor());
    Assert.assertEquals(newEntity.getCalificacion(), entity.getCalificacion());
    Assert.assertEquals(newEntity.getComentarios(), entity.getComentarios());
    Assert.assertEquals(newEntity.getDescripcion(), entity.getDescripcion());    
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
    Assert.assertEquals(newEntity.getTipo(), resp.getTipo());
    Assert.assertEquals(newEntity.getCompania(), resp.getCompania());
    Assert.assertEquals(newEntity.getUbicacion(), resp.getUbicacion());
    Assert.assertEquals(newEntity.getImagenes(), resp.getImagenes());
    Assert.assertEquals(newEntity.getItinerario(), resp.getItinerario());
    Assert.assertEquals(newEntity.getFechaInicio(), resp.getFechaInicio());
    Assert.assertEquals(newEntity.getFechaFinal(), resp.getFechaFinal());
    Assert.assertEquals(newEntity.getValor(), resp.getValor());
    Assert.assertEquals(newEntity.getCalificacion(), resp.getCalificacion());
    Assert.assertEquals(newEntity.getComentarios(), resp.getComentarios());
    Assert.assertEquals(newEntity.getDescripcion(), resp.getDescripcion()); 
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
    Assert.assertEquals(entity.getTipo(), newEntity.getTipo());
    Assert.assertEquals(entity.getCompania(), newEntity.getCompania());
    Assert.assertEquals(entity.getUbicacion(), newEntity.getUbicacion());
    Assert.assertEquals(entity.getImagenes(), newEntity.getImagenes());
    Assert.assertEquals(entity.getItinerario(), newEntity.getItinerario());
    Assert.assertEquals(entity.getFechaInicio(), newEntity.getFechaInicio());
    Assert.assertEquals(entity.getFechaFinal(), newEntity.getFechaFinal());
    Assert.assertEquals(entity.getValor(), newEntity.getValor());
    Assert.assertEquals(entity.getCalificacion(), newEntity.getCalificacion());
    Assert.assertEquals(entity.getComentarios(), newEntity.getComentarios());
    Assert.assertEquals(entity.getDescripcion(), newEntity.getDescripcion());
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
    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
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
}