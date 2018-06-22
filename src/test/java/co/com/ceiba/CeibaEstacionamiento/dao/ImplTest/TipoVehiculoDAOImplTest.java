package co.com.ceiba.CeibaEstacionamiento.dao.ImplTest;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Repository;

import co.com.ceiba.CeibaEstacionamiento.dao.ITipoVehiculoDAO;
import co.com.ceiba.CeibaEstacionamiento.dao.impl.TipoVehiculoDAOImpl;
import co.com.ceiba.CeibaEstacionamiento.model.TipoVehiculoModel;

@Repository
@Transactional
public class TipoVehiculoDAOImplTest{
	
	@Autowired
	private ITipoVehiculoDAO dao;
	 
//	@BeforeClass
//	 public static void beforeClass() {	
//		  
//	 }
//	
//	@Test
//	public void list() {
//		dao = new TipoVehiculoDAOImpl();
//		List<TipoVehiculoModel> listado = dao.listado();
//		assertNotNull(listado);
//		assertNotEquals(0, listado.size());
//	}
	
	
}
