package co.com.ceiba.CeibaEstacionamiento.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class VehiculosEstacionadosPK implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = -1617556012988679244L;
	
	@NotNull
    @Column(name="idestacionamiento")	
	protected Integer idestacionamiento;
	
	@NotNull
    @Column(name="idplaca")
	protected String idplaca;

	    public VehiculosEstacionadosPK() {}
	    
	    public VehiculosEstacionadosPK(Integer idestacionamiento, String idplaca) {
	        this.idestacionamiento = idestacionamiento;
	        this.idplaca = idplaca;
	    }

		public Integer getIdestacionamiento() {
			return idestacionamiento;
		}

		public void setIdestacionamiento(Integer idestacionamiento) {
			this.idestacionamiento = idestacionamiento;
		}

		public String getIdplaca() {
			return idplaca;
		}

		public void setIdplaca(String idplaca) {
			this.idplaca = idplaca;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((idestacionamiento == null) ? 0 : idestacionamiento.hashCode());
			result = prime * result + ((idplaca == null) ? 0 : idplaca.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			VehiculosEstacionadosPK other = (VehiculosEstacionadosPK) obj;
			if (idestacionamiento == null) {
				if (other.idestacionamiento != null)
					return false;
			} else if (!idestacionamiento.equals(other.idestacionamiento))
				return false;
			if (idplaca == null) {
				if (other.idplaca != null)
					return false;
			} else if (!idplaca.equals(other.idplaca))
				return false;
			return true;
		}
	
		
}
