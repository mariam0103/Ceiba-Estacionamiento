package co.com.ceiba.CeibaEstacionamiento.business;

import co.com.ceiba.CeibaEstacionamiento.model.VehiculoModel;

public interface IVehiculoBusiness {
	VehiculoModel getVehiculoById(String placa);
    VehiculoModel crearVehiculo(VehiculoModel vehiculo);
    VehiculoModel actualizarVehiculo(VehiculoModel vehiculo);
    Integer contarCarros();
    Integer contarMotos();
    void validacionesVehiculoModel(VehiculoModel vehiculo);
    void validacionEspacioEstacionamiento(Integer idtipo);
    Boolean empiezaConA(String placa);
    void permitirIngresoVehiculosConPlacaA(String placa);
    void guardarVehiculo(VehiculoModel vehiculo);
}
