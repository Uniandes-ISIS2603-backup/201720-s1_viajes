/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.logic;

import co.edu.uniandes.csw.viajes.ejb.HospedajeLogic;
import co.edu.uniandes.csw.viajes.entities.HospedajeEntity;
import co.edu.uniandes.csw.viajes.entities.ImagenEntity;
import co.edu.uniandes.csw.viajes.persistence.HospedajePersistence;
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
 * @author Vanessa Huertas <tv.huertas10>
 */
@RunWith(Arquillian.class)
public class HospedajeLogicTest {
    
    /**
     * Inyección de la dependencia a la clase HospedajeLogic cuyos métodos se van a
     * probar.
     */
    @Inject
    private HospedajeLogic hospedajeLogic;

    /**
     * Inyección de la dependencia a la clase HospedajePersistence cuyos métodos se
     * van a probar.
     */
    @Inject
    private HospedajePersistence hospedajePersistence;

    /**
     * Contexto de Persistencia que se va a utilizar para acceder a la Base de
     * datos por fuera de los métodos que se están probando.
     */
    @PersistenceContext
    private EntityManager entityM;

    /**
     * Variable para marcar las transacciones del em anterior cuando se
     * crean/borran datos para las pruebas.
     */
    @Inject
    UserTransaction userTX;

    /**
     * Lista de hospedajes
     */
    private List<HospedajeEntity> dataLogic = new ArrayList<HospedajeEntity>();

    /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Hospedaje, el descriptor de la base de
     * datos y el archivo beans.xml para resolver la inyección de dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(HospedajeLogic.class.getPackage())
                .addPackage(HospedajeEntity.class.getPackage())
                .addPackage(HospedajePersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * Constructor por defecto
     */
    public HospedajeLogicTest() {
        //Constructor por defecto
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
            userTX.begin();
            entityM.joinTransaction();
            clearData();
            insertData();
            userTX.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                userTX.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    private void clearData() {
        entityM.createQuery("delete from HospedajeEntity").executeUpdate();
    }

    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();        
        for (int i = 0; i < 3; i++) {
            HospedajeEntity hospedaje = factory.manufacturePojo(HospedajeEntity.class);
            List<ImagenEntity> imagenes = new ArrayList<ImagenEntity>();
            for (int j = 0; j < 10; j++) {
                ImagenEntity imagen = factory.manufacturePojo(ImagenEntity.class);
                entityM.persist(imagen);
                imagenes.add(imagen);
            } 
            
            hospedaje.setImagenes(imagenes);
            
            entityM.persist(hospedaje);
            dataLogic.add(hospedaje);
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test de createHospedaje, of class HospedajeLogic.
     */
    @Test
    public void createHospedajeEntityTest() {
        HospedajeEntity hospedaje = new HospedajeEntity();
        hospedajeLogic.createHospedaje(hospedaje);
        HospedajeEntity hospedajeAux = hospedajeLogic.getHospedaje(hospedaje.getId());

        Assert.assertEquals(hospedajeAux, hospedaje);
    }

    /**
     * Test de getHospedajes, of class HospedajeLogic.
     */
    @Test
    public void getHospedajesListTest() {
        List<HospedajeEntity> hospedajes = hospedajePersistence.findAll();
        List<HospedajeEntity> hospedajesList = hospedajeLogic.getHospedajes();

        Assert.assertEquals(hospedajesList, hospedajes);
    }

    /**
     * Test de getHospedaje, of class HospedajeLogic.
     */
    @Test
    public void getHospedajeTest() {
        HospedajeEntity hospedaje = dataLogic.get(0);
        HospedajeEntity hospedajeAux = hospedajeLogic.getHospedaje(hospedaje.getId());

        Assert.assertNotNull(hospedajeAux);

        Assert.assertEquals(hospedajeAux, hospedaje);
    }

    /**
     * Test de updateHospedaje, of class HospedajeLogic.
     */
    @Test
    public void updateHospedajeTest() {
        HospedajeEntity hospedaje = dataLogic.get(0);
        HospedajeEntity hospedajeAux = new HospedajeEntity();

        hospedajeAux.setId(hospedaje.getId());

        hospedajeLogic.updateHospedaje(hospedajeAux);

        HospedajeEntity hospedajeDone = entityM.find(HospedajeEntity.class, hospedaje.getId());

        Assert.assertEquals(hospedajeAux, hospedajeDone);
    }

    /**
     * Test de deleteHospedaje, of class HospedajeLogic.
     */
    @Test
    public void deleteHospedajeTest() {
        HospedajeEntity hospedaje = dataLogic.get(0);
        hospedajeLogic.deleteHospedaje(hospedaje.getId());
        HospedajeEntity deletedHospedaje = entityM.find(HospedajeEntity.class, hospedaje.getId());

        Assert.assertNull(deletedHospedaje);
    }

    /**
     * Test de listImagenes, of class HospedajeLogic.
     */
    @Test
    public void getListImagenesTest() {
        HospedajeEntity hospedaje = dataLogic.get(0);
        List<ImagenEntity> imagenes = hospedajePersistence.find(hospedaje.getId()).getImagenes();
        List<ImagenEntity> imagenesList = hospedajeLogic.listImagenes(hospedaje.getId());

        Assert.assertEquals(imagenesList, imagenes);
    }

    /**
     * Test de getImagen, of class HospedajeLogic.
     */
    @Test
    public void getImagenTest() {
        HospedajeEntity hospedaje = dataLogic.get(0);
        ImagenEntity imagen = hospedajePersistence.find(hospedaje.getId()).getImagenes().get(0);
        ImagenEntity imagenAux = hospedajeLogic.getImagen(hospedaje.getId(), imagen.getId());

        Assert.assertNotNull(imagenAux);

        Assert.assertEquals(imagenAux, imagen);
    }

    /**
     * Test de replaceImagen, of class HospedajeLogic.
     */
    @Test
    public void replaceImagenTest() {
        HospedajeEntity hospedaje = dataLogic.get(0);
        List<ImagenEntity> imagenes = hospedajePersistence.find(hospedaje.getId()).getImagenes();
        List<ImagenEntity> imagenesAux = new ArrayList<ImagenEntity>();

        imagenesAux = imagenes;

        hospedajeLogic.replaceImagenes(hospedaje.getId(), imagenesAux);

        List<ImagenEntity> imagenesDone = entityM.find(HospedajeEntity.class, hospedaje.getId()).getImagenes();

        Assert.assertEquals(imagenesAux, imagenesDone);
    }
}
