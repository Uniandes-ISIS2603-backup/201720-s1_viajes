/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.logic;

import co.edu.uniandes.csw.viajes.ejb.TarjetaCreditoLogic;
import co.edu.uniandes.csw.viajes.ejb.*;
import co.edu.uniandes.csw.viajes.entities.PagoEntity;
import co.edu.uniandes.csw.viajes.entities.TarjetaCreditoEntity;
import co.edu.uniandes.csw.viajes.entities.UsuarioEntity;
import co.edu.uniandes.csw.viajes.persistence.PagoPersistence;
import co.edu.uniandes.csw.viajes.persistence.TarjetaCreditoPersistence;
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
public class TarjetaCreditoLogicTest {

    /**
     * Inyección de la dependencia a la clase TarjetaCreditoLogic cuyos métodos
     * se van a probar.
     */
    @Inject
    private TarjetaCreditoLogic tarjetaCreditoLogic;

    /**
     * Inyección de la dependencia a la clase TarjetaCreditoPersistence cuyos
     * métodos se van a probar.
     */
    @Inject
    private TarjetaCreditoPersistence tarjetaCreditoPersistence;

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
     * Lista de blogs
     */
    private List<TarjetaCreditoEntity> dataLogic = new ArrayList<TarjetaCreditoEntity>();

    /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Blog, el descriptor de la base de
     * datos y el archivo beans.xml para resolver la inyección de dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(PagoEntity.class.getPackage())
                .addPackage(PagoLogic.class.getPackage())
                .addPackage(PagoPersistence.class.getPackage())
                .addPackage(TarjetaCreditoLogic.class.getPackage())
                .addPackage(TarjetaCreditoEntity.class.getPackage())
                .addPackage(TarjetaCreditoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * Constructor por defecto
     */
    public TarjetaCreditoLogicTest() {
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
        entityM.createQuery("delete from TarjetaCreditoEntity").executeUpdate();
    }

    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            TarjetaCreditoEntity tarjeta = factory.manufacturePojo(TarjetaCreditoEntity.class);


            List<PagoEntity> pagos = new ArrayList<PagoEntity>();
            for (int j = 0; j < 10; j++) {
                PagoEntity pago = factory.manufacturePojo(PagoEntity.class);
                entityM.persist(pago);
                pagos.add(pago);
            }

            tarjeta.setPagos(pagos);
            
            UsuarioEntity usuario = factory.manufacturePojo(UsuarioEntity.class);
            entityM.persist(usuario);
            tarjeta.setUsuario(usuario);

            entityM.persist(tarjeta);
            dataLogic.add(tarjeta);
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test de createTarjetaCredito, of class TarjetaCreditoLogic.
     */
    @Test
    public void createTarjetaCreditoEntityTest() {
        TarjetaCreditoEntity tarjeta = new TarjetaCreditoEntity();
        tarjetaCreditoLogic.createTarjetaCredito(tarjeta);
        TarjetaCreditoEntity tarjetaAux = tarjetaCreditoLogic.getTarjetaCredito(tarjeta.getId());

        Assert.assertEquals(tarjetaAux, tarjeta);
    }

    /**
     * Test de getTarjetasCredito, of class TarjetaCreditoLogic.
     */
    @Test
    public void getTarjetasCreditoListTest() {
        List<TarjetaCreditoEntity> tarjetas = tarjetaCreditoPersistence.findAll();
        List<TarjetaCreditoEntity> tarjetasList = tarjetaCreditoLogic.getTarjetasCredito();

        Assert.assertEquals(tarjetasList, tarjetas);
    }

    /**
     * Test de getTarjetaCredito, of class TarjetaCreditoLogic.
     */
    @Test
    public void getTarjetaCreditoTest() {
        TarjetaCreditoEntity tarjeta = dataLogic.get(0);
        TarjetaCreditoEntity tarjetaAux = tarjetaCreditoLogic.getTarjetaCredito(tarjeta.getId());

        Assert.assertNotNull(tarjetaAux);

        Assert.assertEquals(tarjetaAux, tarjeta);
    }

    /**
     * Test de updateTarjetaCredito, of class TarjetaCreditoLogic.
     */
    @Test
    public void updateTarjetaCreditoTest() {
        TarjetaCreditoEntity tarjeta = dataLogic.get(0);
        TarjetaCreditoEntity tarjetaAux = new TarjetaCreditoEntity();

        tarjetaAux.setId(tarjeta.getId());

        tarjetaCreditoLogic.updateTarjetaCredito(tarjetaAux);

        TarjetaCreditoEntity tarjetaDone = entityM.find(TarjetaCreditoEntity.class, tarjeta.getId());

        Assert.assertEquals(tarjetaAux, tarjetaDone);
    }

    /**
     * Test de deleteTarjetaCredito, of classTarjetaCreditoLogic.
     */
    @Test
    public void deleteTarjetaCreditoTest() {
        TarjetaCreditoEntity tarjeta = dataLogic.get(0);
        tarjetaCreditoLogic.deleteTarjetaCredito(tarjeta.getId());
        TarjetaCreditoEntity deletedTarjetaCredito = entityM.find(TarjetaCreditoEntity.class, tarjeta.getId());

        Assert.assertNull(deletedTarjetaCredito);
    }

    /**
     * Test de listPagos, of class TarjetaCreditoLogic.
     */
    @Test
    public void getListPagosTest() {
        TarjetaCreditoEntity tarjeta = dataLogic.get(0);
        List<PagoEntity> pagos = tarjetaCreditoPersistence.findById(tarjeta.getId()).getPagos();
        List<PagoEntity> pagosList = tarjetaCreditoLogic.getPagos(tarjeta.getId());

        Assert.assertEquals(pagosList, pagos);
    }

    /**
     * Test de getUsuario, of class TarjetaCreditoLogic.
     */
    @Test
    public void getUsuarioTest() {
        TarjetaCreditoEntity tarjeta = dataLogic.get(0);
        UsuarioEntity usuario = tarjetaCreditoPersistence.findById(tarjeta.getId()).getUsuario();
        UsuarioEntity usuarioAux = tarjetaCreditoLogic.getUsuario(tarjeta.getId());

        Assert.assertNotNull(usuarioAux);

        Assert.assertEquals(usuarioAux, usuario);
    }

    /**
     * Test de replacePago, of class TarjetaCreditoLogic.
     */
    @Test
    public void replacePagoTest() {
        TarjetaCreditoEntity tarjeta = dataLogic.get(0);
        List<PagoEntity> pagos = tarjetaCreditoPersistence.findById(tarjeta.getId()).getPagos();
        List<PagoEntity> pagosAux = new ArrayList<PagoEntity>();

        pagosAux = pagos;

        tarjetaCreditoLogic.replacePago(tarjeta.getId(), pagosAux);

        List<PagoEntity> pagosDone = entityM.find(TarjetaCreditoEntity.class, tarjeta.getId()).getPagos();

        Assert.assertEquals(pagosAux, pagosDone);
    }
}
