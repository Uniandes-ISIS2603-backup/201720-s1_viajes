/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.persistence;

import co.edu.uniandes.csw.viajes.entities.UbicacionEntity;
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
public class UbicacionPersistenceTest {
    
    /**
     * Inyección de la dependencia a la clase XYZPersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private UbicacionPersistence persistence;

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
    private List<UbicacionEntity> data = new ArrayList<UbicacionEntity>();
    
    @Deployment
    public static JavaArchive createDeployment(){
      return ShrinkWrap.create(JavaArchive.class)
                .addPackage(UbicacionEntity.class.getPackage())
                .addPackage(UbicacionPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");  
    }
    
    public UbicacionPersistenceTest() {
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
     * Test of create method, of class UbicacionPersistence.
     */
    @Test
    public void testCreate() throws Exception {
    PodamFactory factory = new PodamFactoryImpl();
    UbicacionEntity newEntity = factory.manufacturePojo(UbicacionEntity.class);
    UbicacionEntity result = persistence.create(newEntity);

    Assert.assertNotNull(result);
    
    UbicacionEntity entity = em.find(UbicacionEntity.class, result.getId());
    Assert.assertNotNull(entity);
    Assert.assertEquals(newEntity.getNombre(), entity.getNombre());
    Assert.assertEquals(newEntity.getLongitud(), entity.getLongitud());
    Assert.assertEquals(newEntity.getLatitud(), entity.getLatitud());
    Assert.assertEquals(newEntity.getNombre(), entity.getNombre());
    Assert.assertEquals(newEntity.getDireccion(), entity.getDireccion());
    Assert.assertEquals(newEntity.getCiudad(), entity.getCiudad());
    Assert.assertEquals(newEntity.getPais(), entity.getPais());
    Assert.assertTrue(newEntity.equals(entity));
    Assert.assertEquals(newEntity.hashCode(), entity.hashCode());
    }

    /**
     * Test of update method, of class UbicacionPersistence.
     */
    @Test
    public void testUpdate() throws Exception {
        UbicacionEntity entity = data.get(0);
    PodamFactory factory = new PodamFactoryImpl();
    UbicacionEntity newEntity = factory.manufacturePojo(UbicacionEntity.class);

    newEntity.setId(entity.getId());

    persistence.update(newEntity);

    UbicacionEntity resp = em.find(UbicacionEntity.class, entity.getId());

    Assert.assertEquals(newEntity.getNombre(), resp.getNombre());
    Assert.assertEquals(newEntity.getLongitud(), resp.getLongitud());
    Assert.assertEquals(newEntity.getLatitud(), resp.getLatitud());
    Assert.assertEquals(newEntity.getNombre(), resp.getNombre());
    Assert.assertEquals(newEntity.getDireccion(), resp.getDireccion());
    Assert.assertEquals(newEntity.getCiudad(), resp.getCiudad());
    Assert.assertEquals(newEntity.getPais(), resp.getPais());
    Assert.assertTrue(newEntity.equals(resp));
    Assert.assertEquals(newEntity.hashCode(), resp.hashCode());
    }

    /**
     * Test of delete method, of class UbicacionPersistence.
     */
    @Test
    public void testDelete() throws Exception {
    UbicacionEntity entity = data.get(0);
    persistence.delete(entity.getId());
    UbicacionEntity deleted = em.find(UbicacionEntity.class, entity.getId());
    Assert.assertNull(deleted);
    }

    /**
     * Test of find method, of class UbicacionPersistence.
     */
    @Test
    public void testFind() throws Exception {
        UbicacionEntity entity = data.get(0);
    UbicacionEntity newEntity = persistence.find(entity.getId());
    Assert.assertNotNull(newEntity);
    Assert.assertEquals(entity.getNombre(), newEntity.getNombre());
    Assert.assertEquals(entity.getLongitud(), newEntity.getLongitud());
    Assert.assertEquals(entity.getLatitud(), newEntity.getLatitud());
    Assert.assertEquals(entity.getNombre(), newEntity.getNombre());
    Assert.assertEquals(entity.getDireccion(), newEntity.getDireccion());
    Assert.assertEquals(entity.getCiudad(), newEntity.getCiudad());
    Assert.assertEquals(entity.getPais(), newEntity.getPais());
    Assert.assertTrue(newEntity.equals(entity));
    Assert.assertEquals(newEntity.hashCode(), entity.hashCode());
    }

    /**
     * Test of findAll method, of class UbicacionPersistence.
     */
    @Test
    public void testFindAll() throws Exception {
        List<UbicacionEntity> list = persistence.findAll();
    Assert.assertEquals(data.size(), list.size());
    for (UbicacionEntity ent : list) {
        boolean found = false;
        for (UbicacionEntity entity : data) {
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
            UbicacionEntity entity = factory.manufacturePojo(UbicacionEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }
    
    private void clearData() {
        em.createQuery("delete from UbicacionEntity").executeUpdate();
    }
}
