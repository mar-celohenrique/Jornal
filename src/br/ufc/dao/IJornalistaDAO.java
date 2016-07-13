package br.ufc.dao;

import java.util.List;

import br.ufc.model.Jornalista;

public interface IJornalistaDAO {
	public void inserirJornalista(Jornalista jornalista);
	public void removerJornalista(Long id);
	public void alterarJornalista(Jornalista jornalista);
	public List<Jornalista> listarJornalista();
	public Jornalista recuperarJornalista(Long id);
	public Jornalista buscarJornalista(String login);
}
