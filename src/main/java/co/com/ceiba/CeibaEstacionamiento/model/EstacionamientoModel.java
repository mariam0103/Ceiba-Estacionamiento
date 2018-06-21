package co.com.ceiba.CeibaEstacionamiento.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_estacionamiento")
public class EstacionamientoModel {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID_ESTACIONAMIENTO")
    private Integer idestacionamiento;
    
	@NotNull
    @Column(name="FECHA_INGRESO")
    private Date fechaingreso;
    
    @Column(name="FECHA_SALIDA")
    private Date fechasalida;
    
    @Column(name="PRECIO")
    private Double precio;
    
    
    public EstacionamientoModel(Integer idestacionamiento,Date fechaingreso ,Date fechasalida ,Double precio){
    	this.idestacionamiento=idestacionamiento;
    	this.fechaingreso=fechaingreso;
    	this.fechasalida=fechasalida;
    	this.precio=precio;
    }
    
    public EstacionamientoModel() {
    }

	public Integer getIdestacionamiento() {
		return idestacionamiento;
	}

	public void setIdestacionamiento(Integer idestacionamiento) {
		this.idestacionamiento = idestacionamiento;
	}

	public Date getFechaingreso() {
		return fechaingreso;
	}

	public void setFechaingreso(Date fechaingreso) {
		this.fechaingreso = fechaingreso;
	}

	public Date getFechasalida() {
		return fechasalida;
	}

	public void setFechasalida(Date fechasalida) {
		this.fechasalida = fechasalida;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
  
}
