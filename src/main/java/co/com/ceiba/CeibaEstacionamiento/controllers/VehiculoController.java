package co.com.ceiba.CeibaEstacionamiento.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.CeibaEstacionamiento.business.IVehiculoBusiness;
import co.com.ceiba.CeibaEstacionamiento.model.VehiculoModel;


@RestController
@RequestMapping(value = "/")
@CrossOrigin("http://localhost:4200")
public class VehiculoController {
	
	 	public static final String VEHICULO = "/vehiculo";
	 
	 	@Autowired
	    private IVehiculoBusiness vehiculoBusiness; 

	    @PostMapping(VEHICULO)
	    public @ResponseBody VehiculoModel crearVehiculo(@RequestBody VehiculoModel vehiculo){
	    	return vehiculoBusiness.crearVehiculo(vehiculo);
	    }

	    @GetMapping(VEHICULO+"/contarCarros")
	    public Integer contarCarros(HttpServletResponse resp){
	        return vehiculoBusiness.contarCarros();
	    }
	    
	    @GetMapping(VEHICULO+"/contarMotos")
	    public Integer contarMotos(HttpServletResponse resp){
	        return vehiculoBusiness.contarMotos();
	    }
	    
	    @PutMapping(VEHICULO)
	    public @ResponseBody VehiculoModel salidaVehiculo(@RequestBody VehiculoModel vehiculo){
	    	return vehiculoBusiness.actualizarVehiculo(vehiculo);
	    } 
	    
}
