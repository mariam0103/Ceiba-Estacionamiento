package co.com.ceiba.CeibaEstacionamiento.business;

import org.json.JSONArray;

import co.com.ceiba.CeibaEstacionamiento.model.EstacionamientoModel;
import co.com.ceiba.CeibaEstacionamiento.model.VehiculoModel;

public interface IVehiculoEstacionadoBusiness {
	void crearvehiculoEstacionado(EstacionamientoModel estacionamiento,VehiculoModel vehiculo);
	JSONArray listaCarrosEstacionados();
	JSONArray listaMotosEstacionadas();
	void estaElVehiculoEstacionado(VehiculoModel vehiculo);
}
