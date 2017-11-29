/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.logic;

import co.edu.uniandes.csw.viajes.ejb.UsuarioLogic;
import co.edu.uniandes.csw.viajes.entities.ItinerarioEntity;
import co.edu.uniandes.csw.viajes.entities.TarjetaCreditoEntity;
import co.edu.uniandes.csw.viajes.entities.UsuarioEntity;
import co.edu.uniandes.csw.viajes.persistence.TarjetaCreditoPersistence;
import co.edu.uniandes.csw.viajes.persistence.UsuarioPersistence;
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
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author Vanessa Huertas <tv.huertas10>
 */
@RunWith(Arquillian.class)
public class UsuarioLogicTest {
    
    /**
     * Inyección de la dependencia a la clase UsuarioLogic cuyos métodos se van a
     * probar.
     */
    @Inject
    @PodamExclude
    private UsuarioLogic usuarioLogic;

    /**
     * Inyección de la dependencia a la clase UsuarioPersistence cuyos métodos se
     * van a probar.
     */
    @Inject
    @PodamExclude
    private UsuarioPersistence usuarioPersistence;

    /**
     * Contexto de Persistencia que se va a utilizar para acceder a la Base de
     * datos por fuera de los métodos que se están probando.
     */
    @PersistenceContext
    @PodamExclude
    private EntityManager entityM;

    /**
     * Variable para marcar las transacciones del em anterior cuando se
     * crean/borran datos para las pruebas.
     */
    @Inject
    @PodamExclude
    UserTransaction userTX;

    /**
     * Lista de usuarios
     */
    @PodamExclude
    private List<UsuarioEntity> dataLogic = new ArrayList<UsuarioEntity>();

    /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Blog, el descriptor de la base de
     * datos y el archivo beans.xml para resolver la inyección de dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(UsuarioLogic.class.getPackage())
                .addPackage(UsuarioEntity.class.getPackage())
                .addPackage(UsuarioPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * Constructor por defecto
     */
    public UsuarioLogicTest() {
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
        entityM.createQuery("delete from UsuarioEntity").executeUpdate();
    }

    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();     
        dataLogic = new ArrayList<UsuarioEntity>();
        for (int i = 0; i < 3; i++) {
            UsuarioEntity usuario = factory.manufacturePojo(UsuarioEntity.class);
             
            
            List<ItinerarioEntity> itinerarios = new ArrayList<ItinerarioEntity>();
            for (int j = 0; j < 10; j++) {
                ItinerarioEntity itinerario = factory.manufacturePojo(ItinerarioEntity.class);
                entityM.persist(itinerario);
                itinerarios.add(itinerario);
            } 
            
            usuario.setItinerarios(itinerarios);
            entityM.persist(usuario);
            List<TarjetaCreditoEntity> tarjetas = new ArrayList<TarjetaCreditoEntity>();
            for (int j = 0; j < 10; j++) {
                TarjetaCreditoEntity tarjeta = factory.manufacturePojo(TarjetaCreditoEntity.class);
                entityM.persist(tarjeta);
               tarjeta.setUsuario(usuario);
                tarjetas.add(tarjeta);
                
            }             
            
            usuario.setTarjetas(tarjetas);
            
           
            dataLogic.add(usuario);
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test de createUsuario, of class UsuarioLogic.
     */
    @Test
    public void createUsuarioEntityTest() {
        UsuarioEntity usuario = new UsuarioEntity();
        usuarioLogic.createUsuario(usuario);
        UsuarioEntity usuarioAux = usuarioLogic.getUsuario(usuario.getId());

        Assert.assertEquals(usuarioAux, usuario);
    }

    /**
     * Test de getUsuarios, of class UsuarioLogic.
     */
    @Test
    public void getUsuariosListTest() {
        List<UsuarioEntity> usuarios = usuarioPersistence.findAll();
        List<UsuarioEntity> usuariosList = usuarioLogic.getUsuarios();

        Assert.assertEquals(usuariosList, usuarios);
    }

    /**
     * Test de getUsuario, of class UsuarioLogic.
     */
    @Test
    public void getUsuarioTest() {
        UsuarioEntity usuario = dataLogic.get(0);
        UsuarioEntity usuarioAux = usuarioLogic.getUsuario(usuario.getId());

        Assert.assertNotNull(usuarioAux);

        Assert.assertEquals(usuarioAux, usuario);
    }

    /**
     * Test de updateUsuario, of class UsuarioLogic.
     */
    @Test
    public void updateUsuarioTest() {
        UsuarioEntity usuario = dataLogic.get(0);
        UsuarioEntity usuarioAux = new UsuarioEntity();

        usuarioAux.setId(usuario.getId());

        usuarioLogic.updateUsuario(usuarioAux);

        UsuarioEntity usuarioDone = entityM.find(UsuarioEntity.class, usuario.getId());

        Assert.assertEquals(usuarioAux, usuarioDone);
    }

    /**
     * Test de listItinerario, of class UsuarioLogic.
     */
    @Test
    public void getListItinerariosTest() {
        UsuarioEntity usuario = dataLogic.get(0);
        List<ItinerarioEntity> itinerarios = usuarioPersistence.findById(usuario.getId()).getItinerarios();
        List<ItinerarioEntity> itinerariosList = usuarioLogic.getItinerarios(usuario.getId());

        Assert.assertEquals(itinerariosList, itinerarios);
    }

    /**
     * Test de getItinerario, of class UsuarioLogic.
     */
    @Test
    public void getItinerarioTest() {
        UsuarioEntity usuario = dataLogic.get(0);
        ItinerarioEntity itinerario = usuarioPersistence.findById(usuario.getId()).getItinerarios().get(0);
        ItinerarioEntity itinerarioAux = usuarioLogic.getItinerario(usuario.getId(), itinerario.getId());

        Assert.assertNotNull(itinerarioAux);

        Assert.assertEquals(itinerarioAux, itinerario);
    }

    /**
     * Test de replaceItinerario, of class UsuarioLogic.
     */
    @Test
    public void replaceItinerarioTest() {
        UsuarioEntity usuario = dataLogic.get(0);
        List<ItinerarioEntity> itinerarios = usuarioPersistence.findById(usuario.getId()).getItinerarios();
        List<ItinerarioEntity> itinerariosAux = new ArrayList<ItinerarioEntity>();

        itinerariosAux = itinerarios;

        usuarioLogic.replaceItinerarios(usuario.getId(), itinerariosAux);

        List<ItinerarioEntity> itinerariosDone = entityM.find(UsuarioEntity.class, usuario.getId()).getItinerarios();

        Assert.assertEquals(itinerariosAux, itinerariosDone);
    }
    
    /**
     * Test de listTarjetasCredito, of class UsuarioLogic.
     */
    @Test
    public void getListTarjetasCreditoTest() {
        UsuarioEntity usuario = dataLogic.get(0);
        List<TarjetaCreditoEntity> tarjetas = usuarioPersistence.findById(usuario.getId()).getTarjetas();
        List<TarjetaCreditoEntity> tarjetassList = usuarioLogic.getTarjetasCredito(usuario.getId());

        Assert.assertEquals(tarjetassList, tarjetas);
    }

    /**
     * Test de getTarjetaCredito, of class UsuarioLogic.
     */
    @Test
    public void getTarjetaCreditoTest() {
        UsuarioEntity usuario = dataLogic.get(0);
        TarjetaCreditoEntity tarjeta = usuarioPersistence.findById(usuario.getId()).getTarjetas().get(0);
        TarjetaCreditoEntity tarjetaAux = usuarioLogic.getTarjeta(usuario.getId(), tarjeta.getId());

        Assert.assertNotNull(tarjetaAux);

        Assert.assertEquals(tarjetaAux, tarjeta);
    }

    /**
     * Test de replaceTarjetaCredito, of class UsuarioLogic.
     */
    @Test
    public void replaceTarjetaCreditoTest() {
        UsuarioEntity usuario = dataLogic.get(0);
        List<TarjetaCreditoEntity> tarjetas = usuarioPersistence.findById(usuario.getId()).getTarjetas();
        List<TarjetaCreditoEntity> tarjetasAux = new ArrayList<TarjetaCreditoEntity>();

        tarjetasAux = tarjetas;

        usuarioLogic.replaceTarjetaCredito(usuario.getId(), tarjetasAux);

        List<TarjetaCreditoEntity> tarjetasDone = entityM.find(UsuarioEntity.class, usuario.getId()).getTarjetas();

        Assert.assertEquals(tarjetasAux, tarjetasDone);
    }
}
