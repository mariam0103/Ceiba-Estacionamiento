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
}
