package co.com.ceiba.CeibaEstacionamiento.dao;

import org.json.JSONArray;

import co.com.ceiba.CeibaEstacionamiento.model.VehiculoModel;
import co.com.ceiba.CeibaEstacionamiento.model.VehiculosEstacionadosModel;

public interface IVehiculosEstacionadosDAO {
	void crearvehiculoEstacionado(VehiculosEstacionadosModel vehiculoEstacionado);
	JSONArray listaCarrosEstacionados();
	JSONArray listaMotosEstacionadas();
	Boolean estaElVehiculoEstacionado(VehiculoModel vehiculo);
}
