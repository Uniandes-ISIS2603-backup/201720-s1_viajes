/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.logic;

import co.edu.uniandes.csw.viajes.ejb.ItinerarioLogic;
import co.edu.uniandes.csw.viajes.entities.EntretenimientoEntity;
import co.edu.uniandes.csw.viajes.entities.GuiaEntity;
import co.edu.uniandes.csw.viajes.entities.HospedajeEntity;
import co.edu.uniandes.csw.viajes.entities.ItinerarioEntity;
import co.edu.uniandes.csw.viajes.entities.TransporteEntity;
import co.edu.uniandes.csw.viajes.persistence.ItinerarioPersistence;
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
public class ItinerarioLogicTest {
    
    /**
     * Inyección de la dependencia a la clase ItinerarioLogic cuyos métodos se van a
     * probar.
     */
    @Inject
    private ItinerarioLogic itinerarioLogic;

    /**
     * Inyección de la dependencia a la clase ItinerarioPersistence cuyos métodos se
     * van a probar.
     */
    @Inject
    private ItinerarioPersistence itinerarioPersistence;

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
     * Lista de itinerarios
     */
    private List<ItinerarioEntity> dataLogic = new ArrayList<ItinerarioEntity>();

    /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Itinerario, el descriptor de la base de
     * datos y el archivo beans.xml para resolver la inyección de dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ItinerarioLogic.class.getPackage())
                .addPackage(ItinerarioEntity.class.getPackage())
                .addPackage(ItinerarioPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * Constructor por defecto
     */
    public ItinerarioLogicTest() {
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
        entityM.createQuery("delete from ItinerarioEntity").executeUpdate();
    }

    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();        
        for (int i = 0; i < 3; i++) {
            ItinerarioEntity itinerario = factory.manufacturePojo(ItinerarioEntity.class);
            List<GuiaEntity> guias = new ArrayList<GuiaEntity>();
            for (int j = 0; j < 10; j++) {
                GuiaEntity guia = factory.manufacturePojo(GuiaEntity.class);
                entityM.persist(guia);
                guias.add(guia);
            } 
            
            List<EntretenimientoEntity> entretenimientos = new ArrayList<EntretenimientoEntity>();
            for (int j = 0; j < 10; j++) {
                EntretenimientoEntity entretenimiento = factory.manufacturePojo(EntretenimientoEntity.class);
                entityM.persist(entretenimiento);
                entretenimientos.add(entretenimiento);
            } 
            
            List<HospedajeEntity> hospedajes = new ArrayList<HospedajeEntity>();
            for (int j = 0; j < 10; j++) {
                HospedajeEntity hospedaje = factory.manufacturePojo(HospedajeEntity.class);
                entityM.persist(hospedaje);
                hospedajes.add(hospedaje);
            } 
            
            List<TransporteEntity> transportes = new ArrayList<TransporteEntity>();
            for (int j = 0; j < 10; j++) {
                TransporteEntity transporte = factory.manufacturePojo(TransporteEntity.class);
                entityM.persist(transporte);
                transportes.add(transporte);
            } 
            
            itinerario.setGias(guias);
            itinerario.setEntretenimientos(entretenimientos);
            itinerario.setHospedajes(hospedajes);
            itinerario.setTransportes(transportes);
            
            entityM.persist(itinerario);
            dataLogic.add(itinerario);
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test de createItinerario, of class ItinerarioLogic.
     */
    @Test
    public void createItinerarioEntityTest() {
        ItinerarioEntity itinerario = new ItinerarioEntity();
        itinerarioLogic.createItinerario(itinerario);
        ItinerarioEntity itinerarioAux = itinerarioLogic.getItinerario(itinerario.getId());

        Assert.assertEquals(itinerarioAux, itinerario);
    }

    /**
     * Test de getItinerarios, of class ItinerarioLogic.
     */
    @Test
    public void getItinerariosListTest() {
        List<ItinerarioEntity> itinerarios = itinerarioPersistence.findAll();
        List<ItinerarioEntity> itinerariosList = itinerarioLogic.getItinerarios();

        Assert.assertEquals(itinerariosList, itinerarios);
    }

    /**
     * Test de getItinerario, of class ItinerarioLogic.
     */
    @Test
    public void getItinerarioTest() {
        ItinerarioEntity itinerario = dataLogic.get(0);
        ItinerarioEntity itinerarioAux = itinerarioLogic.getItinerario(itinerario.getId());

        Assert.assertNotNull(itinerarioAux);

        Assert.assertEquals(itinerarioAux, itinerario);
    }

    /**
     * Test de updateItinerario, of class ItinerarioLogic.
     */
    @Test
    public void updateItinerarioTest() {
        ItinerarioEntity itinerario = dataLogic.get(0);
        ItinerarioEntity itinerarioAux = new ItinerarioEntity();

        itinerarioAux.setId(itinerario.getId());

        itinerarioLogic.updateItinerario(itinerarioAux);

        ItinerarioEntity itinerarioDone = entityM.find(ItinerarioEntity.class, itinerario.getId());

        Assert.assertEquals(itinerarioAux, itinerarioDone);
    }

    /**
     * Test de deleteItinerario, of class ItinerarioLogic.
     */
    @Test
    public void deleteItinerarioTest() {
        ItinerarioEntity itinerario = dataLogic.get(0);
        itinerarioLogic.deleteItinerario(itinerario.getId());
        ItinerarioEntity deletedItinerario = entityM.find(ItinerarioEntity.class, itinerario.getId());

        Assert.assertNull(deletedItinerario);
    }

    /**
     * Test de listGuias, of class ItinerarioLogic.
     */
    @Test
    public void getListGuiasTest() {
        ItinerarioEntity itinerario = dataLogic.get(0);
        List<GuiaEntity> guias = itinerarioPersistence.find(itinerario.getId()).getGias();
        List<GuiaEntity> guiasList = itinerarioLogic.listGuias(itinerario.getId());

        Assert.assertEquals(guiasList, guias);
    }

    /**
     * Test de getGuia, of class ItinerarioLogic.
     */
    @Test
    public void getGuiaTest() {
        ItinerarioEntity itinerario = dataLogic.get(0);
        GuiaEntity guia = itinerarioPersistence.find(itinerario.getId()).getGias().get(0);
        GuiaEntity guiaAux = itinerarioLogic.getGuia(itinerario.getId(), guia.getId());

        Assert.assertNotNull(guiaAux);

        Assert.assertEquals(guiaAux, guia);
    }
    
    /**
     * Test de listEntretenimientos, of class ItinerarioLogic.
     */
    @Test
    public void getListEntretenimientosTest() {
        ItinerarioEntity itinerario = dataLogic.get(0);
        List<EntretenimientoEntity> entretenimientos = itinerarioPersistence.find(itinerario.getId()).getEntretenimientos();
        List<EntretenimientoEntity> entretenimientosList = itinerarioLogic.listEntretenimientos(itinerario.getId());

        Assert.assertEquals(entretenimientosList, entretenimientos);
    }

    /**
     * Test de getEntretenimiento, of class ItinerarioLogic.
     */
    @Test
    public void getEntretenimientoTest() {
        ItinerarioEntity itinerario = dataLogic.get(0);
        EntretenimientoEntity entretenimiento = itinerarioPersistence.find(itinerario.getId()).getEntretenimientos().get(0);
        EntretenimientoEntity entretenimientoAux = itinerarioLogic.getEntretenimiento(itinerario.getId(), entretenimiento.getId());

        Assert.assertNotNull(entretenimientoAux);

        Assert.assertEquals(entretenimientoAux, entretenimiento);
    }
    
    /**
     * Test de listHospedajes, of class ItinerarioLogic.
     */
    @Test
    public void getListHospedajesTest() {
        ItinerarioEntity itinerario = dataLogic.get(0);
        List<HospedajeEntity> hospedajes = itinerarioPersistence.find(itinerario.getId()).getHospedajes();
        List<HospedajeEntity> hospedajesList = itinerarioLogic.listHospedajes(itinerario.getId());

        Assert.assertEquals(hospedajesList, hospedajes);
    }

    /**
     * Test de getHospedaje, of class ItinerarioLogic.
     */
    @Test
    public void getHospedajeTest() {
        ItinerarioEntity itinerario = dataLogic.get(0);
        HospedajeEntity hospedaje = itinerarioPersistence.find(itinerario.getId()).getHospedajes().get(0);
        HospedajeEntity hospedajeAux = itinerarioLogic.getHospedaje(itinerario.getId(), hospedaje.getId());

        Assert.assertNotNull(hospedajeAux);

        Assert.assertEquals(hospedajeAux, hospedaje);
    }
    
    /**
     * Test de listTransportes, of class ItinerarioLogic.
     */
    @Test
    public void getListTransportesTest() {
        ItinerarioEntity itinerario = dataLogic.get(0);
        List<TransporteEntity> transportes = itinerarioPersistence.find(itinerario.getId()).getTransportes();
        List<TransporteEntity> transportesList = itinerarioLogic.listTransportes(itinerario.getId());

        Assert.assertEquals(transportesList, transportes);
    }

    /**
     * Test de getTransporte, of class ItinerarioLogic.
     */
    @Test
    public void getTransporteTest() {
        ItinerarioEntity itinerario = dataLogic.get(0);
        TransporteEntity transporte = itinerarioPersistence.find(itinerario.getId()).getTransportes().get(0);
        TransporteEntity transporteAux = itinerarioLogic.getTransporte(itinerario.getId(), transporte.getId());

        Assert.assertNotNull(transporteAux);

        Assert.assertEquals(transporteAux, transporte);
    }
}
