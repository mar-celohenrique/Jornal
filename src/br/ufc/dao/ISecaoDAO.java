package br.ufc.dao;

import java.util.List;

import br.ufc.model.Secao;

public interface ISecaoDAO {
	
	public void inserirSecao(Secao secao);
	public void alterarSecao(Secao secao);
	public void removerSecao(Long id);
	public List<Secao> listarSecao();
	public Secao recuperarSecao(Long id);
	public Secao buscarSecao(String nome);
	
}
