package co.com.ceiba.CeibaEstacionamiento.dao.impl;

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

	@Override
	public void crearVehiculo(VehiculoModel vehiculo) {
		entityManager.persist(vehiculo);
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
	public Integer contarCarros() {
		Integer result = 20;
		try {
			Query query =  entityManager.createQuery("SELECT \r\n" + 
					"			COUNT(DISTINCT ve.vehiculosEstacionadosPK.idplaca)\r\n" + 
					"			FROM EstacionamientoModel e\r\n" + 
					"			INNER JOIN VehiculosEstacionadosModel ve ON ve.vehiculosEstacionadosPK.idestacionamiento = e.idestacionamiento\r\n" + 
					"			INNER JOIN VehiculoModel v ON v.idplaca = ve.vehiculosEstacionadosPK.idplaca\r\n" + 
					"			WHERE v.idtipo = 1 AND e.fechasalida IS NULL AND e.precio IS NULL");
			result = Integer.parseInt(query.getSingleResult().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Integer contarMotos() {
		Integer result = 10;
		try {
			Query query =  entityManager.createQuery("SELECT \r\n" + 
					"			COUNT(DISTINCT ve.vehiculosEstacionadosPK.idplaca)\r\n" + 
					"			FROM EstacionamientoModel e\r\n" + 
					"			INNER JOIN VehiculosEstacionadosModel ve ON ve.vehiculosEstacionadosPK.idestacionamiento = e.idestacionamiento\r\n" + 
					"			INNER JOIN VehiculoModel v ON v.idplaca = ve.vehiculosEstacionadosPK.idplaca\r\n" + 
					"			WHERE v.idtipo = 2 AND e.fechasalida IS NULL AND e.precio IS NULL");
			result = Integer.parseInt(query.getSingleResult().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
