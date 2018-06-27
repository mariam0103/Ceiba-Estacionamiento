package co.com.ceiba.CeibaEstacionamiento.dao.impl;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import co.com.ceiba.CeibaEstacionamiento.dao.IVehiculosEstacionadosDAO;
import co.com.ceiba.CeibaEstacionamiento.model.VehiculosEstacionadosModel;

@Repository
@Transactional
public class VehiculoEstacionadoDAOImpl implements IVehiculosEstacionadosDAO{
	
	@PersistenceContext	
    private EntityManager entityManager;
	
	@Override
	public void crearvehiculoEstacionado(VehiculosEstacionadosModel vehiculoEstacionado) {
		entityManager.persist(vehiculoEstacionado);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public JSONArray listaCarrosEstacionados() {
		JSONArray array = new JSONArray();
		try {
			Query query =  entityManager.createQuery("SELECT \r\n" + 
					"			e.fechaingreso,v.idplaca" + 
					"			FROM EstacionamientoModel e\r\n" + 
					"			INNER JOIN VehiculosEstacionadosModel ve ON ve.vehiculosEstacionadosPK.idestacionamiento = e.idestacionamiento\r\n" + 
					"			INNER JOIN VehiculoModel v ON v.idplaca = ve.vehiculosEstacionadosPK.idplaca\r\n" + 
					"			WHERE v.idtipo = 1 AND e.fechasalida IS NULL AND e.precio IS NULL");
			List lista = query.getResultList();
			for(int i=0; i< lista.size(); i++) {
				JSONObject json = new JSONObject();
				Object[] object = (Object[]) lista.get(i);
				json.put("fechaingreso", object[0] != null ? object[0].toString() : "");
				json.put("idplaca", object[1] != null ? object[1].toString() : "");
				array.put(json);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return array;
	}


	@SuppressWarnings("rawtypes")
	@Override
	public JSONArray listaMotosEstacionadas() {
		JSONArray array = new JSONArray();
		try {
			Query query =  entityManager.createQuery("SELECT \r\n" + 
					"			e.fechaingreso,v.idplaca,v.cilindraje" + 
					"			FROM EstacionamientoModel e\r\n" + 
					"			INNER JOIN VehiculosEstacionadosModel ve ON ve.vehiculosEstacionadosPK.idestacionamiento = e.idestacionamiento\r\n" + 
					"			INNER JOIN VehiculoModel v ON v.idplaca = ve.vehiculosEstacionadosPK.idplaca\r\n" + 
					"			WHERE v.idtipo = 2 AND e.fechasalida IS NULL AND e.precio IS NULL");
			List lista = query.getResultList();
			for(int i=0; i< lista.size(); i++) {
				JSONObject json = new JSONObject();
				Object[] object = (Object[]) lista.get(i);
				json.put("fechaingreso", object[0] != null ? object[0].toString() : "");
				json.put("idplaca", object[1] != null ? object[1].toString() : "");
				json.put("cilindraje", object[2] != null ? object[2].toString() : "");
				array.put(json);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return array;
	}

}
