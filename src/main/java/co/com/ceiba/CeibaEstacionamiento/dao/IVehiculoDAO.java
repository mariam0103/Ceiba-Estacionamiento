package co.com.ceiba.CeibaEstacionamiento.dao;

import co.com.ceiba.CeibaEstacionamiento.model.VehiculoModel;

public interface IVehiculoDAO {
		VehiculoModel getVehiculoById(String placa);
	    void crearVehiculo(VehiculoModel vehiculo);
	    void actualizarVehiculo(VehiculoModel vehiculo);
	    Integer contarCarros();
	    Integer contarMotos();
}
