package co.com.ceiba.CeibaEstacionamiento.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import co.com.ceiba.CeibaEstacionamiento.business.IVehiculoBusiness;
import co.com.ceiba.CeibaEstacionamiento.model.VehiculoModel;
import co.com.ceiba.CeibaEstacionamiento.modelTest.VehiculoBuilder;


@RestController
@RequestMapping(value = "/")
@CrossOrigin("http://localhost:4200")
public class VehiculoController {
	
	 	public static final String VEHICULO = "/vehiculo";
	 
	 	@Autowired
	    private IVehiculoBusiness vehiculoBusiness; 
	    
	    @GetMapping(VEHICULO)
	    public List<VehiculoModel> listado(HttpServletResponse resp){
	        return vehiculoBusiness.listado(); 
	    }
	    
	    
	    @PostMapping(VEHICULO)
	    public @ResponseBody VehiculoModel crearVehiculo(@RequestBody VehiculoModel vehiculo){
	    	//return vehiculoBusiness.crearVehiculo(vehiculo);
	    	return new VehiculoBuilder().build();
	    }
	    
	    @DeleteMapping(VEHICULO)
	    public String eliminarVehiculo(@RequestBody VehiculoModel vehiculo){
	    	vehiculoBusiness.eliminarVehiculo(vehiculo);
	        return "El vehiculo fue eliminado exitosamente";
	    }
	    
	    @PutMapping(VEHICULO)
	    public String actualizarProducto(@RequestBody VehiculoModel vehiculo){
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
