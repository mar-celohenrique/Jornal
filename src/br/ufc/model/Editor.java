package br.ufc.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "editor")
public class Editor {

	@Id
	@Column(name = "idEditor", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idEditor;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String login;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String senha;
	@OneToMany(mappedBy = "editor", targetEntity = Classificado.class, fetch = FetchType.LAZY)
	private List<Classificado> classificados;

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Long getIdEditor() {
		return idEditor;
	}

	public void setIdEditor(Long idEditor) {
		this.idEditor = idEditor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

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
}
