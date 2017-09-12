
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
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/*0
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jc.sanchez12
 */
@RunWith(Arquillian.class)
public class CompaniaPersistenceTest 
{
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
    }
 }