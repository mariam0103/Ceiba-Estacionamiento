package co.com.ceiba.CeibaEstacionamiento.business;

import org.json.JSONArray;

import co.com.ceiba.CeibaEstacionamiento.model.VehiculosEstacionadosModel;

public interface IVehiculoEstacionadoBusiness {
	void crearvehiculoEstacionado(VehiculosEstacionadosModel vehiculoEstacionado);
	JSONArray listaCarrosEstacionados();
	JSONArray listaMotosEstacionadas();
}
