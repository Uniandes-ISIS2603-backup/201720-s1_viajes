/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.persistence;

import co.edu.uniandes.csw.viajes.entities.EntretenimientoEntity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author m.rodriguez21
 */
@RunWith(Arquillian.class)
public class EntretenimientoPersistenceTest {
    
    /**
     * Inyección de la dependencia a la clase EntretenimientoPersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private EntretenimientoPersistence persistence;

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
    private List<EntretenimientoEntity> data = new ArrayList<EntretenimientoEntity>();
    
    /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Entretenimiento, el descriptor de la
     * base de datos y el archivo beans.xml para resolver la inyección de
     * dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(EntretenimientoEntity.class.getPackage())
                .addPackage(EntretenimientoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    /**
     * 
     */
    public EntretenimientoPersistenceTest() {
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
        em.createQuery("delete from EntretenimientoEntity").executeUpdate();
    }

    /**
     * 
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            EntretenimientoEntity entity = factory.manufacturePojo(EntretenimientoEntity.class);

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
     * Test of create method, of class EntretenimientoPersistence.
     */
    @Test
    public void createEntretenimientoEntityTest() {
    PodamFactory factory = new PodamFactoryImpl();
    EntretenimientoEntity newEntity = factory.manufacturePojo(EntretenimientoEntity.class);
    EntretenimientoEntity result = persistence.create(newEntity);

    Assert.assertNotNull(result);
    EntretenimientoEntity entity = em.find(EntretenimientoEntity.class, result.getId());
    Assert.assertNotNull(entity);
    Assert.assertEquals(newEntity.getNombre(), entity.getNombre());
    Assert.assertEquals(newEntity.getFechaInicio(), entity.getFechaInicio());
    Assert.assertEquals(newEntity.getFechaFinal(), entity.getFechaFinal());
    Assert.assertEquals(newEntity.getValor(), entity.getValor());
    Assert.assertEquals(newEntity.getCalificacion(), entity.getCalificacion());
    Assert.assertEquals(newEntity.getComentarios(), entity.getComentarios());
    Assert.assertEquals(newEntity.getDescripcion(), entity.getDescripcion());
    Assert.assertEquals(newEntity.getImagenes(), entity.getImagenes());
    Assert.assertEquals(newEntity.getCompania(), entity.getCompania());
    Assert.assertEquals(newEntity.getUbicacion(), entity.getUbicacion());
    
    entity.setUbicacion(newEntity.getUbicacion());
    Assert.assertEquals("Incoherencia de datos", entity.getUbicacion(), newEntity.getUbicacion()); 
    
    entity.setCompania(newEntity.getCompania());
    Assert.assertEquals("Incoherencia de datos", entity.getCompania(), newEntity.getCompania()); 
    
    entity.setImagenes(newEntity.getImagenes());
    Assert.assertEquals("Incoherencia de datos", entity.getImagenes(), newEntity.getImagenes()); 
    
    Assert.assertTrue(newEntity.equals(entity));
    Assert.assertEquals(newEntity.hashCode(), entity.hashCode());
    }
    
    /**
     * Test of update method, of class EntretenimientoPersistence.
     */
    @Test
    public void updateEntretenimientoTest() {
    EntretenimientoEntity entity = data.get(0);
    PodamFactory factory = new PodamFactoryImpl();
    EntretenimientoEntity newEntity = factory.manufacturePojo(EntretenimientoEntity.class);

    newEntity.setId(entity.getId());

    persistence.update(newEntity);

    EntretenimientoEntity resp = em.find(EntretenimientoEntity.class, entity.getId());

    Assert.assertEquals(newEntity.getNombre(), resp.getNombre());
    Assert.assertEquals(newEntity.getFechaInicio(), resp.getFechaInicio());
    Assert.assertEquals(newEntity.getFechaFinal(), resp.getFechaFinal());
    Assert.assertEquals(newEntity.getValor(), resp.getValor());
    Assert.assertEquals(newEntity.getCalificacion(), resp.getCalificacion());
    Assert.assertEquals(newEntity.getComentarios(), resp.getComentarios());
    Assert.assertEquals(newEntity.getDescripcion(), resp.getDescripcion());
    Assert.assertEquals(newEntity.getImagenes(), resp.getImagenes());
    Assert.assertEquals(newEntity.getCompania(), resp.getCompania());
    Assert.assertEquals(newEntity.getUbicacion(), resp.getUbicacion());
    Assert.assertTrue(newEntity.equals(resp));
    Assert.assertEquals(newEntity.hashCode(), resp.hashCode());
    }

    /**
     * Test of delete method, of class EntretenimientoPersistence.
     */
    @Test
    public void deleteEntretenimientoTest() {
    EntretenimientoEntity entity = data.get(0);
    persistence.delete(entity.getId());
    EntretenimientoEntity deleted = em.find(EntretenimientoEntity.class, entity.getId());
    Assert.assertNull(deleted);
    }

    /**
     * Test of find method, of class EntretenimientoPersistence.
     */
    @Test
    public void getEntretenimientoTest() {
    EntretenimientoEntity entity = data.get(0);
    EntretenimientoEntity newEntity = persistence.find(entity.getId());
    Assert.assertNotNull(newEntity);
    Assert.assertEquals(entity.getNombre(), newEntity.getNombre());
    Assert.assertEquals(entity.getFechaInicio(), newEntity.getFechaInicio());
    Assert.assertEquals(entity.getFechaFinal(), newEntity.getFechaFinal());
    Assert.assertEquals(entity.getValor(), newEntity.getValor());
    Assert.assertEquals(entity.getCalificacion(), newEntity.getCalificacion());
    Assert.assertEquals(entity.getComentarios(), newEntity.getComentarios());
    Assert.assertEquals(entity.getDescripcion(), newEntity.getDescripcion());
    Assert.assertEquals(entity.getImagenes(), newEntity.getImagenes());
    Assert.assertEquals(entity.getCompania(), newEntity.getCompania());
    Assert.assertEquals(entity.getUbicacion(), newEntity.getUbicacion());
    Assert.assertTrue(newEntity.equals(entity));
    Assert.assertEquals(newEntity.hashCode(), entity.hashCode());
    }

    /**
     * Test of findAll method, of class EntretenimientoPersistence.
     */
    @Test
    public void getEntretenimientosTest() {
    List<EntretenimientoEntity> list = persistence.findAll();
    Assert.assertEquals(data.size(), list.size());
    for (EntretenimientoEntity ent : list) {
        boolean found = false;
        for (EntretenimientoEntity entity : data) {
            if (ent.getId().equals(entity.getId())) {
                found = true;
            }
        }
        Assert.assertTrue(found);
    }
    }     
}
