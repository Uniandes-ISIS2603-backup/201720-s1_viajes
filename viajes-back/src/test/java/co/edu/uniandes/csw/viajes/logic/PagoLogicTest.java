/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.logic;

import co.edu.uniandes.csw.viajes.ejb.PagoLogic;
import co.edu.uniandes.csw.viajes.entities.PagoEntity;
import co.edu.uniandes.csw.viajes.entities.TarjetaCreditoEntity;
import co.edu.uniandes.csw.viajes.persistence.PagoPersistence;
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
public class PagoLogicTest {

    /**
     * Inyección de la dependencia a la clase PagoLogic cuyos métodos se van a
     * probar.
     */
    @Inject
    private PagoLogic pagoLogic;

    /**
     * Inyección de la dependencia a la clase PagoPersistence cuyos métodos se
     * van a probar.
     */
    @Inject
    private PagoPersistence pagoPersistence;

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
    private List<PagoEntity> dataLogic = new ArrayList<PagoEntity>();

    /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Pago, el descriptor de la base de
     * datos y el archivo beans.xml para resolver la inyección de dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(PagoLogic.class.getPackage())
                .addPackage(PagoEntity.class.getPackage())
                .addPackage(PagoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * Constructor por defecto
     */
    public PagoLogicTest() {
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
        entityM.createQuery("delete from PagoEntity").executeUpdate();
    }

    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            PagoEntity pago = factory.manufacturePojo(PagoEntity.class);
            TarjetaCreditoEntity tarjeta = factory.manufacturePojo(TarjetaCreditoEntity.class);

            entityM.persist(tarjeta);

            pago.setTarjeta(tarjeta);

            entityM.persist(pago);
            dataLogic.add(pago);
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test de createPago, of class PagoLogic.
     */
    @Test
    public void createPagoEntityTest() {
        PagoEntity pago = new PagoEntity();
        pagoLogic.createPago(pago);
        PagoEntity pagoAux = pagoLogic.getPago(pago.getId());

        Assert.assertEquals(pagoAux, pago);
    }

    /**
     * Test de getPagos, of class PagoLogic.
     */
    @Test
    public void getPagosListTest() {
        List<PagoEntity> pagos = pagoPersistence.findAll();
        List<PagoEntity> pagosList = pagoLogic.getPagos();

        Assert.assertEquals(pagosList, pagos);
    }

    /**
     * Test de getPago, of class PagoLogic.
     */
    @Test
    public void getPagoTest() {
        PagoEntity pago = dataLogic.get(0);
        PagoEntity pagoAux = pagoLogic.getPago(pago.getId());

        Assert.assertNotNull(pagoAux);

        Assert.assertEquals(pagoAux, pago);
    }

    /**
     * Test de updatePago, of class PagoLogic.
     */
    @Test
    public void updatePagoTest() {
        PagoEntity pago = dataLogic.get(0);
        PagoEntity pagoAux = new PagoEntity();

        pagoAux.setId(pago.getId());

        pagoLogic.updatePago(pagoAux);

        PagoEntity pagoDone = entityM.find(PagoEntity.class, pago.getId());

        Assert.assertEquals(pagoAux, pagoDone);
    }

    /**
     * Test de deletePago, of class PagoLogic.
     */
    @Test
    public void deletePagoTest() {
        PagoEntity pago = dataLogic.get(0);
        pagoLogic.deletePago(pago.getId());
        PagoEntity deletedPago = entityM.find(PagoEntity.class, pago.getId());

        Assert.assertNull(deletedPago);
    }

    /**
     * Test de getTarjetaCredito, of class PagoLogic.
     */
    @Test
    public void getTarjetaCreditoTest() {
        PagoEntity pago = dataLogic.get(0);
        TarjetaCreditoEntity tarjeta = pagoPersistence.findById(pago.getId()).getTarjeta();
        TarjetaCreditoEntity tarjetaAux = pagoLogic.getTarjetaCredito(pago.getId());

        Assert.assertNotNull(tarjetaAux);

        Assert.assertEquals(tarjetaAux, tarjeta);
    }
}
