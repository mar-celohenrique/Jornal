package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.ufc.model.Editor;

@Repository
public class EditorDAO implements IEditorDAO{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Editor buscarEditor(String login) {
		String hql = "select e from editor as e where e.login = :param_titulo";
		Query q = manager.createQuery(hql, Editor.class);
		List<Editor> resultado = q.setParameter("param_titulo", login)
				.getResultList();

		if(!resultado.isEmpty()){
			return resultado.get(0);
		}
		
		return null;
	}

	@Override
	public Editor recuperarEditor(Long id) {
		Editor editor = manager.find(Editor.class, id);
		if(editor != null){
			return editor;
		}
		return null;
	}

}
