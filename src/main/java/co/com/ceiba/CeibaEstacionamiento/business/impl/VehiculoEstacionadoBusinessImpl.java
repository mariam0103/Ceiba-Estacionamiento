package co.com.ceiba.CeibaEstacionamiento.business.impl;

import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.CeibaEstacionamiento.business.IEstacionamientoBusiness;
import co.com.ceiba.CeibaEstacionamiento.business.IVehiculoEstacionadoBusiness;
import co.com.ceiba.CeibaEstacionamiento.dao.IVehiculosEstacionadosDAO;
import co.com.ceiba.CeibaEstacionamiento.exception.CeibaException;
import co.com.ceiba.CeibaEstacionamiento.model.EstacionamientoModel;
import co.com.ceiba.CeibaEstacionamiento.model.VehiculoModel;
import co.com.ceiba.CeibaEstacionamiento.model.VehiculosEstacionadosModel;
import co.com.ceiba.CeibaEstacionamiento.model.VehiculosEstacionadosPK;

@Service
public class VehiculoEstacionadoBusinessImpl implements IVehiculoEstacionadoBusiness{
	
	@Autowired
	private IVehiculosEstacionadosDAO vehiculosEstacionadosDAO;
	
	@Autowired	
    private IEstacionamientoBusiness estacionamientoBusiness;
	
	@Override
	public void crearvehiculoEstacionado(EstacionamientoModel estacionamiento,VehiculoModel vehiculo) {
		try {
			VehiculosEstacionadosModel vehiculoEstacionado = new VehiculosEstacionadosModel();
			VehiculosEstacionadosPK pk = new VehiculosEstacionadosPK(estacionamiento.getIdestacionamiento(),vehiculo.getIdplaca());
			vehiculoEstacionado.setId(pk);
			vehiculosEstacionadosDAO.crearvehiculoEstacionado(vehiculoEstacionado);
		} catch (Exception e) {
			throw new CeibaException("Ocurrio un error inesperado registrando el vehiculo en el estacionamiento");
		}
	}

	@Override
	public JSONArray listaCarrosEstacionados() {
		return vehiculosEstacionadosDAO.listaCarrosEstacionados();
	}

	@Override
	public JSONArray listaMotosEstacionadas() {
		return vehiculosEstacionadosDAO.listaMotosEstacionadas();
	}

	@Override
	public void estaElVehiculoEstacionado(VehiculoModel vehiculo) {
		if(vehiculosEstacionadosDAO.estaElVehiculoEstacionado(vehiculo)){
			throw new CeibaException("El vehiculo ya se encuentra registrado en el parqueadero");
		}
	}

	@Override
	public Double precioVehiculo(VehiculoModel vehiculo) {
		List<EstacionamientoModel> vehiculoEstacionado = estacionamientoBusiness.vehiculoEstacionado(vehiculo);
		return vehiculoEstacionado.get(0).getPrecio();
	}
	
	@Override
	public Double calcularPrecioEstacionamiento(VehiculoModel vehiculo, Date fechaingreso,Date fechasalida){
		Double precio = 0d;
		try {
			Integer diferencia=(int) ((fechasalida.getTime()-fechaingreso.getTime())/1000);
			Integer horas =diferencia/3600 != 0 ? diferencia/3600 : 1;
			Integer dias = horas / 24;
			Integer horasreciduo = horas%24;
			Integer valorHora = vehiculo.getIdtipo()==1 ? 1000 : 500;
			Integer valorDia = vehiculo.getIdtipo()==1 ? 8000 : 4000;
			
			if(horasreciduo>=9) {
				dias += 1;
			}else{
				Integer precioHoras = horasreciduo * valorHora;
				precio += Double.parseDouble(precioHoras.toString());
			}
			
			if(dias > 0) {
				Integer precioDias = dias * valorDia;
				precio += Double.parseDouble(precioDias.toString());
		    }
			
			if(vehiculo.getIdtipo()==2 && vehiculo.getCilindraje()!=null && vehiculo.getCilindraje()>500){
				precio += 2000;
			}
		} catch (Exception e) {
			throw new CeibaException("Ocurrio un error calculando el precio a pagar en el estacionamiento");
		}
		
		return precio;
	}

}
