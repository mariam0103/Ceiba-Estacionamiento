package co.com.ceiba.CeibaEstacionamiento.dao;

import java.util.List;

import co.com.ceiba.CeibaEstacionamiento.model.VehiculoModel;

public interface IVehiculoDAO {
		VehiculoModel getVehiculoById(String placa);
	    List<VehiculoModel> listado();
	    void crearVehiculo(VehiculoModel vehiculo);
	    void eliminarVehiculo(VehiculoModel vehiculo);
	    void actualizarVehiculo(VehiculoModel vehiculo);
}
