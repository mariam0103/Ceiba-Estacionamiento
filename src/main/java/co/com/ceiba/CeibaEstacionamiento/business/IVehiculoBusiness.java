package co.com.ceiba.CeibaEstacionamiento.business;

import java.util.List;
import co.com.ceiba.CeibaEstacionamiento.model.VehiculoModel;

public interface IVehiculoBusiness {
	VehiculoModel getVehiculoById(String placa);
    List<VehiculoModel> listado();
    void crearVehiculo(VehiculoModel vehiculo);
    void eliminarVehiculo(VehiculoModel vehiculo);
    void actualizarVehiculo(VehiculoModel vehiculo);
    Integer contarCarros();
    Integer contarMotos();
}
