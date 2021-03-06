/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.persistence;

import co.edu.uniandes.csw.viajes.entities.CompaniaEntity;
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

/**
 *
 * @author Juan
 */
@RunWith(Arquillian.class)
public class CompaniaPersistenceTest {    
    
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
    private EntityManager em;
    
    /**
     * Variable para martcar las transacciones del em anterior cuando se
     * crean/borran datos para las pruebas.
     */    
    @Inject
    UserTransaction utx;
    
    private List<CompaniaEntity> data = new ArrayList<CompaniaEntity>();
    
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
            CompaniaEntity entity = factory.manufacturePojo( CompaniaEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }
    
    /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Compania, el descriptor de la
     * base de datos y el archivo beans.xml para resolver la inyección de
     * dependencias.
     */
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(CompaniaEntity.class.getPackage())
                .addPackage(CompaniaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
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
        em.createQuery("delete from CompaniaEntity").executeUpdate();
    } 
    
    /**
     * Prueba para crear una Compania.
     *
     *
     */    
    @Test
    public void createCompaniaTest() {
        PodamFactory factory = new PodamFactoryImpl();
        CompaniaEntity newEntity = factory.manufacturePojo(CompaniaEntity.class);
        CompaniaEntity result = companiaPersistence.create(newEntity);

        Assert.assertNotNull(result);

        CompaniaEntity entity = em.find(CompaniaEntity.class, result.getId());

        Assert.assertEquals(newEntity.getNombre(), entity.getNombre());
        Assert.assertEquals(newEntity.getTelefono(), entity.getTelefono());
        Assert.assertEquals(newEntity.getEmail(), entity.getEmail());
        Assert.assertEquals(newEntity.getGuias().size(), entity.getGuias().size());
        Assert.assertEquals(newEntity.getOficinas().size(), entity.getOficinas().size());
        Assert.assertEquals(newEntity.getTransportes().size(), entity.getTransportes().size());
        Assert.assertEquals(newEntity.getHospedajes().size(), entity.getHospedajes().size());
        Assert.assertEquals(newEntity.getEntretenimientos().size(), entity.getEntretenimientos().size());
        
        entity.setGuias(newEntity.getGuias());
        Assert.assertEquals("Incoherencia de datos", entity.getGuias(), newEntity.getGuias());
        
        entity.setOficinas(newEntity.getOficinas());
        Assert.assertEquals("Incoherencia de datos", entity.getOficinas(), newEntity.getOficinas());
        
        entity.setTransportes(newEntity.getTransportes());
        Assert.assertEquals("Incoherencia de datos", entity.getTransportes(), newEntity.getTransportes());
        
        entity.setHospedajes(newEntity.getHospedajes());
        Assert.assertEquals("Incoherencia de datos", entity.getHospedajes(), newEntity.getHospedajes());
        
        entity.setEntretenimientos(newEntity.getEntretenimientos());
        Assert.assertEquals("Incoherencia de datos", entity.getEntretenimientos(), newEntity.getEntretenimientos());
        
        Assert.assertTrue(newEntity.equals(entity));
        Assert.assertEquals(newEntity.hashCode(), entity.hashCode());
    }

     /**
     * Prueba para consultar la lista de Companias.
     *
     *
     */
    @Test
    public void getCompaniasTest() {
        List<CompaniaEntity> list = companiaPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (CompaniaEntity ent : list) {
            boolean found = false;
            for (CompaniaEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
     /**
     * Prueba para consultar una Compania.
     *
     *
     */    
    @Test
    public void getCompaniaTest() {
        CompaniaEntity entity = data.get(0);
        CompaniaEntity newEntity = companiaPersistence.findById(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getNombre(), newEntity.getNombre());
        Assert.assertEquals(entity.getTelefono(), newEntity.getTelefono());
        Assert.assertEquals(entity.getEmail(), newEntity.getEmail());
        Assert.assertEquals(entity.getGuias().size(), newEntity.getGuias().size());
        Assert.assertEquals(entity.getOficinas().size(), newEntity.getOficinas().size());
        Assert.assertEquals(entity.getTransportes().size(), newEntity.getTransportes().size());
        Assert.assertEquals(entity.getHospedajes().size(), newEntity.getHospedajes().size());
        Assert.assertEquals(entity.getEntretenimientos().size(), newEntity.getEntretenimientos().size());
        Assert.assertTrue(newEntity.equals(entity));
        Assert.assertEquals(newEntity.hashCode(), entity.hashCode());       
    }
        
    /**
     * Prueba para eliminar una Compania.
     *
     *
     */
    @Test
    public void deleteCompaniaTest() {
        CompaniaEntity entity = data.get(0);
        companiaPersistence.delete(entity.getId());
        CompaniaEntity deleted = em.find(CompaniaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
     /**
     * Prueba para actualizar una Compania.
     *
     *
     */    
    @Test
    public void updateCompaniaTest() {
        CompaniaEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        CompaniaEntity newEntity = factory.manufacturePojo(CompaniaEntity.class);

        newEntity.setId(entity.getId());

        companiaPersistence.update(newEntity);
        
        CompaniaEntity resp = em.find(CompaniaEntity.class, entity.getId());
        Assert.assertEquals(newEntity.getNombre(), resp.getNombre());
        Assert.assertEquals(newEntity.getTelefono(), resp.getTelefono());
        Assert.assertEquals(newEntity.getGuias().size(), resp.getGuias().size());
        Assert.assertEquals(newEntity.getOficinas().size(), resp.getOficinas().size());
        Assert.assertEquals(newEntity.getTransportes().size(), resp.getTransportes().size());
        Assert.assertEquals(newEntity.getHospedajes().size(), resp.getHospedajes().size());
        Assert.assertEquals(newEntity.getEntretenimientos().size(), resp.getEntretenimientos().size());
        Assert.assertTrue(newEntity.equals(resp));
        Assert.assertEquals(newEntity.hashCode(), resp.hashCode());
    }    
}
