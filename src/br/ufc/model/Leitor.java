package br.ufc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="leitor")
public class Leitor {

	@Id
	@Column(name = "idLeitor", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idLeitor;
	public Long getIdLeitor() {
		return idLeitor;
	}
	public void setIdLeitor(Long idLeitor) {
		this.idLeitor = idLeitor;
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
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String login;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)	
	private String senha;
	
}
