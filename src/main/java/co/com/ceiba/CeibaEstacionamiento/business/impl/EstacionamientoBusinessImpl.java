package co.com.ceiba.CeibaEstacionamiento.business.impl;

import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.com.ceiba.CeibaEstacionamiento.business.IEstacionamientoBusiness;
import co.com.ceiba.CeibaEstacionamiento.dao.IEstacionamientoDAO;
import co.com.ceiba.CeibaEstacionamiento.exception.CeibaException;
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
	public void eliminarEstacionamiento(EstacionamientoModel estacionamiento) {
		estacionamientoDAO.eliminarEstacionamiento(estacionamiento);
	}

	@Override
	public void actualizarEstacionamiento(EstacionamientoModel estacionamiento) {
		estacionamientoDAO.actualizarEstacionamiento(estacionamiento);
	}

	@Override
	public EstacionamientoModel crearEstacionamiento() {
		EstacionamientoModel estacionamiento = new EstacionamientoModel();
		try {
			Calendar nowDate = Calendar.getInstance();
			estacionamiento.setFechaingreso(nowDate.getTime());
			estacionamientoDAO.crearEstacionamiento(estacionamiento);
		} catch (Exception e) {
			throw new CeibaException("Ocurrio un error registrando el vehiculo en el estacionamiento");
		}
		return estacionamiento;
	}

}
