package co.com.ceiba.CeibaEstacionamiento.business.ImplTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import co.com.ceiba.CeibaEstacionamiento.business.IVehiculoBusiness;
import co.com.ceiba.CeibaEstacionamiento.business.impl.VehiculoBusinessImpl;
import co.com.ceiba.CeibaEstacionamiento.dao.IVehiculoDAO;
import co.com.ceiba.CeibaEstacionamiento.exception.CeibaException;
import co.com.ceiba.CeibaEstacionamiento.model.VehiculoModel;
import co.com.ceiba.CeibaEstacionamiento.modelTest.VehiculoBuilder;

public class VehiculoBusinessImplTest{
	
	@Mock
	IVehiculoDAO IvehiculoDao;
	
	@InjectMocks
	private IVehiculoBusiness vehiculoBusiness;
	
	@Before
	public void before() {
		 vehiculoBusiness = Mockito.mock(IVehiculoBusiness.class);
		 IvehiculoDao = Mockito.mock(IVehiculoDAO.class);
	}
	
	@Test
	public void permitirIngresoVehiculosConPlacaA(){
		VehiculoBusinessImpl Impl = new VehiculoBusinessImpl();
		VehiculoModel vehiculo = new VehiculoBuilder().build();
		Boolean empezizaConA = Impl.empiezaConA(vehiculo.getIdplaca());
		assertEquals(true, empezizaConA); 
	}
	
	
	@Test
	public void contarCarrosTest(){
		Mockito.when(IvehiculoDao.contarCarros()).thenReturn(0);
		Integer contarCarros = vehiculoBusiness.contarCarros();
		assertEquals("0", contarCarros.toString()); 
	}
	
	@Test
	public void contarCarrosMotos(){
		Mockito.when(IvehiculoDao.contarMotos()).thenReturn(0);
		Integer contarMotos = vehiculoBusiness.contarMotos();
		assertEquals("0", contarMotos.toString()); 
	}
	
	@Test
	public void crearVehiculo() {
		Mockito.when(vehiculoBusiness.contarMotos()).thenReturn(13);
		Mockito.when(vehiculoBusiness.contarCarros()).thenReturn(13);
		String exception = vehiculoBusiness.validacionEspacioEstacionamiento(1);
		assertEquals("El estacionamiento se encuentra completamente ocupado",exception); 
	}
}
