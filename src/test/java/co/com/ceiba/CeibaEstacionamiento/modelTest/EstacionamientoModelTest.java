package co.com.ceiba.CeibaEstacionamiento.modelTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import co.com.ceiba.CeibaEstacionamiento.model.EstacionamientoModel;

public class EstacionamientoModelTest {
	@Test
	public void VehiculoTestModel() {
		EstacionamientoModel estacionamiento = new EstacionamientoBuilder().build();
		assertEquals("1",estacionamiento.getIdestacionamiento().toString());
    }
}
