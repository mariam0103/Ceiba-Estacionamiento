package co.com.ceiba.CeibaEstacionamiento.business;

import java.util.List;

import co.com.ceiba.CeibaEstacionamiento.model.EstacionamientoModel;

public interface IEstacionamientoBusiness {
	EstacionamientoModel getEstacionamientoById(int id);
    List<EstacionamientoModel> listado();
    void crearEstacionamiento(EstacionamientoModel estacionamiento);
    void eliminarEstacionamiento(EstacionamientoModel estacionamiento);
    void actualizarEstacionamiento(EstacionamientoModel estacionamiento);
}
