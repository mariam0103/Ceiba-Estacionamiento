package co.com.ceiba.CeibaEstacionamiento.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import co.com.ceiba.CeibaEstacionamiento.dao.IVehiculosEstacionadosDAO;
import co.com.ceiba.CeibaEstacionamiento.model.VehiculosEstacionadosModel;

@Repository
@Transactional
public class VehiculoEstacionadoDAOImpl implements IVehiculosEstacionadosDAO{
	
	@PersistenceContext	
    private EntityManager entityManager;
	
	@Override
	public void crearvehiculoEstacionado(VehiculosEstacionadosModel vehiculoEstacionado) {
		entityManager.persist(vehiculoEstacionado);
	}

}
