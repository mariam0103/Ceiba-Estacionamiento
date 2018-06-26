package co.com.ceiba.CeibaEstacionamiento.business;

import java.util.List;
import co.com.ceiba.CeibaEstacionamiento.model.VehiculoModel;

public interface IVehiculoBusiness {
	VehiculoModel getVehiculoById(String placa);
    List<VehiculoModel> listado();
    String crearVehiculo(VehiculoModel vehiculo);
    String eliminarVehiculo(VehiculoModel vehiculo);
    String actualizarVehiculo(VehiculoModel vehiculo);
    Integer contarCarros();
    Integer contarMotos();
}
