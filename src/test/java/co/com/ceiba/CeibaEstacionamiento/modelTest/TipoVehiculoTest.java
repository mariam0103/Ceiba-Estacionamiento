package co.com.ceiba.CeibaEstacionamiento.modelTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import co.com.ceiba.CeibaEstacionamiento.model.TipoVehiculoModel;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TipoVehiculoTest {
	
	@Test
	public void TipoVehiculoModel() {
		TipoVehiculoModel tipoVehiculo = TipoVehiculoBuilder.anTipoVehiculo().withTipo("CARRO").withIdtipo(1).build();
		assertEquals("CARRO", tipoVehiculo.getTipo());
		assertEquals("1", tipoVehiculo.getIdtipo().toString());
    }
		
}
