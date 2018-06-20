package co.com.ceiba.CeibaEstacionamiento.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class VehiculosEstacionadosPK implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = -1617556012988679244L;

	protected Integer idestacionamiento;
	protected String idplaca;

	    public VehiculosEstacionadosPK() {}
	    
	    public VehiculosEstacionadosPK(Integer idestacionamiento, String idplaca) {
	        this.idestacionamiento = idestacionamiento;
	        this.idplaca = idplaca;
	    }
}
