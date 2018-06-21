package co.com.ceiba.CeibaEstacionamiento.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import co.com.ceiba.CeibaEstacionamiento.dao.IEstacionamientoDAO;
import co.com.ceiba.CeibaEstacionamiento.model.EstacionamientoModel;

@Repository
@Transactional
public class EstacionamientoDAOImpl implements IEstacionamientoDAO{
	
	@PersistenceContext	
    private EntityManager entityManager;
	
	@Override
	public EstacionamientoModel getEstacionamientoById(int id) {
		return entityManager.find(EstacionamientoModel.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EstacionamientoModel> listado() {
		Query query =  entityManager.createQuery("SELECT e FROM EstacionamientoModel e");
		List<EstacionamientoModel> resultList = query.getResultList();
		return resultList;
	}

	@Override
	public void crearEstacionamiento(EstacionamientoModel estacionamiento) {
		entityManager.persist(estacionamiento);
	}

	@Override
	public void eliminarEstacionamiento(EstacionamientoModel estacionamiento) {
		entityManager.remove(getEstacionamientoById(estacionamiento.getIdestacionamiento()));
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
	

}
