package co.com.ceiba.CeibaEstacionamiento.modelTest;

import co.com.ceiba.CeibaEstacionamiento.model.TipoVehiculoModel;

public class TipoVehiculoBuilder {
	private Integer idtipo;
	private String tipo;
	
	public TipoVehiculoBuilder(){
		idtipo = 1;
		tipo = "CARRO";
    }
	
	public TipoVehiculoBuilder withTipo(String tipo){
        this.tipo = tipo;
        return this;
    }
    
    public TipoVehiculoBuilder withIdtipo(Integer idtipo){
        this.idtipo = idtipo;
        return this;
    }
    
    public TipoVehiculoModel build(){
        return new TipoVehiculoModel(this.idtipo, this.tipo);
    }
  
}
