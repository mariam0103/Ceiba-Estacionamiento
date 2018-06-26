package co.com.ceiba.CeibaEstacionamiento.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_vehiculos_estacionados")
public class VehiculosEstacionadosModel{

	
	@EmbeddedId
	private VehiculosEstacionadosPK vehiculosEstacionadosPK;

    
    public VehiculosEstacionadosModel(VehiculosEstacionadosPK vehiculosEstacionadosPK) {
    	this.vehiculosEstacionadosPK=vehiculosEstacionadosPK;
    }
    
    public VehiculosEstacionadosModel() {
    }

	public VehiculosEstacionadosPK getId() {
		return vehiculosEstacionadosPK;
	}

	public void setId(VehiculosEstacionadosPK id) {
		this.vehiculosEstacionadosPK = id;
	}

}
