package co.edu.uniandes.csw.viajes.persistence;


import co.edu.uniandes.csw.viajes.entities.TarjetaCreditoEntity;
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
public class TarjetaCreditoPersistenceTest
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
                .addPackage(TarjetaCreditoEntity.class.getPackage())
                .addPackage(TarjetaCreditoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
     /**
     * Inyección de la dependencia a la clase TarjetaCreditoPersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private TarjetaCreditoPersistence tarjetaCreditoPersistence;
    
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
        em.createQuery("delete from TarjetaCreditoEntity").executeUpdate();
    }
    
    private List<TarjetaCreditoEntity> data = new ArrayList<TarjetaCreditoEntity>();
    
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
            TarjetaCreditoEntity entity = factory.manufacturePojo( TarjetaCreditoEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }
    
    /**
     * Prueba para crear una TarjetaCredito.
     *
     *
     */
    @Test
    public void createTarjetaCreditoTest() {
        PodamFactory factory = new PodamFactoryImpl();
        TarjetaCreditoEntity newEntity = factory.manufacturePojo(TarjetaCreditoEntity.class);
        TarjetaCreditoEntity result = tarjetaCreditoPersistence.create(newEntity);

        Assert.assertNotNull(result);

        TarjetaCreditoEntity entity = em.find(TarjetaCreditoEntity.class, result.getId());

        Assert.assertEquals(newEntity.getNumero(), entity.getNumero());
        Assert.assertEquals(newEntity.getFondos(), entity.getFondos());
        Assert.assertEquals(newEntity.getPagos(), entity.getPagos());
        Assert.assertEquals(newEntity.getUsuario(), entity.getUsuario());
        
        entity.setPagos(newEntity.getPagos());
        Assert.assertEquals("Incoherencia de datos", entity.getPagos(), newEntity.getPagos());
        
        entity.setUsuario(newEntity.getUsuario());
        Assert.assertEquals("Incoherencia de datos", entity.getUsuario(), newEntity.getUsuario());
        
        Assert.assertTrue(newEntity.equals(entity));
        Assert.assertEquals(newEntity.hashCode(), entity.hashCode());
    }
    
    /**
     * Prueba para consultar la lista de TarjetasCredito.
     *
     *
     */
    @Test
    public void getTarjetasCreditoTest() {
        List<TarjetaCreditoEntity> list = tarjetaCreditoPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (TarjetaCreditoEntity ent : list) {
            boolean found = false;
            for (TarjetaCreditoEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
     /**
     * Prueba para consultar una TarjetaCredito.
     *
     *
     */
    @Test
    public void getTarjetaCreditoTest() {
        TarjetaCreditoEntity entity = data.get(0);
        TarjetaCreditoEntity newEntity = tarjetaCreditoPersistence.findById(entity.getId());
        Assert.assertNotNull(newEntity);
        
        Assert.assertEquals(entity.getNumero(), newEntity.getNumero());
        Assert.assertEquals(entity.getFondos(), newEntity.getFondos());
        Assert.assertEquals(entity.getPagos(), newEntity.getPagos());
        Assert.assertEquals(entity.getUsuario(), newEntity.getUsuario());
        Assert.assertTrue(newEntity.equals(entity));
        Assert.assertEquals(newEntity.hashCode(), entity.hashCode());
    }

    /**
     * Prueba para consultar una TarjetaCredito.
     * 
     * 
     */
    @Test
    public void getTarjetaCreditoNumberTest()
    { 
        TarjetaCreditoEntity entity = data.get(0);

        TarjetaCreditoEntity newEntity = tarjetaCreditoPersistence.findByNumber(entity.getNumero());
        Assert.assertNotNull(newEntity);

        Assert.assertEquals(entity.getNumero(), newEntity.getNumero());
        Assert.assertEquals(entity.getFondos(), newEntity.getFondos());
        Assert.assertEquals(entity.getPagos(), newEntity.getPagos());
        Assert.assertEquals(entity.getUsuario(), newEntity.getUsuario()); 
        Assert.assertTrue(newEntity.equals(entity));
        Assert.assertEquals(newEntity.hashCode(), entity.hashCode());
    }
    
     /**
     * Prueba para eliminar una TarjetaCredito.
     *
     *
     */
    @Test
    public void deleteTarjetaCreditoTest() {
        TarjetaCreditoEntity entity = data.get(0);
        tarjetaCreditoPersistence.delete(entity.getId());
        TarjetaCreditoEntity deleted = em.find(TarjetaCreditoEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
 /**
     * Prueba para actualizar una TarjetaCredito.
     *
     *
     */
    @Test
    public void updateTarjetaCreditoTest() {
        TarjetaCreditoEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        TarjetaCreditoEntity newEntity = factory.manufacturePojo(TarjetaCreditoEntity.class);

        newEntity.setId(entity.getId());

        tarjetaCreditoPersistence.update(newEntity);

        TarjetaCreditoEntity resp = em.find(TarjetaCreditoEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getNumero(), resp.getNumero());
        Assert.assertEquals(newEntity.getFondos(), resp.getFondos());
        Assert.assertEquals(newEntity.getPagos(), resp.getPagos());
        Assert.assertEquals(newEntity.getUsuario(), resp.getUsuario());  
        Assert.assertTrue(newEntity.equals(entity));
        Assert.assertEquals(newEntity.hashCode(), entity.hashCode());
    }     
}