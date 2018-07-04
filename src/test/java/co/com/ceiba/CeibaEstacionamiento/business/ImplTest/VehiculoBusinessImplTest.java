package co.com.ceiba.CeibaEstacionamiento.business.ImplTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import co.com.ceiba.CeibaEstacionamiento.dao.impl.VehiculoDAOImpl;
import co.com.ceiba.CeibaEstacionamiento.model.VehiculoModel;
import co.com.ceiba.CeibaEstacionamiento.modelTest.VehiculoBuilder;

public class VehiculoBusinessImplTest{
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
	 
	 @AfterClass
	 public static void afterClass() {
		  entityManager.close();
		  entityManagerFactory.close();
	 }
	 
	 @Test
	 public void before(){
		 try {
			 VehiculoDAOImpl =  new VehiculoDAOImpl();
			  VehiculoDAOImpl.entityManager = entityManager;
			  entityManager.getTransaction().begin();
			  VehiculoModel vehiculo = new VehiculoBuilder().build();
			  VehiculoDAOImpl.crearVehiculo(vehiculo);
			  entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }

}
