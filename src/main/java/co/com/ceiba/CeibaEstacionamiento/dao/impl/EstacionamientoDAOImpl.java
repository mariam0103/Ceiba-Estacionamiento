package co.com.ceiba.CeibaEstacionamiento.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import co.com.ceiba.CeibaEstacionamiento.dao.IEstacionamientoDAO;
import co.com.ceiba.CeibaEstacionamiento.model.EstacionamientoModel;
import co.com.ceiba.CeibaEstacionamiento.model.VehiculoModel;

@Repository
@Transactional
public class EstacionamientoDAOImpl implements IEstacionamientoDAO{
	
	@PersistenceContext	
    private EntityManager entityManager;
	
	@Override
	public EstacionamientoModel getEstacionamientoById(int id) {
		return entityManager.find(EstacionamientoModel.class, id);
	}

	@Override
	public void crearEstacionamiento(EstacionamientoModel estacionamiento) {
		entityManager.persist(estacionamiento);
		entityManager.flush();
	}

	@Override
	public void actualizarEstacionamiento(EstacionamientoModel estacionamientoParam) {
		EstacionamientoModel estacionamiento = getEstacionamientoById(estacionamientoParam.getIdestacionamiento());
		estacionamiento.setIdestacionamiento(estacionamientoParam.getIdestacionamiento());
		estacionamiento.setFechaingreso(estacionamientoParam.getFechaingreso());
		estacionamiento.setFechasalida(estacionamientoParam.getFechasalida());
		estacionamiento.setPrecio(estacionamientoParam.getPrecio());
        entityManager.flush();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EstacionamientoModel> vehiculoEstacionado(VehiculoModel vehiculo) {
		List<EstacionamientoModel> result;
		try {
			Query query =  entityManager.createQuery("SELECT e FROM EstacionamientoModel e \r\n" + 
					"INNER JOIN VehiculosEstacionadosModel ve ON ve.vehiculosEstacionadosPK.idestacionamiento = e.idestacionamiento \r\n" + 
					"INNER JOIN VehiculoModel v ON v.idplaca = ve.vehiculosEstacionadosPK.idplaca \r\n "+
					"WHERE e.fechasalida IS NULL AND e.precio IS NULL AND ve.vehiculosEstacionadosPK.idplaca='"+vehiculo.getIdplaca()+"'");
			result = query.getResultList();
		} catch (Exception e) {
			throw new PersistenceException("Ha ocurrido un error en la consulta vehiculoEstacionado");
		}
		return result;
	}
	

}
