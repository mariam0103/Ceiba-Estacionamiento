package co.com.ceiba.CeibaEstacionamiento.modelTest;

import java.util.Date;

import co.com.ceiba.CeibaEstacionamiento.model.EstacionamientoModel;

public class EstacionamientoBuilder {
	private Integer idestacionamiento;
	private Date fechaingreso;
	private Date fechasalida;
	private Double precio;
	
	 public EstacionamientoBuilder(){
		 	Date date = new Date();
	    	this.idestacionamiento=1;
	    	this.fechaingreso= date;
	    	this.fechasalida= date;
	    	this.precio=0D;
	 }
	 
	 public EstacionamientoBuilder withIdEstacionamiento(Integer idestacionamiento){
	        this.idestacionamiento = idestacionamiento;
	        return this;
	 }
	 
	 public EstacionamientoBuilder withFechaIngreso(Date fechaingreso){
	        this.fechaingreso = fechaingreso;
	        return this;
	 }
	 
	 public EstacionamientoBuilder withFechaSalida(Date fechasalida){
	        this.fechasalida = fechasalida;
	        return this;
	 }
	 
	 public EstacionamientoBuilder withPrecio(Double precio){
	        this.precio = precio;
	        return this;
	 }
	 
	 public EstacionamientoModel build(){
	        return new EstacionamientoModel(this.idestacionamiento,this.fechaingreso ,this.fechasalida ,this.precio);
	 } 
}
