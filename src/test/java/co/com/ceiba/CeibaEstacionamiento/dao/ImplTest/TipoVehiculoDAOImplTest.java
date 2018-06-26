package co.com.ceiba.CeibaEstacionamiento.dao.ImplTest;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.ceiba.CeibaEstacionamiento.dao.ITipoVehiculoDAO;

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
