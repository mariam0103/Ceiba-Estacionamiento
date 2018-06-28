package co.com.ceiba.CeibaEstacionamiento.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_vehiculos")
public class VehiculoModel {
	    @Id
	    @Column(name="ID_PLACA")
	    private String idplaca;
	    
	    @Column(name="CILINDRAJE")
	    private Integer cilindraje;
	    
	    @NotNull
	    @Column(name="ID_TIPO")
	    private Integer idtipo;
	    
	    
	    public VehiculoModel(String idplaca, int cilindraje , int idtipo){
	    	this.idplaca=idplaca;
	    	this.cilindraje=cilindraje;
	    	this.idtipo=idtipo;
	    }
	    
	    public VehiculoModel() {
	    }

		public String getIdplaca() {
			return idplaca;
		}

		public void setIdplaca(String idplaca) {
			this.idplaca = idplaca;
		}

		public Integer getCilindraje() {
			return cilindraje;
		}

		public void setCilindraje(Integer cilindraje) {
			this.cilindraje = cilindraje;
		}

		public Integer getIdtipo() {
			return idtipo;
		}

		public void setIdtipo(Integer idtipo) {
			this.idtipo = idtipo;
		}

}
