package co.com.ceiba.CeibaEstacionamiento.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.CeibaEstacionamiento.business.IEstacionamientoBusiness;
import co.com.ceiba.CeibaEstacionamiento.model.EstacionamientoModel;

@RestController
@RequestMapping(value = "/")
public class EstacionamientoController {
	public static final String ESTACIONAMIENTO = "/estacionamiento";
	
	@Autowired	
    private IEstacionamientoBusiness estacionamientoBusiness; 
    
    @GetMapping(ESTACIONAMIENTO)
    public List<EstacionamientoModel> listado(HttpServletResponse resp){
        return estacionamientoBusiness.listado(); 
    }
    
    @DeleteMapping(ESTACIONAMIENTO)
    public String eliminarEstacionamiento(@RequestBody EstacionamientoModel estacionamiento, HttpServletResponse resp){
    	estacionamientoBusiness.eliminarEstacionamiento(estacionamiento);
        return "El registro fue eliminado exitosamente";
    }
    
    @PutMapping(ESTACIONAMIENTO)
    public String actualizarEstacionamiento(@RequestBody EstacionamientoModel estacionamiento, HttpServletResponse resp){
    	estacionamientoBusiness.actualizarEstacionamiento(estacionamiento);
        return "El registro fue actualizado exitosamente";
    }
    
}
