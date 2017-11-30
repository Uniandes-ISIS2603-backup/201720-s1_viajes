/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.logic;

import co.edu.uniandes.csw.viajes.ejb.OficinaLogic;
import co.edu.uniandes.csw.viajes.entities.OficinaEntity;
import co.edu.uniandes.csw.viajes.persistence.OficinaPersistence;
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
public class OficinaLogicTest {

    /**
     * Inyección de la dependencia a la clase OficinaLogic cuyos métodos se van
     * a probar.
     */
    @Inject
    private OficinaLogic oficinaLogic;

    /**
     * Inyección de la dependencia a la clase OficinaPersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private OficinaPersistence oficinaPersistence;

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
     * Lista de oficinas
     */
    private List<OficinaEntity> dataLogic = new ArrayList<OficinaEntity>();

    /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Oficina, el descriptor de la base de
     * datos y el archivo beans.xml para resolver la inyección de dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(OficinaLogic.class.getPackage())
                .addPackage(OficinaEntity.class.getPackage())
                .addPackage(OficinaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * Constructor por defecto
     */
    public OficinaLogicTest() {
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
        entityM.createQuery("delete from OficinaEntity").executeUpdate();
    }

    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            OficinaEntity oficina = factory.manufacturePojo(OficinaEntity.class);

            entityM.persist(oficina);
            dataLogic.add(oficina);
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test de createOficina, of class OficinaLogic.
     */
    @Test
    public void createOficinaEntityTest() {
        OficinaEntity oficina = new OficinaEntity();
        oficinaLogic.createOficina(oficina);
        OficinaEntity oficinaAux = oficinaLogic.getOficina(oficina.getId());

        Assert.assertEquals(oficinaAux, oficina);
    }

    /**
     * Test de getOficinas, of class OficinaLogic.
     */
    @Test
    public void getOficinasListTest() {
        List<OficinaEntity> oficinas = oficinaPersistence.findAll();
        List<OficinaEntity> oficinasList = oficinaLogic.getOficinas();

        Assert.assertEquals(oficinasList, oficinas);
    }

    /**
     * Test de getOficina, of class OficinaLogic.
     */
    @Test
    public void getOficinaTest() {
        OficinaEntity oficina = dataLogic.get(0);
        OficinaEntity oficinaAux = oficinaLogic.getOficina(oficina.getId());

        Assert.assertNotNull(oficinaAux);

        Assert.assertEquals(oficinaAux, oficina);
    }

    /**
     * Test de updateOficina, of class OficinaLogic.
     */
    @Test
    public void updateOficinaTest() {
        OficinaEntity oficina = dataLogic.get(0);
        OficinaEntity oficinaAux = new OficinaEntity();

        oficinaAux.setId(oficina.getId());

        oficinaLogic.updateOficina(oficinaAux);

        OficinaEntity oficinaDone = entityM.find(OficinaEntity.class, oficina.getId());

        Assert.assertEquals(oficinaAux, oficinaDone);
    }

    /**
     * Test de deleteOficina, of class OficinaLogic.
     */
    @Test
    public void deleteOficinaTest() {
        OficinaEntity oficina = dataLogic.get(0);
        oficinaLogic.deleteOficina(oficina.getId());
        OficinaEntity deletedOficina = entityM.find(OficinaEntity.class, oficina.getId());

        Assert.assertNull(deletedOficina);
    }
}
