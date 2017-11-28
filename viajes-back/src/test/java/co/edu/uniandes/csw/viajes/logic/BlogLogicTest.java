/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.logic;

import co.edu.uniandes.csw.viajes.ejb.BlogLogic;
import co.edu.uniandes.csw.viajes.entities.BlogEntity;
import co.edu.uniandes.csw.viajes.persistence.BlogPersistence;
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
public class BlogLogicTest {
    
    /**
     * Inyección de la dependencia a la clase BlogLogic cuyos métodos
     * se van a probar.
     */
    @Inject
    private BlogLogic blogLogic;
    
    /**
     * Inyección de la dependencia a la clase BlogPersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private BlogPersistence blogPersistence;
    
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
    private List<BlogEntity> dataLogic = new ArrayList<BlogEntity>();

    /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Blog, el descriptor de la
     * base de datos y el archivo beans.xml para resolver la inyección de
     * dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(BlogLogic.class.getPackage())
                .addPackage(BlogEntity.class.getPackage())
                .addPackage(BlogPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    /**
     * Constructor por defecto
     */
    public BlogLogicTest() {
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
        entityM.createQuery("delete from BlogEntity").executeUpdate();
    }
    
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            BlogEntity entity = factory.manufacturePojo(BlogEntity.class);

            entityM.persist(entity);
            dataLogic.add(entity);
        }
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Test de createBlog, of class BlogLogic.
     */
    @Test
    public void createBlogEntityTest() {
        BlogEntity blog = new BlogEntity();
        blogLogic.createBlog(blog);
        BlogEntity blogAux = blogLogic.getBlog(blog.getId());
                
        Assert.assertEquals(blogAux, blog);
    }    
    
    /**
     * Test de getBlogs, of class BlogLogic.
     */
    @Test
    public void getBlogsListTest() {
        List<BlogEntity> blogs = blogPersistence.findAll();
        List<BlogEntity> blogsList = blogLogic.getBlogs();
        
        Assert.assertEquals(blogsList, blogs);
    }    
}
