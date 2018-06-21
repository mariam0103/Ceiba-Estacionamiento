package co.com.ceiba.CeibaEstacionamiento.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.CeibaEstacionamiento.business.ITipoVehiculoBusiness;
import co.com.ceiba.CeibaEstacionamiento.model.TipoVehiculoModel;


@RestController
@RequestMapping(value = "/")
public class TipoVehiculoController {
	
	 public static final String TIPO = "/tipovehiculo";
	
	 @Autowired
	 private ITipoVehiculoBusiness tipoVehiculoBusiness; 
	 
	 @GetMapping(TIPO)
	 public List<TipoVehiculoModel> listado(HttpServletResponse resp){
	      return tipoVehiculoBusiness.listado(); 
	 }
}
