package co.com.ceiba.CeibaEstacionamiento.dao;

import java.util.List;

import co.com.ceiba.CeibaEstacionamiento.model.EstacionamientoModel;

public interface IEstacionamientoDAO {
	EstacionamientoModel getEstacionamientoById(int id);
    List<EstacionamientoModel> listado();
    void crearEstacionamiento(EstacionamientoModel estacionamiento);
    void eliminarEstacionamiento(EstacionamientoModel estacionamiento);
    void actualizarEstacionamiento(EstacionamientoModel estacionamiento);
}
