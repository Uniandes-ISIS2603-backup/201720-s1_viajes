/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.logic;

import co.edu.uniandes.csw.viajes.ejb.TransporteLogic;
import co.edu.uniandes.csw.viajes.entities.ImagenEntity;
import co.edu.uniandes.csw.viajes.entities.TransporteEntity;
import co.edu.uniandes.csw.viajes.persistence.TransportePersistence;
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
public class TransporteLogicTest {
 
    /**
     * Inyección de la dependencia a la clase TransporteLogic cuyos métodos se van a
     * probar.
     */
    @Inject
    private TransporteLogic transporteLogic;

    /**
     * Inyección de la dependencia a la clase TransportePersistence cuyos métodos se
     * van a probar.
     */
    @Inject
    private TransportePersistence transportePersistence;

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
     * Lista de transportes
     */
    private List<TransporteEntity> dataLogic = new ArrayList<TransporteEntity>();

    /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Transporte, el descriptor de la base de
     * datos y el archivo beans.xml para resolver la inyección de dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(TransporteLogic.class.getPackage())
                .addPackage(TransporteEntity.class.getPackage())
                .addPackage(TransportePersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * Constructor por defecto
     */
    public TransporteLogicTest() {
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
        entityM.createQuery("delete from TransporteEntity").executeUpdate();
    }

    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();        
        for (int i = 0; i < 3; i++) {
            TransporteEntity transporte = factory.manufacturePojo(TransporteEntity.class);
            List<ImagenEntity> imagenes = new ArrayList<ImagenEntity>();
            for (int j = 0; j < 10; j++) {
                ImagenEntity imagen = factory.manufacturePojo(ImagenEntity.class);
                entityM.persist(imagen);
                imagenes.add(imagen);
            } 
            
            transporte.setImagenes(imagenes);
            
            entityM.persist(transporte);
            dataLogic.add(transporte);
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test de createTransporte, of class TransporteLogic.
     */
    @Test
    public void createTransporteEntityTest() {
        TransporteEntity transporte = new TransporteEntity();
        transporteLogic.createTransporte(transporte);
        TransporteEntity transporteAux = transporteLogic.getTransporte(transporte.getId());

        Assert.assertEquals(transporteAux, transporte);
    }

    /**
     * Test de getTransportes, of class TransporteLogic.
     */
    @Test
    public void getTransportesListTest() {
        List<TransporteEntity> transportes = transportePersistence.findAll();
        List<TransporteEntity> transportesList = transporteLogic.getTransportes();

        Assert.assertEquals(transportesList, transportes);
    }

    /**
     * Test de getTransporte, of class TransporteLogic.
     */
    @Test
    public void getTransporteTest() {
        TransporteEntity transporte = dataLogic.get(0);
        TransporteEntity transporteAux = transporteLogic.getTransporte(transporte.getId());

        Assert.assertNotNull(transporteAux);

        Assert.assertEquals(transporteAux, transporteAux);
    }

    /**
     * Test de updateTransporte, of class TransporteLogic.
     */
    @Test
    public void updateTransporteTest() {
        TransporteEntity transporte = dataLogic.get(0);
        TransporteEntity transporteAux = new TransporteEntity();

        transporteAux.setId(transporte.getId());

        transporteLogic.updateTransporte(transporteAux);

        TransporteEntity transporteDone = entityM.find(TransporteEntity.class, transporte.getId());

        Assert.assertEquals(transporteAux, transporteDone);
    }

    /**
     * Test de deleteTransporte, of class TransporteLogic.
     */
    @Test
    public void deleteTransporteTest() {
        TransporteEntity transporte = dataLogic.get(0);
        transporteLogic.deleteTransporte(transporte.getId());
        TransporteEntity deletedTransporte = entityM.find(TransporteEntity.class, transporte.getId());

        Assert.assertNull(deletedTransporte);
    }

    /**
     * Test de listImagenes, of class TransporteLogic.
     */
    @Test
    public void getListImagenesTest() {
        TransporteEntity transporte = dataLogic.get(0);
        List<ImagenEntity> imagenes = transportePersistence.find(transporte.getId()).getImagenes();
        List<ImagenEntity> imagenesList = transporteLogic.listImagenes(transporte.getId());

        Assert.assertEquals(imagenesList, imagenes);
    }

    /**
     * Test de getImagen, of class TransporteLogic.
     */
    @Test
    public void getImagenTest() {
        TransporteEntity transporte = dataLogic.get(0);
        ImagenEntity imagen = transportePersistence.find(transporte.getId()).getImagenes().get(0);
        ImagenEntity imagenAux = transporteLogic.getImagen(transporte.getId(), imagen.getId());

        Assert.assertNotNull(imagenAux);

        Assert.assertEquals(imagenAux, imagen);
    }

    /**
     * Test de replaceImagen, of class TransporteLogic.
     */
    @Test
    public void replaceImagenTest() {
        TransporteEntity transporte = dataLogic.get(0);
        List<ImagenEntity> imagenes = transportePersistence.find(transporte.getId()).getImagenes();
        List<ImagenEntity> imagenesAux = new ArrayList<ImagenEntity>();

        imagenesAux = imagenes;

        transporteLogic.replaceImagenes(transporte.getId(), imagenesAux);

        List<ImagenEntity> imagenesDone = entityM.find(TransporteEntity.class, transporte.getId()).getImagenes();

        Assert.assertEquals(imagenesAux, imagenesDone);
    }
}
