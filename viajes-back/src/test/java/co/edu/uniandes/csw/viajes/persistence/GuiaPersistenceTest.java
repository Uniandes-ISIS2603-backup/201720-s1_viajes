package co.edu.uniandes.csw.viajes.persistence;


import co.edu.uniandes.csw.viajes.entities.GuiaEntity;
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
 * @author jc.sanchez12
 */
@RunWith(Arquillian.class)
public class GuiaPersistenceTest
{
    /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Guia, el descriptor de la
     * base de datos y el archivo beans.xml para resolver la inyección de
     * dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(GuiaEntity.class.getPackage())
                .addPackage(GuiaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
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
        em.createQuery("delete from GuiaEntity").executeUpdate();
    }
    
    private List<GuiaEntity> data = new ArrayList<GuiaEntity>();
    
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
            GuiaEntity entity = factory.manufacturePojo( GuiaEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }
    
    /**
     * Prueba para crear una Compania.
     *
     *
     */
    @Test
    public void createGuiaTest() {
        PodamFactory factory = new PodamFactoryImpl();
        GuiaEntity newEntity = factory.manufacturePojo(GuiaEntity.class);
        GuiaEntity result = guiaPersistence.create(newEntity);

        Assert.assertNotNull(result);

        GuiaEntity entity = em.find(GuiaEntity.class, result.getId());

        Assert.assertEquals(newEntity.getNombre(), entity.getNombre());
        Assert.assertEquals(newEntity.getValor(), entity.getValor());
    }
    
    /**
     * Prueba para consultar la lista de Guias.
     *
     *
     */
    @Test
    public void getGuiasTest() {
        List<GuiaEntity> list = guiaPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (GuiaEntity ent : list) {
            boolean found = false;
            for (GuiaEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
     /**
     * Prueba para consultar un Guia.
     *
     *
     */
    @Test
    public void getGuiaTest() {
        GuiaEntity entity = data.get(0);
        GuiaEntity newEntity = guiaPersistence.findById(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getNombre(), newEntity.getNombre());
        Assert.assertEquals(entity.getValor(), newEntity.getValor());
    }
 
     /**
     * Prueba para eliminar un Guia.
     *
     *
     */
    @Test
    public void deleteGuiaTest() {
        GuiaEntity entity = data.get(0);
        guiaPersistence.delete(entity.getId());
        GuiaEntity deleted = em.find(GuiaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
 /**
     * Prueba para actualizar un Guia.
     *
     *
     */
    @Test
    public void updateGuiaTest() {
        GuiaEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        GuiaEntity newEntity = factory.manufacturePojo(GuiaEntity.class);

        newEntity.setId(entity.getId());

        guiaPersistence.update(newEntity);

        GuiaEntity resp = em.find(GuiaEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getNombre(), resp.getNombre());
        Assert.assertEquals(newEntity.getValor(), resp.getValor());
    }  
}