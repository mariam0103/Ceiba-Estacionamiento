package co.com.ceiba.CeibaEstacionamiento.business.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.com.ceiba.CeibaEstacionamiento.business.IVehiculoBusiness;
import co.com.ceiba.CeibaEstacionamiento.dao.IVehiculoDAO;
import co.com.ceiba.CeibaEstacionamiento.exception.CeibaException;
import co.com.ceiba.CeibaEstacionamiento.model.VehiculoModel;

@Service
public class VehiculoBusinessImpl implements IVehiculoBusiness{
	
	@Autowired
	private IVehiculoDAO vehiculoDAO;
	 
	@Override
	public VehiculoModel getVehiculoById(String placa) {
		 return vehiculoDAO.getVehiculoById(placa);
	}

	@Override
	public List<VehiculoModel> listado() {
		 return vehiculoDAO.listado();
	}

	@Override
	public void crearVehiculo(VehiculoModel vehiculo) {
		try {
			validaciones(vehiculo);
			validacionEspacio(vehiculo.getIdtipo());
			permitirIngreso(vehiculo.getIdplaca());
			guardarVehiculo(vehiculo);
		} catch (Exception e) {
			throw new CeibaException("Ha ocurrido un error inesperado");
		}
	}

	@Override
	public void eliminarVehiculo(VehiculoModel vehiculo) {
		vehiculoDAO.eliminarVehiculo(vehiculo);
	}

	@Override
	public void actualizarVehiculo(VehiculoModel vehiculo) {
		vehiculoDAO.actualizarVehiculo(vehiculo);
	}

	@Override
	public Integer contarCarros() {
		return vehiculoDAO.contarCarros();
	}

	@Override
	public Integer contarMotos() {
		return vehiculoDAO.contarMotos();
	}
	
	public void validaciones(VehiculoModel vehiculo) {
		if(vehiculo.getCilindraje()==null || vehiculo.getCilindraje() == 0 ){
			throw new CeibaException("El cilindraje es obligatorio");
		}
		if(vehiculo.getIdplaca() ==null || vehiculo.getIdplaca().isEmpty()){
			throw new CeibaException("La placa es obligatoria");
		}
		if(vehiculo.getIdtipo()==null || vehiculo.getIdtipo()==0){
			throw new CeibaException("El tipo de vehiculo es obligatorio");
		}
	}
	
	public void validacionEspacio(Integer idtipo) {
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
	
	public Boolean empiezaConA(String placa) {
		Boolean letraA = false;
		if(placa !=null && !placa.isEmpty() && placa.length()>0) {
			String primeraLetraPlaca = placa.substring(0,1);
			if(primeraLetraPlaca.equals("A")) {
				letraA = true;
			}
		}
		return letraA;
	}
	
	public void permitirIngreso(String placa) {
		Boolean empizaConA = empiezaConA(placa);
		if(empizaConA){
			Calendar nowDate = Calendar.getInstance();
			Integer dia = nowDate.get(Calendar.DAY_OF_WEEK);
			if(dia==1 || dia==2) {
				throw new CeibaException("Las placa iniciadas con la letra A solo pueden ingresar los dias diferentes a los Lunes y Domingos");
			}
		}	
	}
	
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
