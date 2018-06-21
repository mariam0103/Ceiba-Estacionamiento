package co.com.ceiba.CeibaEstacionamiento.modelTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import co.com.ceiba.CeibaEstacionamiento.model.TipoVehiculoModel;

public class TipoVehiculoTest {
	
	@Test
	public void TipoVehiculoModel() {
		TipoVehiculoModel tipoVehiculo = TipoVehiculoBuilder.anTipoVehiculo().withTipo("CARRO").withIdtipo(1).build();
		
		assertEquals("CARRO", tipoVehiculo.getTipo());
		assertEquals("1", tipoVehiculo.getIdtipo().toString());
    }
	
}
