package co.com.ceiba.CeibaEstacionamiento.dao.impl;
import java.util.List;
import java.util.Map;

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
	
	@SuppressWarnings("unchecked")
	@Override
	public JSONArray listaCarrosEstacionados() {
		JSONArray array = new JSONArray();
		try {
			Query query =  entityManager.createQuery("SELECT \r\n" + 
					"			e.fechasalida,v.idplaca" + 
					"			FROM EstacionamientoModel e\r\n" + 
					"			INNER JOIN VehiculosEstacionadosModel ve ON ve.vehiculosEstacionadosPK.idestacionamiento = e.idestacionamiento\r\n" + 
					"			INNER JOIN VehiculoModel v ON v.idplaca = ve.vehiculosEstacionadosPK.idplaca\r\n" + 
					"			WHERE v.idtipo = 1 AND e.fechasalida IS NULL AND e.precio IS NULL");
			List lista = query.getResultList();
			
//			for (Map<String, String> map : lista) {
//				JSONObject json = new JSONObject();
//				json.put("isplaca", map.get("idplaca"));
//				json.put("fechasalida", map.get("fechasalida"));
//				array.put(json);
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return array;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JSONArray listaMotosEstacionadas() {
		JSONArray array = new JSONArray();
		try {
			Query query =  entityManager.createQuery("SELECT \r\n" + 
					"			e.fechasalida,v.idplaca" + 
					"			FROM EstacionamientoModel e\r\n" + 
					"			INNER JOIN VehiculosEstacionadosModel ve ON ve.vehiculosEstacionadosPK.idestacionamiento = e.idestacionamiento\r\n" + 
					"			INNER JOIN VehiculoModel v ON v.idplaca = ve.vehiculosEstacionadosPK.idplaca\r\n" + 
					"			WHERE v.idtipo = 2 AND e.fechasalida IS NULL AND e.precio IS NULL");
			List<Map<String, String>> lista = query.getResultList();
			for (Map<String, String> map : lista) {
				JSONObject json = new JSONObject();
				json.put("", map.get(""));
				array.put(json);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return array;
	}

}
