package br.ufc.dao;

import java.util.List;

import br.ufc.model.Noticia;
import br.ufc.model.Secao;

public interface INoticiaDAO {

	public void inserirNoticia(Noticia noticia);
	public void alterarNoticia(Noticia noticia);
	public void removerNoticia(Long id);
	public List<Noticia> listarNoticia();
	public Noticia recuperarNoticia(Long id);
	public List<Noticia> pesquisarNoticia(String titulo);
	public List<Noticia> detalharNoticia(Long id);
	public List<Noticia> listarNoticiaJornalista(Long idJornalista);
	public List<Noticia> listarNoticiaSecao(Secao secao);
	
}
