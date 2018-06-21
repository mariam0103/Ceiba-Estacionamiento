package co.com.ceiba.CeibaEstacionamiento.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.CeibaEstacionamiento.business.IVehiculoEstacionadoBusiness;
import co.com.ceiba.CeibaEstacionamiento.dao.IVehiculosEstacionadosDAO;
import co.com.ceiba.CeibaEstacionamiento.model.VehiculosEstacionadosModel;

@Service
public class VehiculoEstacionadoBusinessImpl implements IVehiculoEstacionadoBusiness{
	
	@Autowired
	private IVehiculosEstacionadosDAO vehiculosEstacionadosDAO;
	
	@Override
	public void crearvehiculoEstacionado(VehiculosEstacionadosModel vehiculoEstacionado) {
		vehiculosEstacionadosDAO.crearvehiculoEstacionado(vehiculoEstacionado);
	}

}
