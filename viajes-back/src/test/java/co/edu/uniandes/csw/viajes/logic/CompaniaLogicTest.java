/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.logic;

import co.edu.uniandes.csw.viajes.ejb.CompaniaLogic;
import co.edu.uniandes.csw.viajes.entities.CompaniaEntity;
import co.edu.uniandes.csw.viajes.persistence.CompaniaPersistence;
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
public class CompaniaLogicTest {
    
    
    /**
     * Inyección de la dependencia a la clase CompaniaLogic cuyos métodos se van
     * a probar.
     */
    @Inject
    private CompaniaLogic companiaLogic;

    /**
     * Inyección de la dependencia a la clase CompaniaPersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private CompaniaPersistence companiaPersistence;

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
     * Lista de companias
     */
    private List<CompaniaEntity> dataLogic = new ArrayList<CompaniaEntity>();

    /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Compania, el descriptor de la base de
     * datos y el archivo beans.xml para resolver la inyección de dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(CompaniaLogic.class.getPackage())
                .addPackage(CompaniaEntity.class.getPackage())
                .addPackage(CompaniaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * Constructor por defecto
     */
    public CompaniaLogicTest() {
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
        entityM.createQuery("delete from CompaniaEntity").executeUpdate();
    }

    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            CompaniaEntity compania = factory.manufacturePojo(CompaniaEntity.class);

            entityM.persist(compania);
            dataLogic.add(compania);
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test de createCompania, of class CompaniaLogic.
     */
    @Test
    public void createCompaniaEntityTest() {
        CompaniaEntity compania = new CompaniaEntity();
        companiaLogic.createCompania(compania);
        CompaniaEntity companiaAux = companiaLogic.getCompania(compania.getId());

        Assert.assertEquals(companiaAux, compania);
    }

    /**
     * Test de getCompanias, of class CompaniaLogic.
     */
    @Test
    public void getCompaniasListTest() {
        List<CompaniaEntity> companias = companiaPersistence.findAll();
        List<CompaniaEntity> companiasList = companiaLogic.getCompanias();

        Assert.assertEquals(companiasList, companias);
    }

    /**
     * Test de getCompania, of class CompaniaLogic.
     */
    @Test
    public void getCompaniaTest() {
        CompaniaEntity compania = dataLogic.get(0);
        CompaniaEntity companiaAux = companiaLogic.getCompania(compania.getId());

        Assert.assertNotNull(companiaAux);

        Assert.assertEquals(companiaAux, compania);
    }

    /**
     * Test de updateCompania, of class CompaniaLogic.
     */
    @Test
    public void updateCompaniaTest() {
        CompaniaEntity compania = dataLogic.get(0);
        CompaniaEntity companiaAux = new CompaniaEntity();

        companiaAux.setId(compania.getId());

        companiaLogic.updateCompania(companiaAux);

        CompaniaEntity companiaDone = entityM.find(CompaniaEntity.class, compania.getId());

        Assert.assertEquals(companiaAux, companiaDone);
    }

    /**
     * Test de deleteCompania, of class CompaniaLogic.
     */
    @Test
    public void deleteCompaniaTest() {
        CompaniaEntity compania = dataLogic.get(0);
        companiaLogic.deleteCompania(compania.getId());
        CompaniaEntity deletedCompania = entityM.find(CompaniaEntity.class, compania.getId());

        Assert.assertNull(deletedCompania);
    }
}
