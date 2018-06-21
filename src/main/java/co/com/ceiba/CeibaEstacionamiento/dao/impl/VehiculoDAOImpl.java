package co.com.ceiba.CeibaEstacionamiento.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import co.com.ceiba.CeibaEstacionamiento.dao.IVehiculoDAO;
import co.com.ceiba.CeibaEstacionamiento.model.VehiculoModel;

@Repository
@Transactional
public class VehiculoDAOImpl implements IVehiculoDAO{
	
	@PersistenceContext	
    private EntityManager entityManager;
	
	@Override
	public VehiculoModel getVehiculoById(String placa) {
		return entityManager.find(VehiculoModel.class, placa);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<VehiculoModel> listado() {
		Query query =  entityManager.createQuery("SELECT v FROM VehiculoModel v");
		List<VehiculoModel> resultList = query.getResultList();
		return resultList;
	}

	@Override
	public void crearVehiculo(VehiculoModel vehiculo) {
		entityManager.persist(vehiculo);
	}

	@Override
	public void eliminarVehiculo(VehiculoModel vehiculo) {
		entityManager.remove(getVehiculoById(vehiculo.getIdplaca()));
		
	}

	@Override
	public void actualizarVehiculo(VehiculoModel vehiculoParam) {
		VehiculoModel vehiculo = getVehiculoById(vehiculoParam.getIdplaca());
		vehiculo.setIdplaca(vehiculoParam.getIdplaca());
		vehiculo.setCilindraje(vehiculoParam.getCilindraje());
		vehiculo.setIdtipo(vehiculoParam.getIdtipo());
        entityManager.flush();
	}

}
