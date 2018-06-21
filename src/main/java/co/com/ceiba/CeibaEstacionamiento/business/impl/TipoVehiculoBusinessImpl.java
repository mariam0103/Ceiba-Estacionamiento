package co.com.ceiba.CeibaEstacionamiento.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.com.ceiba.CeibaEstacionamiento.business.ITipoVehiculoBusiness;
import co.com.ceiba.CeibaEstacionamiento.dao.ITipoVehiculoDAO;
import co.com.ceiba.CeibaEstacionamiento.model.TipoVehiculoModel;

@Service
public class TipoVehiculoBusinessImpl implements ITipoVehiculoBusiness{
	
	@Autowired
    private ITipoVehiculoDAO tipoVehiculoDAO;
	
	@Override
	public List<TipoVehiculoModel> listado() {
		 return tipoVehiculoDAO.listado();
	}

}
