package co.com.ceiba.CeibaEstacionamiento.business.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.com.ceiba.CeibaEstacionamiento.business.IEstacionamientoBusiness;
import co.com.ceiba.CeibaEstacionamiento.dao.IEstacionamientoDAO;
import co.com.ceiba.CeibaEstacionamiento.model.EstacionamientoModel;

@Service
public class EstacionamientoBusinessImpl implements IEstacionamientoBusiness{
	
	@Autowired
	private IEstacionamientoDAO estacionamientoDAO;
	
	@Override
	public EstacionamientoModel getEstacionamientoById(int id) {
		return estacionamientoDAO.getEstacionamientoById(id);
	}

	@Override
	public List<EstacionamientoModel> listado() {
		return estacionamientoDAO.listado();
	}

	@Override
	public void crearEstacionamiento(EstacionamientoModel estacionamiento) {
		estacionamientoDAO.crearEstacionamiento(estacionamiento);
	}

	@Override
	public void eliminarEstacionamiento(EstacionamientoModel estacionamiento) {
		estacionamientoDAO.eliminarEstacionamiento(estacionamiento);
	}

	@Override
	public void actualizarEstacionamiento(EstacionamientoModel estacionamiento) {
		estacionamientoDAO.actualizarEstacionamiento(estacionamiento);
	}

}