/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.logic;

import co.edu.uniandes.csw.viajes.ejb.EntretenimientoLogic;
import co.edu.uniandes.csw.viajes.entities.BlogEntity;
import co.edu.uniandes.csw.viajes.entities.EntretenimientoEntity;
import co.edu.uniandes.csw.viajes.entities.ImagenEntity;
import co.edu.uniandes.csw.viajes.persistence.EntretenimientoPersistence;
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
public class EntretenimientoLogicTest {
    
    /**
     * Inyección de la dependencia a la clase EntretenimientoLogic cuyos métodos se van a
     * probar.
     */
    @Inject
    private EntretenimientoLogic entretenimientoLogic;

    /**
     * Inyección de la dependencia a la clase EntretenimientoPersistence cuyos métodos se
     * van a probar.
     */
    @Inject
    private EntretenimientoPersistence entretenimientoPersistence;

    /**
     * Contexto de Persistencia que se va a utilizar para acceder a la Base de
     * datos por fuera de los métodos que se están probando.
     */
    @PersistenceContext
    private EntityManager entityM;

    /**
     * Variable para martcar las transacciones del em anterior cuando se
     * crean/borran datos para las pruebas.
     */
    @Inject
    UserTransaction userTX;

    /**
     * Lista de blogs
     */
    private List<EntretenimientoEntity> dataLogic = new ArrayList<EntretenimientoEntity>();

    /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Entretenimiento, el descriptor de la base de
     * datos y el archivo beans.xml para resolver la inyección de dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(EntretenimientoLogic.class.getPackage())
                .addPackage(EntretenimientoEntity.class.getPackage())
                .addPackage(EntretenimientoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * Constructor por defecto
     */
    public EntretenimientoLogicTest() {
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
        entityM.createQuery("delete from EntretenimientoEntity").executeUpdate();
    }

    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();        
        for (int i = 0; i < 3; i++) {
            EntretenimientoEntity entretenimiento = factory.manufacturePojo(EntretenimientoEntity.class);
            
            List<ImagenEntity> imagenes = new ArrayList<ImagenEntity>();
            for (int j = 0; j < 10; j++) {
                ImagenEntity imagen = factory.manufacturePojo(ImagenEntity.class);
                entityM.persist(imagen);
                imagenes.add(imagen);
            } 
            
            entretenimiento.setImagenes(imagenes);
            
            entityM.persist(entretenimiento);
            dataLogic.add(entretenimiento);
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test de createEntretenimiento, of class EntretenimientoLogic.
     */
    @Test
    public void createEntretenimientoEntityTest() {
        EntretenimientoEntity entretenimiento = new EntretenimientoEntity();
        entretenimientoLogic.createEntretenimiento(entretenimiento);
        EntretenimientoEntity entretenimientoAux = entretenimientoLogic.getEntretenimiento(entretenimiento.getId());

        Assert.assertEquals(entretenimientoAux, entretenimiento);
    }

    /**
     * Test de getEntretenimientos, of class EntretenimientoLogic.
     */
    @Test
    public void getEntretenimientosListTest() {
        List<EntretenimientoEntity> entretenimientos = entretenimientoPersistence.findAll();
        List<EntretenimientoEntity> entretenimientosList = entretenimientoLogic.getEntretenimientos();

        Assert.assertEquals(entretenimientosList, entretenimientos);
    }

    /**
     * Test de getEntretenimiento, of class EntretenimientoLogic.
     */
    @Test
    public void getEntretenimientoTest() {
        EntretenimientoEntity entretenimiento = dataLogic.get(0);
        EntretenimientoEntity entretenimientoAux = entretenimientoLogic.getEntretenimiento(entretenimiento.getId());

        Assert.assertNotNull(entretenimientoAux);

        Assert.assertEquals(entretenimientoAux, entretenimiento);
    }

    /**
     * Test de updateEntretenimiento, of class EntretenimientoLogic.
     */
    @Test
    public void updateEntretenimientoTest() {
        EntretenimientoEntity entretenimiento = dataLogic.get(0);
        EntretenimientoEntity entretenimientoAux = new EntretenimientoEntity();

        entretenimientoAux.setId(entretenimiento.getId());

        entretenimientoLogic.updateEntretenimiento(entretenimientoAux);

        EntretenimientoEntity entretenimientoDone = entityM.find(EntretenimientoEntity.class, entretenimiento.getId());

        Assert.assertEquals(entretenimientoAux, entretenimientoDone);
    }

    /**
     * Test de deleteEntretenimiento, of class EntretenimientoLogic.
     */
    @Test
    public void deleteEntretenimientoTest() {
        EntretenimientoEntity entretenimiento = dataLogic.get(0);
        entretenimientoLogic.deleteEntretenimiento(entretenimiento.getId());
        EntretenimientoEntity deletedEntretenimiento = entityM.find(EntretenimientoEntity.class, entretenimiento.getId());

        Assert.assertNull(deletedEntretenimiento);
    }
    
    /**
     * Test de listImagenes, of class EntretenimientoLogic.
     */
    @Test
    public void getListImagenesTest() {
        EntretenimientoEntity entretenimiento = dataLogic.get(0);
        List<ImagenEntity> imagenes = entretenimientoPersistence.find(entretenimiento.getId()).getImagenes();
        List<ImagenEntity> imagenesList = entretenimientoLogic.listImagenes(entretenimiento.getId());

        Assert.assertEquals(imagenesList, imagenes);
    }

    /**
     * Test de getImagen, of class EntretenimientoLogic.
     */
    @Test
    public void getImagenTest() {
        EntretenimientoEntity entretenimiento = dataLogic.get(0);
        ImagenEntity imagen = entretenimientoPersistence.find(entretenimiento.getId()).getImagenes().get(0);
        ImagenEntity imagenAux = entretenimientoLogic.getImagen(entretenimiento.getId(), imagen.getId());

        Assert.assertNotNull(imagenAux);

        Assert.assertEquals(imagenAux, imagen);
    }

    /**
     * Test de replaceImagen, of class EntretenimientoLogic.
     */
    @Test
    public void replaceImagenTest() {
       EntretenimientoEntity entretenimiento = dataLogic.get(0);
        List<ImagenEntity> imagenes = entretenimientoPersistence.find(entretenimiento.getId()).getImagenes();
        List<ImagenEntity> imagenesAux = new ArrayList<ImagenEntity>();

        imagenesAux = imagenes;

        entretenimientoLogic.replaceImagenes(entretenimiento.getId(), imagenesAux);

        List<ImagenEntity> imagenesDone = entityM.find(EntretenimientoEntity.class, entretenimiento.getId()).getImagenes();

        Assert.assertEquals(imagenesAux, imagenesDone);
    }
}
