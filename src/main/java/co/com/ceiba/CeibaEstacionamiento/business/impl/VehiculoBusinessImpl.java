package co.com.ceiba.CeibaEstacionamiento.business.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.com.ceiba.CeibaEstacionamiento.business.IVehiculoBusiness;
import co.com.ceiba.CeibaEstacionamiento.dao.IVehiculoDAO;
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
	public String crearVehiculo(VehiculoModel vehiculo) {
		String resultado = "";
		try {
			String validaciones = validaciones(vehiculo);
			if (validaciones != null && validaciones.equals("")) {
				Boolean espacio = validacionEspacio(vehiculo.getIdtipo());
				String permitirIngreso = permitirIngreso(vehiculo.getIdplaca());
				if (espacio) {
					if(permitirIngreso.equals("")) {
						vehiculoDAO.crearVehiculo(vehiculo);
					}else{
						resultado = permitirIngreso;
					}
				} else {
					resultado = "El estacionamiento se encuentra completamente ocupado";
				}
			} else {
				resultado = validaciones;
			}
		} catch (Exception e) {
			resultado = "Ha ocurrido un error inesperado";
		}
		return resultado;
	}

	@Override
	public String eliminarVehiculo(VehiculoModel vehiculo) {
		vehiculoDAO.eliminarVehiculo(vehiculo);
		return "";
	}

	@Override
	public String actualizarVehiculo(VehiculoModel vehiculo) {
		vehiculoDAO.actualizarVehiculo(vehiculo);
		return "";
	}

	@Override
	public Integer contarCarros() {
		return vehiculoDAO.contarCarros();
	}

	@Override
	public Integer contarMotos() {
		return vehiculoDAO.contarMotos();
	}
	
	public String validaciones(VehiculoModel vehiculo) {
		String resultado = "";
		if(vehiculo.getCilindraje()==null || vehiculo.getCilindraje() == 0 ){
			resultado="El cilindraje es obligatorio";
		}
		if(vehiculo.getIdplaca() ==null || vehiculo.getIdplaca().isEmpty()){
			resultado = "La placa es obligatoria";
		}
		if(vehiculo.getIdtipo()==null || vehiculo.getIdtipo()==0){
			resultado = "El tipo de vehiculo es obligatorio";
		}
		return resultado;
	}
	
	public Boolean validacionEspacio(Integer idtipo) {
		Boolean espacio = true;
		if (idtipo == 1 && contarCarros() >= 20) {
			espacio = false;
		}
		if (idtipo == 2 && contarMotos() >= 10) {
			espacio = false;
		}
		return espacio;
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
	
	public String permitirIngreso(String placa) {
		String resultado = "";
		Boolean empizaConA = empiezaConA(placa);
		if(empizaConA){
			Calendar nowDate = Calendar.getInstance();
			Integer dia = nowDate.get(Calendar.DAY_OF_WEEK);
			if(dia==1 || dia==2) {
				resultado = "Las placa iniciadas con la letra A solo pueden ingresar los dias diferentes a los Lunes y Domingos";
			}
		}	
		return resultado;
	}
}
