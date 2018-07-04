package co.com.ceiba.CeibaEstacionamiento.business.ImplTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import co.com.ceiba.CeibaEstacionamiento.business.impl.VehiculoBusinessImpl;
import co.com.ceiba.CeibaEstacionamiento.dao.IVehiculoDAO;
import co.com.ceiba.CeibaEstacionamiento.model.VehiculoModel;
import co.com.ceiba.CeibaEstacionamiento.modelTest.VehiculoBuilder;

public class VehiculoBusinessImplTest{
	
	private VehiculoBusinessImpl vehiculoBusinessImpl = Mockito.mock(VehiculoBusinessImpl.class);
	
	@Before
	public void before() {
		vehiculoBusinessImpl = Mockito.mock(VehiculoBusinessImpl.class);
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
		Mockito.when(vehiculoBusinessImpl.contarCarros()).thenReturn(1);
	}
	
	@Test
	public void contarCarrosMotos(){
		Mockito.when(vehiculoBusinessImpl.contarMotos()).thenReturn(1);
	}

}
