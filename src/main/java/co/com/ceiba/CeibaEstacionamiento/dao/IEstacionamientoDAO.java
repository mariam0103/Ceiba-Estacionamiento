package co.com.ceiba.CeibaEstacionamiento.dao;
import java.util.List;

import co.com.ceiba.CeibaEstacionamiento.model.EstacionamientoModel;
import co.com.ceiba.CeibaEstacionamiento.model.VehiculoModel;

public interface IEstacionamientoDAO {
	EstacionamientoModel getEstacionamientoById(int id);
    void crearEstacionamiento(EstacionamientoModel estacionamiento);
    void actualizarEstacionamiento(EstacionamientoModel estacionamiento);
    List<EstacionamientoModel> vehiculoEstacionado(VehiculoModel vehiculo);
}
