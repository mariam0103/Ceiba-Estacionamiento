package co.com.ceiba.CeibaEstacionamiento.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.com.ceiba.CeibaEstacionamiento.business.IVehiculoBusiness;
import co.com.ceiba.CeibaEstacionamiento.model.VehiculoModel;


@RestController
@RequestMapping(value = "/")
public class VehiculoController {
	
	 	public static final String VEHICULO = "/vehiculo";
	 
	 	@Autowired
	    private IVehiculoBusiness vehiculoBusiness; 
	    
	    @GetMapping(VEHICULO)
	    public List<VehiculoModel> listado(HttpServletResponse resp){
	        return vehiculoBusiness.listado(); 
	    }
	    
	    @PostMapping(VEHICULO)
	    public String crearVehiculo(@RequestBody VehiculoModel vehiculo, HttpServletResponse resp){
	    	String guardar = vehiculoBusiness.crearVehiculo(vehiculo);
	    	return guardar;
	    }
	    
	    @DeleteMapping(VEHICULO)
	    public String eliminarVehiculo(@RequestBody VehiculoModel vehiculo, HttpServletResponse resp){
	    	vehiculoBusiness.eliminarVehiculo(vehiculo);
	        return "El vehiculo fue eliminado exitosamente";
	    }
	    
	    @PutMapping(VEHICULO)
	    public String actualizarProducto(@RequestBody VehiculoModel vehiculo, HttpServletResponse resp){
	    	vehiculoBusiness.actualizarVehiculo(vehiculo);
	        return "El vehiculo fue actualizado exitosamente";
	    }
	    
	    @GetMapping(VEHICULO+"/contarCarros")
	    public Integer contarCarros(HttpServletResponse resp){
	        return vehiculoBusiness.contarCarros();
	    }
	    
	    @GetMapping(VEHICULO+"/contarMotos")
	    public Integer contarMotos(HttpServletResponse resp){
	        return vehiculoBusiness.contarMotos();
	    }
	    
	    
}
