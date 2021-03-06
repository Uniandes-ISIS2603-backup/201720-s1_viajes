package co.edu.uniandes.csw.viajes.persistence;


import co.edu.uniandes.csw.viajes.entities.UsuarioEntity;
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
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tv.huertas10
 */
@RunWith(Arquillian.class)
public class UsuarioPersistenceTest
{
    /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Pago, el descriptor de la
     * base de datos y el archivo beans.xml para resolver la inyección de
     * dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(UsuarioEntity.class.getPackage())
                .addPackage(UsuarioPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
     /**
     * Inyección de la dependencia a la clase UsuarioPersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private UsuarioPersistence usuarioPersistence;
    
    /**
     * Contexto de Persistencia que se va a utilizar para acceder a la Base de
     * datos por fuera de los métodos que se están probando.
     */
    @PersistenceContext
    private EntityManager em;
    
    /**
     * Variable para martcar las transacciones del em anterior cuando se
     * crean/borran datos para las pruebas.
     */
    @Inject
    UserTransaction utx;
    
       /**
     * Configuración inicial de la prueba.
     *
     *
     */
    @Before
    public void setUp() {
        try {
            utx.begin();
            em.joinTransaction();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
     }
      

     /**
     * Limpia las tablas que están implicadas en la prueba.
     *
     *
     */
    private void clearData() 
    {
        em.createQuery("delete from UsuarioEntity").executeUpdate();
    }
    
    private List<UsuarioEntity> data = new ArrayList<UsuarioEntity>();
    
      /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() 
    {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            UsuarioEntity entity = factory.manufacturePojo( UsuarioEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }
    
    /**
     * Prueba para crear un Usuario.
     *
     *
     */
    @Test
    public void createUsuarioTest() {
        PodamFactory factory = new PodamFactoryImpl();
        UsuarioEntity newEntity = factory.manufacturePojo(UsuarioEntity.class);
        UsuarioEntity result = usuarioPersistence.create(newEntity);

        Assert.assertNotNull(result);

        UsuarioEntity entity = em.find(UsuarioEntity.class, result.getId());
                
        Assert.assertEquals(newEntity.getNombre(), entity.getNombre());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getItinerarios(), entity.getItinerarios());
        Assert.assertEquals(newEntity.getTarjetas(), entity.getTarjetas());
        Assert.assertEquals(newEntity.getBlog(), entity.getBlog());        
        Assert.assertTrue(newEntity.equals(entity));
        Assert.assertEquals(newEntity.hashCode(), entity.hashCode());
        
        entity.setItinerarios(newEntity.getItinerarios());
        Assert.assertEquals("Incoherencia de datos", entity.getItinerarios(), newEntity.getItinerarios()); 
        
        entity.setTarjetas(newEntity.getTarjetas());
        Assert.assertEquals("Incoherencia de datos", entity.getTarjetas(), newEntity.getTarjetas()); 
        
        entity.setBlog(newEntity.getBlog());
        Assert.assertEquals("Incoherencia de datos", entity.getBlog(), newEntity.getBlog()); 
    }
    
    /**
     * Prueba para consultar la lista de Usuarios.
     *
     *
     */
    @Test
    public void getUsuariosTest() {
        List<UsuarioEntity> list = usuarioPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (UsuarioEntity ent : list) {
            boolean found = false;
            for (UsuarioEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
     /**
     * Prueba para consultar un Usuario.
     *
     *
     */
    @Test
    public void getUsuarioTest() {
        UsuarioEntity entity = data.get(0);
        UsuarioEntity newEntity = usuarioPersistence.findById(entity.getId());
        Assert.assertNotNull(newEntity);
        
        Assert.assertEquals(entity.getNombre(), newEntity.getNombre());
        Assert.assertEquals(entity.getId(), newEntity.getId());
        Assert.assertEquals(entity.getItinerarios(), newEntity.getItinerarios());
        Assert.assertEquals(entity.getTarjetas(), newEntity.getTarjetas());
        Assert.assertEquals(entity.getBlog(), newEntity.getBlog());   
        Assert.assertTrue(newEntity.equals(entity));
        Assert.assertEquals(newEntity.hashCode(), entity.hashCode());
    }
    
    /**
     * Prueba para consultar un Usuario.
     * 
     * 
     */
    @Test
    public void getUsuarioNameTest()
    {
        UsuarioEntity entity = data.get(0);

        UsuarioEntity newEntity = usuarioPersistence.findByName(entity.getNombre());
        Assert.assertNotNull(newEntity);

        Assert.assertEquals(entity.getNombre(), newEntity.getNombre());
        Assert.assertEquals(entity.getId(), newEntity.getId());
        Assert.assertEquals(entity.getItinerarios(), newEntity.getItinerarios());
        Assert.assertEquals(entity.getTarjetas(), newEntity.getTarjetas());
        Assert.assertEquals(entity.getBlog(), newEntity.getBlog());  
        Assert.assertTrue(newEntity.equals(entity));
        Assert.assertEquals(newEntity.hashCode(), entity.hashCode());   
    }

     /**
     * Prueba para eliminar un Usuario.
     *
     *
     */
    @Test
    public void deleteUsuarioTest() {
        UsuarioEntity entity = data.get(0);
        usuarioPersistence.delete(entity.getId());
        UsuarioEntity deleted = em.find(UsuarioEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
 /**
     * Prueba para actualizar un Usuario.
     *
     *
     */
    @Test
    public void updateUsuarioTest() {
        UsuarioEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        UsuarioEntity newEntity = factory.manufacturePojo(UsuarioEntity.class);

        newEntity.setId(entity.getId());

        usuarioPersistence.update(newEntity);

        UsuarioEntity resp = em.find(UsuarioEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getNombre(), resp.getNombre());
        Assert.assertEquals(newEntity.getId(), resp.getId());
        Assert.assertEquals(newEntity.getItinerarios(), resp.getItinerarios());
        Assert.assertEquals(newEntity.getTarjetas(), resp.getTarjetas());
        Assert.assertEquals(newEntity.getBlog(), resp.getBlog());
        Assert.assertTrue(newEntity.equals(resp));
        Assert.assertEquals(newEntity.hashCode(), resp.hashCode());
    }  
}