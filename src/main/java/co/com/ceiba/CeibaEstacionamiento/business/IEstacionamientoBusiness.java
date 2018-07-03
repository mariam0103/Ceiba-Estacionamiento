package co.com.ceiba.CeibaEstacionamiento.business;

import java.util.List;

import co.com.ceiba.CeibaEstacionamiento.model.EstacionamientoModel;
import co.com.ceiba.CeibaEstacionamiento.model.VehiculoModel;

public interface IEstacionamientoBusiness {
	EstacionamientoModel getEstacionamientoById(int id);
    void actualizarEstacionamiento(EstacionamientoModel estacionamiento);
    EstacionamientoModel crearEstacionamiento();
    List<EstacionamientoModel> vehiculoEstacionado(VehiculoModel vehiculo);
}
