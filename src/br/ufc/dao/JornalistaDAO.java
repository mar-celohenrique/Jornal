package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.ufc.model.Jornalista;

@Repository
public class JornalistaDAO implements IJornalistaDAO {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void inserirJornalista(Jornalista jornalista) {
		manager.persist(jornalista);
	}

	@Override
	public void removerJornalista(Long id) {
		Jornalista jornalista = manager.find(Jornalista.class, id);
		if (jornalista != null) {
			manager.remove(jornalista);
		}
	}

	@Override
	public void alterarJornalista(Jornalista jornalista) {
		manager.merge(jornalista);
	}

	@Override
	public List<Jornalista> listarJornalista() {
		List<Jornalista> jornalistas = manager.createQuery(
				"select j from jornalista as j", Jornalista.class)
				.getResultList();
		return jornalistas;
	}

	@Override
	public Jornalista recuperarJornalista(Long id) {
		Jornalista jornalista = manager.find(Jornalista.class, id);
		return jornalista;
	}

	@Override
	public Jornalista buscarJornalista(String login) {
		String hql = "select j from jornalista as j where j.login=:param_titulo";
		Query q = manager.createQuery(hql, Jornalista.class);
		List<Jornalista> resultado = q.setParameter("param_titulo", login)
				.getResultList();
		
		if(!resultado.isEmpty()){
			return resultado.get(0);
		}
		
		return null;
	}

}
