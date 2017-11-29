/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.logic;

import co.edu.uniandes.csw.viajes.ejb.ImagenLogic;
import co.edu.uniandes.csw.viajes.entities.ImagenEntity;
import co.edu.uniandes.csw.viajes.persistence.ImagenPersistence;
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
public class ImagenLogicTest {
    /**
     * Inyección de la dependencia a la clase ImagenLogic cuyos métodos se van
     * a probar.
     */
    @Inject
    private ImagenLogic imagenLogic;

    /**
     * Inyección de la dependencia a la clase ImagenPersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private ImagenPersistence imagenPersistence;

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
     * Lista de imagenes
     */
    private List<ImagenEntity> dataLogic = new ArrayList<ImagenEntity>();

    /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Imagen, el descriptor de la base de
     * datos y el archivo beans.xml para resolver la inyección de dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ImagenLogic.class.getPackage())
                .addPackage(ImagenEntity.class.getPackage())
                .addPackage(ImagenPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * Constructor por defecto
     */
    public ImagenLogicTest() {
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
        entityM.createQuery("delete from ImagenEntity").executeUpdate();
    }

    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            ImagenEntity imagen = factory.manufacturePojo(ImagenEntity.class);

            entityM.persist(imagen);
            dataLogic.add(imagen);
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test de createImagen, of class ImagenLogic.
     */
    @Test
    public void createImagenEntityTest() {
        ImagenEntity imagen = new ImagenEntity();
        imagenLogic.createImagen(imagen);
        ImagenEntity imagenAux = imagenLogic.getImagen(imagen.getId());

        Assert.assertEquals(imagenAux, imagen);
    }

    /**
     * Test de getImagenes, of class ImagenLogic.
     */
    @Test
    public void getImagenesListTest() {
        List<ImagenEntity> imagenes = imagenPersistence.findAll();
        List<ImagenEntity> imagenesList = imagenLogic.getImagenes();

        Assert.assertEquals(imagenesList, imagenes);
    }

    /**
     * Test de getImagen, of class ImagenLogic.
     */
    @Test
    public void getImagenTest() {
        ImagenEntity imagen = dataLogic.get(0);
        ImagenEntity imagenAux = imagenLogic.getImagen(imagen.getId());

        Assert.assertNotNull(imagenAux);

        Assert.assertEquals(imagenAux, imagen);
    }

    /**
     * Test de updateImagen, of class ImagenLogic.
     */
    @Test
    public void updateImagenTest() {
        ImagenEntity imagen = dataLogic.get(0);
        ImagenEntity imagenAux = new ImagenEntity();

        imagenAux.setId(imagen.getId());

        imagenLogic.updateImagen(imagenAux);

        ImagenEntity imagenDone = entityM.find(ImagenEntity.class, imagen.getId());

        Assert.assertEquals(imagenAux, imagenDone);
    }

    /**
     * Test de deleteImagen, of class ImagenLogic.
     */
    @Test
    public void deleteImagenTest() {
        ImagenEntity imagen = dataLogic.get(0);
        imagenLogic.deleteImagen(imagen.getId());
        ImagenEntity deletedImagen = entityM.find(ImagenEntity.class, imagen.getId());

        Assert.assertNull(deletedImagen);
    }
}
