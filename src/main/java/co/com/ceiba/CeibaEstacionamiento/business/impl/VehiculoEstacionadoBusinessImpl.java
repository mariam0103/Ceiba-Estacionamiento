package co.com.ceiba.CeibaEstacionamiento.business.impl;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.CeibaEstacionamiento.business.IVehiculoEstacionadoBusiness;
import co.com.ceiba.CeibaEstacionamiento.dao.IVehiculosEstacionadosDAO;
import co.com.ceiba.CeibaEstacionamiento.exception.CeibaException;
import co.com.ceiba.CeibaEstacionamiento.model.EstacionamientoModel;
import co.com.ceiba.CeibaEstacionamiento.model.VehiculoModel;
import co.com.ceiba.CeibaEstacionamiento.model.VehiculosEstacionadosModel;
import co.com.ceiba.CeibaEstacionamiento.model.VehiculosEstacionadosPK;

@Service
public class VehiculoEstacionadoBusinessImpl implements IVehiculoEstacionadoBusiness{
	
	@Autowired
	private IVehiculosEstacionadosDAO vehiculosEstacionadosDAO;
	
	@Override
	public void crearvehiculoEstacionado(EstacionamientoModel estacionamiento,VehiculoModel vehiculo) {
		try {
			VehiculosEstacionadosModel vehiculoEstacionado = new VehiculosEstacionadosModel();
			VehiculosEstacionadosPK pk = new VehiculosEstacionadosPK(estacionamiento.getIdestacionamiento(),vehiculo.getIdplaca());
			vehiculoEstacionado.setId(pk);
			vehiculosEstacionadosDAO.crearvehiculoEstacionado(vehiculoEstacionado);
		} catch (Exception e) {
			throw new CeibaException("Ocurrio un error inesperado registrando el vehiculo en el estacionamiento");
		}
	}

	@Override
	public JSONArray listaCarrosEstacionados() {
		return vehiculosEstacionadosDAO.listaCarrosEstacionados();
	}

	@Override
	public JSONArray listaMotosEstacionadas() {
		return vehiculosEstacionadosDAO.listaMotosEstacionadas();
	}

	@Override
	public void estaElVehiculoEstacionado(VehiculoModel vehiculo) {
		if(vehiculosEstacionadosDAO.estaElVehiculoEstacionado(vehiculo)){
			throw new CeibaException("El vehiculo ya se encuentra registrado en el parqueadero");
		}
	}

}
