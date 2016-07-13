package br.ufc.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "jornalista")
public class Jornalista {

	@Id
	@Column(name = "idJornalista", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idJornalista;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String login;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)	
	private String senha;
	
	@OneToMany(mappedBy = "jornalista", targetEntity = Noticia.class, fetch = FetchType.LAZY)
	private List<Noticia> noticias;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Long getIdJornalista() {
		return idJornalista;
	}

	public void setIdJornalista(Long idJornalista) {
		this.idJornalista = idJornalista;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
