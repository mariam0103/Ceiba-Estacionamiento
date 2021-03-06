package co.com.ceiba.CeibaEstacionamiento.business.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.CeibaEstacionamiento.business.IEstacionamientoBusiness;
import co.com.ceiba.CeibaEstacionamiento.business.IVehiculoBusiness;
import co.com.ceiba.CeibaEstacionamiento.business.IVehiculoEstacionadoBusiness;
import co.com.ceiba.CeibaEstacionamiento.dao.IVehiculoDAO;
import co.com.ceiba.CeibaEstacionamiento.exception.CeibaException;
import co.com.ceiba.CeibaEstacionamiento.model.EstacionamientoModel;
import co.com.ceiba.CeibaEstacionamiento.model.VehiculoModel;

@Service
public class VehiculoBusinessImpl implements IVehiculoBusiness{
	
	@Autowired
	private IVehiculoDAO vehiculoDAO;
	
	
	@Autowired
	private IVehiculoEstacionadoBusiness vehiculoEstacionadoBusiness; 
	
	@Autowired	
    private IEstacionamientoBusiness estacionamientoBusiness; 
	
	@Override
	public VehiculoModel getVehiculoById(String placa) {
		 return vehiculoDAO.getVehiculoById(placa);
	}


	@Override
	public VehiculoModel crearVehiculo(VehiculoModel vehiculo) {
		//Validaciones previas a que se modifique o se guarde el registro del vehiculo
		vehiculoEstacionadoBusiness.estaElVehiculoEstacionado(vehiculo);
		validacionesVehiculoModel(vehiculo);
		validacionEspacioEstacionamiento(vehiculo.getIdtipo());
		permitirIngresoVehiculosConPlacaA(vehiculo.getIdplaca());
		
		//Se guarda o se modifica el vehiculo
		guardarVehiculo(vehiculo);
		
		//Se guarda el registro del vehiculo en el estacionamiento
		EstacionamientoModel estacionamiento = estacionamientoBusiness.crearEstacionamiento();	
		vehiculoEstacionadoBusiness.crearvehiculoEstacionado(estacionamiento,vehiculo);
		
		return vehiculo;
	}

	@Override
	public VehiculoModel actualizarVehiculo(VehiculoModel vehiculo) {
		List<EstacionamientoModel> vehiculoEstacionado = estacionamientoBusiness.vehiculoEstacionado(vehiculo);
		EstacionamientoModel estacionamiento = vehiculoEstacionado.get(0);
		Calendar outDate = Calendar.getInstance();
		Double precio = vehiculoEstacionadoBusiness.calcularPrecioEstacionamiento(vehiculo, estacionamiento.getFechaingreso(),outDate.getTime());
		estacionamiento.setPrecio(precio);
		estacionamiento.setFechasalida(outDate.getTime());
		estacionamientoBusiness.actualizarEstacionamiento(estacionamiento);
		return vehiculo;
	}

	@Override
	public Integer contarCarros() {
		return vehiculoDAO.contarCarros(); 
	}

	@Override
	public Integer contarMotos() {
		return vehiculoDAO.contarMotos();
	}
	
	@Override
	public void validacionesVehiculoModel(VehiculoModel vehiculo) {
		if(vehiculo.getIdplaca() ==null || vehiculo.getIdplaca().isEmpty()){
			throw new CeibaException("La placa es obligatoria");
		}
		if(vehiculo.getIdtipo()==null || vehiculo.getIdtipo()==0){
			throw new CeibaException("El tipo de vehiculo es obligatorio");
		}
		if(vehiculo.getIdtipo()==2 && (vehiculo.getCilindraje()==null || vehiculo.getCilindraje() == 0)) {
			throw new CeibaException("El cilindraje es obligatorio");
		}
	}
	
	@Override
	public void validacionEspacioEstacionamiento(Integer idtipo) {
		Boolean espacio = true;
		if (idtipo == 1 && contarCarros() >= 20) {
			espacio = false;
		}
		if (idtipo == 2 && contarMotos() >= 10) {
			espacio = false;
		}
		if(!espacio) {
			throw new CeibaException("El estacionamiento se encuentra completamente ocupado");
		}
	}
	
	@Override
	public Boolean empiezaConA(String placa) {
		Boolean letraA = false;
		try {
			if(placa !=null && !placa.isEmpty() && placa.length()>0) {
				String primeraLetraPlaca = placa.substring(0,1);
				if(primeraLetraPlaca.equals("A")) {
					letraA = true;
				}
			}
		} catch (Exception e) {
			throw new CeibaException("Ha ocurrido un error evaluando la placa del vehiculo");
		}
		
		return letraA;
	}
	
	@Override
	public void permitirIngresoVehiculosConPlacaA(String placa) {
			Boolean empizaConA = empiezaConA(placa);
			if(empizaConA){
				Calendar nowDate = Calendar.getInstance();
				Integer dia = nowDate.get(Calendar.DAY_OF_WEEK);
				if(dia!=1 || dia!=2) {
					throw new CeibaException("Las placa iniciadas con la letra A solo pueden ingresar los dias diferentes a los Lunes y Domingos");
				}
			}	
	} 
	
	@Override
	public void guardarVehiculo(VehiculoModel vehiculo){
		VehiculoModel existeVehiculo=getVehiculoById(vehiculo.getIdplaca());
		try {
			if(existeVehiculo!=null) {
				vehiculoDAO.actualizarVehiculo(vehiculo);
			}else {
				vehiculoDAO.crearVehiculo(vehiculo);
			}
		} catch (Exception e) {
			throw new CeibaException("Ocurrio un error registrando el vehiculo");
		}
	}
	
	
}
