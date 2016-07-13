package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.ufc.model.Noticia;
import br.ufc.model.Secao;

@Repository
public class NoticiaDAO implements INoticiaDAO {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void inserirNoticia(Noticia noticia) {
		manager.persist(noticia);
	}

	@Override
	public void alterarNoticia(Noticia noticia) {
		manager.merge(noticia);
	}

	@Override
	public void removerNoticia(Long id) {
		Noticia noticia = manager.find(Noticia.class, id);
		if (noticia != null) {
			manager.remove(noticia);
		}
	}

	@Override
	public List<Noticia> listarNoticia() {
		List<Noticia> noticias = manager.createQuery(
				"select n from noticia as n", Noticia.class).getResultList();
		return noticias;
	}
	

	@Override
	public Noticia recuperarNoticia(Long id) {
		Noticia noticia = manager.find(Noticia.class, id);
		if (noticia != null) {
			return noticia;
		}
		return null;
	}

	@Override
	public List<Noticia> pesquisarNoticia(String titulo) {
		String hql = "select n from noticia as n where n.titulo=:param_titulo";
		Query q = manager.createQuery(hql);
		List<Noticia> resultado = q.setParameter("param_titulo", titulo)
				.getResultList();

		return resultado;
	}

	@Override
	public List<Noticia> listarNoticiaJornalista(Long idJornalista) {
		String hql = "select n from noticia as n where n.idJornalista=:param_titulo";
		Query q = manager.createQuery(hql);
		List<Noticia> resultado = q.setParameter("param_titulo", idJornalista)
				.getResultList();

		return resultado;
	}

	@Override
	public List<Noticia> detalharNoticia(Long id) {
		String hql = "select n from noticia as n where n.idNoticia=:param_titulo";
		Query q = manager.createQuery(hql);
		List<Noticia> resultado = q.setParameter("param_titulo", id)
				.getResultList();

		return resultado;
	}

	@Override
	public List<Noticia> listarNoticiaSecao(Secao secao) {
		String hql = "select a from noticia as a where a.secao = :param_titulo";
		Query query = manager.createQuery(hql);
		List<Noticia> noticiasSecao = query.setParameter("param_titulo", secao).getResultList();
		return noticiasSecao;
	}

	

}
