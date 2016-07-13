package br.ufc.dao;

import br.ufc.model.Editor;

public interface IEditorDAO {
	public Editor buscarEditor(String login);
	public Editor recuperarEditor(Long id);
}
