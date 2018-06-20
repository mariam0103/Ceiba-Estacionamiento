package co.com.ceiba.CeibaEstacionamiento.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_tipo_vehiculo")
public class TipoVehiculoModel {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID_TIPO")
    private Integer idtipo;
    
    @NotNull
    @Column(name="TIPO")
    private String tipo;

    public TipoVehiculoModel() {
    }
    
    public TipoVehiculoModel(Integer idtipo,String tipo) {
    	this.idtipo=idtipo;
    	this.tipo=tipo;
    }

	public Integer getIdtipo() {
		return idtipo;
	}

	public void setIdtipo(Integer idtipo) {
		this.idtipo = idtipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idtipo == null) ? 0 : idtipo.hashCode());
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
		TipoVehiculoModel other = (TipoVehiculoModel) obj;
		if (idtipo == null) {
			if (other.idtipo != null)
				return false;
		} else if (!idtipo.equals(other.idtipo))
			return false;
		return true;
	}
    
    
    
}
