
import co.edu.uniandes.csw.viajes.entities.TransporteEntity;
import co.edu.uniandes.csw.viajes.persistence.TransportePersistence;
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
 * @author sa.silva1
 */
@RunWith(Arquillian.class)
public class TransportePersistenceTest {
    
     @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(TransporteEntity.class.getPackage())
                .addPackage(TransportePersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * Inyección de la dependencia a la clase EmployeePersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private TransportePersistence transportePersistence;

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
    private void clearData() {
        em.createQuery("delete from TransporteEntity").executeUpdate();
    }

    /**
     *
     */
    private List<TransporteEntity> data = new ArrayList<TransporteEntity>();

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            TransporteEntity entity = factory.manufacturePojo(TransporteEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Prueba para crear un Employee.
     *
     *
     */
    @Test
    public void createTransporteTest() {
        PodamFactory factory = new PodamFactoryImpl();
        TransporteEntity newEntity = factory.manufacturePojo(TransporteEntity.class);
        TransporteEntity result = transportePersistence.create(newEntity);

        Assert.assertNotNull(result);

        TransporteEntity entity = em.find(TransporteEntity.class, result.getId());

        Assert.assertEquals(newEntity.getValor(), entity.getValor());
        Assert.assertEquals(newEntity.getTipo(), entity.getTipo());
        Assert.assertEquals(newEntity.getFechaInicio(), entity.getFechaInicio());
        Assert.assertEquals(newEntity.getFechaFinal(), entity.getFechaFinal());
        Assert.assertEquals(newEntity.getNombre(), entity.getNombre());
        Assert.assertEquals(newEntity.getCalificacion(), entity.getCalificacion());
        Assert.assertEquals(newEntity.getComentarios(), entity.getComentarios());
    }

    /**
     * Prueba para consultar la lista de Employees.
     *
     *
     */
    @Test
    public void getTransportesTest() {
        List<TransporteEntity> list = transportePersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (TransporteEntity ent : list) {
            boolean found = false;
            for (TransporteEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar un Employee.
     *
     *
     */
    @Test
    public void getTransporteTest() {
        TransporteEntity entity = data.get(0);
        TransporteEntity newEntity = transportePersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getValor(), newEntity.getValor());
        Assert.assertEquals(entity.getTipo(), newEntity.getTipo());
        Assert.assertEquals(entity.getFechaInicio(), newEntity.getFechaInicio());
        Assert.assertEquals(entity.getFechaFinal(), newEntity.getFechaFinal());
        Assert.assertEquals(entity.getNombre(), newEntity.getNombre());
        Assert.assertEquals(entity.getCalificacion(), newEntity.getCalificacion());
        Assert.assertEquals(entity.getComentarios(), newEntity.getComentarios());
    }

    /**
     * Prueba para eliminar un Employee.
     *
     *
     */
    @Test
    public void deleteTransporteTest() {
        TransporteEntity entity = data.get(0);
        transportePersistence.delete(entity.getId());
        TransporteEntity deleted = em.find(TransporteEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar un Employee.
     *
     *
     */
    @Test
    public void updateTransporteTest() {
        TransporteEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        TransporteEntity newEntity = factory.manufacturePojo(TransporteEntity.class);

        newEntity.setId(entity.getId());

        transportePersistence.update(newEntity);

        TransporteEntity resp = em.find(TransporteEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getValor(), resp.getValor());
        Assert.assertEquals(newEntity.getTipo(), resp.getTipo());
        Assert.assertEquals(newEntity.getFechaInicio(), resp.getFechaInicio());
        Assert.assertEquals(newEntity.getFechaFinal(), resp.getFechaFinal());
        Assert.assertEquals(newEntity.getNombre(), resp.getNombre());
        Assert.assertEquals(newEntity.getCalificacion(), resp.getCalificacion());
        Assert.assertEquals(newEntity.getComentarios(), resp.getComentarios());
        
        
    }
}
