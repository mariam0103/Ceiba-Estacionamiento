package co.com.ceiba.CeibaEstacionamiento.dao.ImplTest;

import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import co.com.ceiba.CeibaEstacionamiento.dao.impl.VehiculoDAOImpl;
import co.com.ceiba.CeibaEstacionamiento.model.VehiculoModel;
import co.com.ceiba.CeibaEstacionamiento.modelTest.VehiculoBuilder;

public class VehiculoDAOImplTest {
	 private static EntityManagerFactory entityManagerFactory;
	 private static EntityManager entityManager;
	 
	 @Autowired
	 private VehiculoDAOImpl VehiculoDAOImpl;
	 @BeforeClass
	 public static void beforeClass() {
		 try {
			 entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			 entityManager = entityManagerFactory.createEntityManager();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	 }
	 @Test
	 public void before(){
		 try {
			 VehiculoDAOImpl =  new VehiculoDAOImpl();
			  VehiculoDAOImpl.entityManager = entityManager;
			  entityManager.getTransaction().begin();
			  VehiculoModel vehiculo = new VehiculoBuilder().build();
			  VehiculoDAOImpl.actualizarVehiculo(vehiculo);
			  entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }
}
