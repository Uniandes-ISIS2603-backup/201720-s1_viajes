/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.logic;

import co.edu.uniandes.csw.viajes.ejb.UbicacionLogic;
import co.edu.uniandes.csw.viajes.entities.UbicacionEntity;
import co.edu.uniandes.csw.viajes.persistence.UbicacionPersistence;
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
public class UbicacionLogicTest {

    /**
     * Inyección de la dependencia a la clase UbicacionLogic cuyos métodos se
     * van a probar.
     */
    @Inject
    private UbicacionLogic ubicacionLogic;

    /**
     * Inyección de la dependencia a la clase UbicacionPersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private UbicacionPersistence ubicacionPersistence;

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
     * Lista de ubicaciones
     */
    private List<UbicacionEntity> dataLogic = new ArrayList<UbicacionEntity>();

    /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Ubicacion, el descriptor de la
     * base de datos y el archivo beans.xml para resolver la inyección de
     * dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(UbicacionLogic.class.getPackage())
                .addPackage(UbicacionEntity.class.getPackage())
                .addPackage(UbicacionPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * Constructor por defecto
     */
    public UbicacionLogicTest() {
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
        entityM.createQuery("delete from UbicacionEntity").executeUpdate();
    }

    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            UbicacionEntity ubicacion = factory.manufacturePojo(UbicacionEntity.class);

            entityM.persist(ubicacion);
            dataLogic.add(ubicacion);
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test de createUbicacion, of class UbicacionLogic.
     */
    @Test
    public void createUbicacionEntityTest() {
        UbicacionEntity ubicacion = new UbicacionEntity();
        ubicacionLogic.createUbicacion(ubicacion);
        UbicacionEntity ubicacionAux = ubicacionLogic.getUbicacion(ubicacion.getId());

        Assert.assertEquals(ubicacionAux, ubicacion);
    }

    /**
     * Test de getUbicaciones, of class UbicacionLogic.
     */
    @Test
    public void getUbicacionesListTest() {
        List<UbicacionEntity> ubicaciones = ubicacionPersistence.findAll();
        List<UbicacionEntity> ubicacionesList = ubicacionLogic.getUbicaciones();

        Assert.assertEquals(ubicacionesList, ubicaciones);
    }

    /**
     * Test de getUbicacion, of class UbicacionLogic.
     */
    @Test
    public void getUbicacionTest() {
        UbicacionEntity ubicacion = dataLogic.get(0);
        UbicacionEntity ubicacionAux = ubicacionLogic.getUbicacion(ubicacion.getId());

        Assert.assertNotNull(ubicacionAux);

        Assert.assertEquals(ubicacionAux, ubicacion);
    }

    /**
     * Test de updateUbicacion, of class UbicacionLogic.
     */
    @Test
    public void updateUbicacionTest() {
        UbicacionEntity ubicacion = dataLogic.get(0);
        UbicacionEntity ubicacionAux = new UbicacionEntity();

        ubicacionAux.setId(ubicacion.getId());

        ubicacionLogic.updateUbicacion(ubicacionAux);

        UbicacionEntity ubicacionDone = entityM.find(UbicacionEntity.class, ubicacion.getId());

        Assert.assertEquals(ubicacionAux, ubicacionDone);
    }

    /**
     * Test de deleteUbicacion, of class UbicacionLogic.
     */
    @Test
    public void deleteUbicacionTest() {
        UbicacionEntity ubicacion = dataLogic.get(0);
        ubicacionLogic.deleteUbicacion(ubicacion.getId());
        UbicacionEntity deletedUbicacion = entityM.find(UbicacionEntity.class, ubicacion.getId());

        Assert.assertNull(deletedUbicacion);
    }
}
