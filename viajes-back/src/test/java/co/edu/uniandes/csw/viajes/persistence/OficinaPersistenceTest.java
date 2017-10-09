/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.persistence;

import co.edu.uniandes.csw.viajes.entities.OficinaEntity;
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
 * @author m.rodriguez21
 */
@RunWith(Arquillian.class)
public class OficinaPersistenceTest {
    
    /**
     * Inyección de la dependencia a la clase OficinaPersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private OficinaPersistence persistence;

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
    private List<OficinaEntity> data = new ArrayList<OficinaEntity>();
    
    /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Oficina, el descriptor de la
     * base de datos y el archivo beans.xml para resolver la inyección de
     * dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(OficinaEntity.class.getPackage())
                .addPackage(OficinaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    public OficinaPersistenceTest() {
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
        em.createQuery("delete from OficinaEntity").executeUpdate();
    }


    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            OficinaEntity entity = factory.manufacturePojo(OficinaEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class OficinaPersistence.
     */
    @Test
    public void createOficinaEntityTest() {
    PodamFactory factory = new PodamFactoryImpl();
    OficinaEntity newEntity = factory.manufacturePojo(OficinaEntity.class);
    OficinaEntity result = persistence.create(newEntity);

    Assert.assertNotNull(result);
    OficinaEntity entity = em.find(OficinaEntity.class, result.getId());
    Assert.assertNotNull(entity);
    Assert.assertEquals(newEntity.getNombreLugar(), entity.getNombreLugar());
    Assert.assertEquals(newEntity.getNombreEncargado(), entity.getNombreEncargado());
    Assert.assertEquals(newEntity.getUbicacion(), entity.getUbicacion());
    Assert.assertTrue(newEntity.equals(entity));
    Assert.assertEquals(newEntity.hashCode(), entity.hashCode());
    }

    /**
     * Test of update method, of class OficinaPersistence.
     */
    @Test
    public void updateOficinaTest() {
    OficinaEntity entity = data.get(0);
    PodamFactory factory = new PodamFactoryImpl();
    OficinaEntity newEntity = factory.manufacturePojo(OficinaEntity.class);

    newEntity.setId(entity.getId());

    persistence.update(newEntity);

    OficinaEntity resp = em.find(OficinaEntity.class, entity.getId());

    Assert.assertEquals(newEntity.getNombreLugar(), resp.getNombreLugar());
    Assert.assertEquals(newEntity.getNombreEncargado(), resp.getNombreEncargado());
    Assert.assertEquals(newEntity.getUbicacion(), resp.getUbicacion());
    Assert.assertTrue(newEntity.equals(resp));
    Assert.assertEquals(newEntity.hashCode(), resp.hashCode());
    }

    /**
     * Test of delete method, of class OficinaPersistence.
     */
    @Test
    public void deleteOficinaTest() {
    OficinaEntity entity = data.get(0);
    persistence.delete(entity.getId());
    OficinaEntity deleted = em.find(OficinaEntity.class, entity.getId());
    Assert.assertNull(deleted);
    }

    /**
     * Test of find method, of class OficinaPersistence.
     */
    @Test
    public void getOficinaTest() {
    OficinaEntity entity = data.get(0);
    OficinaEntity newEntity = persistence.find(entity.getId());
    Assert.assertNotNull(newEntity);
    Assert.assertEquals(entity.getNombreLugar(), newEntity.getNombreLugar());
    Assert.assertEquals(entity.getNombreEncargado(), newEntity.getNombreEncargado());
    Assert.assertEquals(entity.getUbicacion(), newEntity.getUbicacion());
    Assert.assertTrue(newEntity.equals(entity));
    Assert.assertEquals(newEntity.hashCode(), entity.hashCode());
    }

    /**
     * Test of findAll method, of class OficinaPersistence.
     */
    @Test
    public void getOficinasTest() {
    List<OficinaEntity> list = persistence.findAll();
    Assert.assertEquals(data.size(), list.size());
    for (OficinaEntity ent : list) {
        boolean found = false;
        for (OficinaEntity entity : data) {
            if (ent.getId().equals(entity.getId())) {
                found = true;
            }
        }
        Assert.assertTrue(found);
    }
    }   
}
