package co.com.ceiba.CeibaEstacionamiento.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.com.ceiba.CeibaEstacionamiento.business.IVehiculoBusiness;
import co.com.ceiba.CeibaEstacionamiento.dao.IVehiculoDAO;
import co.com.ceiba.CeibaEstacionamiento.model.VehiculoModel;

@Service
public class VehiculoBusinessImpl implements IVehiculoBusiness{
	
	@Autowired
	private IVehiculoDAO vehiculoDAO;
	 
	@Override
	public VehiculoModel getVehiculoById(String placa) {
		 return vehiculoDAO.getVehiculoById(placa);
	}

	@Override
	public List<VehiculoModel> listado() {
		 return vehiculoDAO.listado();
	}

	@Override
	public void crearVehiculo(VehiculoModel vehiculo) {
		vehiculoDAO.crearVehiculo(vehiculo);
	}

	@Override
	public void eliminarVehiculo(VehiculoModel vehiculo) {
		vehiculoDAO.eliminarVehiculo(vehiculo);
	}

	@Override
	public void actualizarVehiculo(VehiculoModel vehiculo) {
		vehiculoDAO.actualizarVehiculo(vehiculo);
	}

	@Override
	public Integer contarCarros(VehiculoModel vehiculo) {
		return vehiculoDAO.contarCarros(vehiculo);
	}

	@Override
	public Integer contarMotos(VehiculoModel vehiculo) {
		return vehiculoDAO.contarMotos(vehiculo);
	}

}
