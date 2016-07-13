package br.ufc.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "secao")
public class Secao {

	@Id
	@Column(name = "idSecao", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idSecao;

	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String descricao;

	@OneToMany(mappedBy = "secao", targetEntity = Noticia.class, fetch = FetchType.EAGER)
	private List<Noticia> noticias;


	public Long getIdSecao() {
		return idSecao;
	}

	public void setIdSecao(Long idSecao) {
		this.idSecao = idSecao;
	}

	public List<Noticia> getNoticias() {
		return noticias;
	}

	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
