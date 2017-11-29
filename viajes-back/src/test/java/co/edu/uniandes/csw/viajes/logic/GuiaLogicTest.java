/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.logic;

import co.edu.uniandes.csw.viajes.ejb.GuiaLogic;
import co.edu.uniandes.csw.viajes.entities.GuiaEntity;
import co.edu.uniandes.csw.viajes.persistence.GuiaPersistence;
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
public class GuiaLogicTest {
    
    /**
     * Inyección de la dependencia a la clase GuiaLogic cuyos métodos se van
     * a probar.
     */
    @Inject
    private GuiaLogic guiaLogic;

    /**
     * Inyección de la dependencia a la clase GuiaPersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private GuiaPersistence guiaPersistence;

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
     * Lista de guias
     */
    private List<GuiaEntity> dataLogic = new ArrayList<GuiaEntity>();

    /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Guia, el descriptor de la base de
     * datos y el archivo beans.xml para resolver la inyección de dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(GuiaLogic.class.getPackage())
                .addPackage(GuiaEntity.class.getPackage())
                .addPackage(GuiaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * Constructor por defecto
     */
    public GuiaLogicTest() {
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
        entityM.createQuery("delete from GuiaEntity").executeUpdate();
    }

    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            GuiaEntity guia = factory.manufacturePojo(GuiaEntity.class);

            entityM.persist(guia);
            dataLogic.add(guia);
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test de createGuia, of class GuiaLogic.
     */
    @Test
    public void createGuiaEntityTest() {
        GuiaEntity guia = new GuiaEntity();
        guiaLogic.createGuia(guia);
        GuiaEntity guiaAux = guiaLogic.getGuia(guia.getId());

        Assert.assertEquals(guiaAux, guia);
    }

    /**
     * Test de getGuias, of class GuiaLogic.
     */
    @Test
    public void getGuiasListTest() {
        List<GuiaEntity> guias = guiaPersistence.findAll();
        List<GuiaEntity> guiasList = guiaLogic.getGuias();

        Assert.assertEquals(guiasList, guias);
    }

    /**
     * Test de getGuia, of class GuiaLogic.
     */
    @Test
    public void getGuiaTest() {
        GuiaEntity guia = dataLogic.get(0);
        GuiaEntity guiaAux = guiaLogic.getGuia(guia.getId());

        Assert.assertNotNull(guiaAux);

        Assert.assertEquals(guiaAux, guia);
    }

    /**
     * Test de updateGuia, of class GuiaLogic.
     */
    @Test
    public void updateGuiaTest() {
        GuiaEntity guia = dataLogic.get(0);
        GuiaEntity guiaAux = new GuiaEntity();

        guiaAux.setId(guia.getId());

        guiaLogic.updateGuia(guiaAux);

        GuiaEntity guiaDone = entityM.find(GuiaEntity.class, guia.getId());

        Assert.assertEquals(guiaAux, guiaDone);
    }

    /**
     * Test de deleteGuia, of class GuiaLogic.
     */
    @Test
    public void deleteGuiaTest() {
        GuiaEntity guia = dataLogic.get(0);
        guiaLogic.deleteGuia(guia.getId());
        GuiaEntity deletedGuia = entityM.find(GuiaEntity.class, guia.getId());

        Assert.assertNull(deletedGuia);
    }
}
