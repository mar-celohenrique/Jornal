package br.ufc.dao;

import java.util.List;

import br.ufc.model.Classificado;

public interface IClassificadoDAO {
	public void inserirClassificado(Classificado classificado);
	public void alterarClassificado(Classificado classificado);
	public void removerClassificado(Long idClassificado);
	public Classificado recuperarClassificado(Long id);
	public List<Classificado> listarClassificado();
	public List<Classificado> listarClassificadoEditor(Long id);
	public List<Classificado> detalharClassificado(Long id);	
}
