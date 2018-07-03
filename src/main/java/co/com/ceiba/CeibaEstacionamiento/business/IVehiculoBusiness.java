package co.com.ceiba.CeibaEstacionamiento.business;

import co.com.ceiba.CeibaEstacionamiento.model.VehiculoModel;

public interface IVehiculoBusiness {
	VehiculoModel getVehiculoById(String placa);
    VehiculoModel crearVehiculo(VehiculoModel vehiculo);
    VehiculoModel actualizarVehiculo(VehiculoModel vehiculo);
    Integer contarCarros();
    Integer contarMotos();
}
