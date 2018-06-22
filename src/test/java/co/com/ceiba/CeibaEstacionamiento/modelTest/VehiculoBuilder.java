package co.com.ceiba.CeibaEstacionamiento.modelTest;

import co.com.ceiba.CeibaEstacionamiento.model.VehiculoModel;

public class VehiculoBuilder {
	private String idplaca;
	private Integer cilindraje;
	private Integer idtipo;
	
	public VehiculoBuilder(){
		idplaca = "ABC123";
		cilindraje = 500;
		idtipo = 1;
    }
	
	public VehiculoBuilder withIdplaca(String idplaca){
        this.idplaca = idplaca;
        return this;
    }
    
    public VehiculoBuilder withIdtipo(Integer idtipo){
        this.idtipo = idtipo;
        return this;
    }
    
    public VehiculoBuilder withCilindraje(Integer cilindraje){
        this.cilindraje = cilindraje;
        return this;
    }
    
    public VehiculoModel build(){
        return new VehiculoModel(this.idplaca,this.cilindraje,this.idtipo);
    }

}
