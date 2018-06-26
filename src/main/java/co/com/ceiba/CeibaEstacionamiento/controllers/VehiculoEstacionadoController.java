package co.com.ceiba.CeibaEstacionamiento.controllers;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.CeibaEstacionamiento.business.IVehiculoEstacionadoBusiness;
import co.com.ceiba.CeibaEstacionamiento.model.VehiculosEstacionadosModel;

@RestController
@RequestMapping(value = "/")
public class VehiculoEstacionadoController {
	public static final String VEHICULOESTACIONADO = "/vehiculoestacionado";
	
	@Autowired	
    private IVehiculoEstacionadoBusiness vehiculoEstacionadoBusiness; 
	
	@PostMapping(VEHICULOESTACIONADO)
    public String crearEstacionamiento(@RequestBody VehiculosEstacionadosModel vehiculoEstacionado, HttpServletResponse resp){
		vehiculoEstacionadoBusiness.crearvehiculoEstacionado(vehiculoEstacionado);
        return "El registro fue creado exitosamente";
    }
	
	 @GetMapping(VEHICULOESTACIONADO +"/listaCarros")
	    public JSONArray listado(HttpServletResponse resp){
	    return vehiculoEstacionadoBusiness.listaCarrosEstacionados();
	 }
	
}
