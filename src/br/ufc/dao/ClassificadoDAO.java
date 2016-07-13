package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.ufc.model.Classificado;

@Repository
public class ClassificadoDAO implements IClassificadoDAO {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void inserirClassificado(Classificado classificado) {
		manager.persist(classificado);
	}

	@Override
	public void alterarClassificado(Classificado classificado) {
		manager.merge(classificado);
	}

	@Override
	public void removerClassificado(Long idClassificado) {
		Classificado classificado = manager.find(Classificado.class, idClassificado);
		if (classificado != null) {
			manager.remove(classificado);
		}
	}

	@Override
	public Classificado recuperarClassificado(Long id) {
		Classificado classificado = manager.find(Classificado.class, id);
		return classificado;
	}

	@Override
	public List<Classificado> listarClassificado() {
		List<Classificado> classificados = manager.createQuery("select c from classificado as c", Classificado.class)
				.getResultList();
		return classificados;

	}

	@Override
	public List<Classificado> listarClassificadoEditor(Long id) {
		String hql = "select c from classificado as c where c.idEditor=:param_titulo";
		Query q = manager.createQuery(hql);
		List<Classificado> classificados = q.setParameter("param_titulo", id).getResultList();
		return classificados;
	}

	@Override
	public List<Classificado> detalharClassificado(Long id) {
		String hql = "select c from classificado as c where c.idClassificado=:param_titulo";
		Query q = manager.createQuery(hql);
		List<Classificado> classificados = q.setParameter("param_titulo", id).getResultList();		
		return classificados;
	}

}
