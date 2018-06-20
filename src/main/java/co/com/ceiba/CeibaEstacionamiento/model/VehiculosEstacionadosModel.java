package co.com.ceiba.CeibaEstacionamiento.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_vehiculos_estacionados")
public class VehiculosEstacionadosModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3421796868741474508L;
	
	@EmbeddedId
	private VehiculosEstacionadosPK id;

    
    public VehiculosEstacionadosModel(VehiculosEstacionadosPK id) {
    	this.id=id;
    }
    
    public VehiculosEstacionadosModel() {
    }

	public VehiculosEstacionadosPK getId() {
		return id;
	}

	public void setId(VehiculosEstacionadosPK id) {
		this.id = id;
	}

}
