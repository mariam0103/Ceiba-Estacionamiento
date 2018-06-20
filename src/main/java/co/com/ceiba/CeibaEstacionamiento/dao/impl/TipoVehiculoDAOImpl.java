package co.com.ceiba.CeibaEstacionamiento.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import co.com.ceiba.CeibaEstacionamiento.dao.ITipoVehiculoDAO;
import co.com.ceiba.CeibaEstacionamiento.model.TipoVehiculoModel;

@Repository
@Transactional
public class TipoVehiculoDAOImpl implements ITipoVehiculoDAO{
	
	@PersistenceContext	
    private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TipoVehiculoModel> listado() {
		Query query =  entityManager.createQuery("SELECT b FROM Brands b");
		List<TipoVehiculoModel> resultList = query.getResultList();
		return resultList;
	}

}
