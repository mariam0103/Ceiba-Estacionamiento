package co.com.ceiba.CeibaEstacionamiento.modelTest;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import co.com.ceiba.CeibaEstacionamiento.model.VehiculoModel;

public class VehiculoModelTest {
	@Test
	public void VehiculoTestModel() {
		VehiculoModel vehiculo = new VehiculoBuilder().build();
		assertNotNull(vehiculo.getIdtipo());
    }
}
