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

	@Override
	public Integer contarCarros(VehiculoModel vehiculo) {
		Integer result = 20;
		if(vehiculo.getIdtipo()!=null) {
			Query query =  entityManager.createQuery("SELECT \r\n" + 
					"			COUNT(DISTINCT ve.ID_PLACA)\r\n" + 
					"			FROM EstacionamientoModel e\r\n" + 
					"			INNER JOIN VehiculosEstacionadosModel ve ON ve.ID_ESTACIONAMIENTO = e.ID_ESTACIONAMIENTO\r\n" + 
					"			INNER JOIN VehiculoModel v ON v.ID_PLACA = ve.ID_PLACA\r\n" + 
					"			WHERE v.ID_TIPO = 1 AND e.FECHA_SALIDA IS NULL AND e.PRECIO IS NULL");
			result = query.getFirstResult();
		}
		return result;
	}

	@Override
	public Integer contarMotos(VehiculoModel vehiculo) {
		Integer result = 10;
		if(vehiculo.getIdtipo()!=null) {
			Query query =  entityManager.createQuery("SELECT \r\n" + 
					"			COUNT(DISTINCT ve.ID_PLACA)\r\n" + 
					"			FROM EstacionamientoModel e\r\n" + 
					"			INNER JOIN VehiculosEstacionadosModel ve ON ve.ID_ESTACIONAMIENTO = e.ID_ESTACIONAMIENTO\r\n" + 
					"			INNER JOIN VehiculoModel v ON v.ID_PLACA = ve.ID_PLACA\r\n" + 
					"			WHERE v.ID_TIPO = 2 AND e.FECHA_SALIDA IS NULL AND e.PRECIO IS NULL");
			result = query.getFirstResult();
		}
		return result;
	}

}
