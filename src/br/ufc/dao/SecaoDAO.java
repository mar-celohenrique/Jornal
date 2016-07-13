package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.ufc.model.Jornalista;
import br.ufc.model.Secao;

public class SecaoDAO implements ISecaoDAO {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void inserirSecao(Secao secao) {
		manager.persist(secao);
	}

	@Override
	public void alterarSecao(Secao secao) {
		manager.merge(secao);
	}

	@Override
	public void removerSecao(Long id) {
		Secao secao = manager.find(Secao.class, id);
		if (secao != null) {
			manager.remove(secao);
		}
	}

	@Override
	public List<Secao> listarSecao() {
		List<Secao> secao = manager.createQuery("select s from secao as s",
				Secao.class).getResultList();
		return secao;
	}

	@Override
	public Secao recuperarSecao(Long id) {
		Secao secao = manager.find(Secao.class, id);
		if (secao != null) {
			return secao;
		}
		return null;
	}

	@Override
	public Secao buscarSecao(String nome) {
		String hql = "select s from secao as s where s.nome=:param_titulo";
		Query q = manager.createQuery(hql);
		List<Secao> resultado = q.setParameter("param_titulo", nome)
				.getResultList();

		if (resultado != null) {
			return resultado.get(0);
		}

		return null;

	}

}
