package co.com.ceiba.CeibaEstacionamiento.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.CeibaEstacionamiento.business.IVehiculoEstacionadoBusiness;
import co.com.ceiba.CeibaEstacionamiento.model.VehiculoModel;

@RestController
@RequestMapping(value = "/")
@CrossOrigin("http://localhost:4200")
public class VehiculoEstacionadoController {
	public static final String VEHICULOESTACIONADO = "/vehiculoestacionado";
	
	@Autowired	
    private IVehiculoEstacionadoBusiness vehiculoEstacionadoBusiness; 

	@GetMapping(VEHICULOESTACIONADO +"/listaCarros")
	   public String listadoCarrosEstacionados(HttpServletResponse resp){
	   return vehiculoEstacionadoBusiness.listaCarrosEstacionados().toString();
	}
	
	@GetMapping(VEHICULOESTACIONADO +"/listaMotos")
	   public String listadoMotosEstacionados(HttpServletResponse resp){
	   return vehiculoEstacionadoBusiness.listaMotosEstacionadas().toString();
	}
	
	@PutMapping(VEHICULOESTACIONADO +"/precio")
	   public String precioEstacionamiento(@RequestBody VehiculoModel vehiculo,HttpServletResponse resp){
	   return vehiculoEstacionadoBusiness.precioVehiculo(vehiculo).toString();
	}
}
