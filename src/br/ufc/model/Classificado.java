package br.ufc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "classificado")
public class Classificado {

	@Id
	@Column(name = "idClassificado", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idClassificado;
	@Column(nullable = false)
	private String texto;
	@Column(nullable = false)
	private Double precoInicial;
	@Column(nullable = false)
	private String telefoneContato;
	@Column(nullable = false)
	private String titulo;
	
	@Column(name = "idEditor", insertable = false, updatable = false)
	private Long idEditor;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "idEditor", referencedColumnName = "idEditor")
	private Editor editor;

	

	public Long getIdEditor() {
		return idEditor;
	}

	public void setIdEditor(Long idEditor) {
		this.idEditor = idEditor;
	}

	public Editor getEditor() {
		return editor;
	}

	public void setEditor(Editor editor) {
		this.editor = editor;
	}

	

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Long getIdClassificado() {
		return idClassificado;
	}

	public void setIdClassificado(Long idClassificado) {
		this.idClassificado = idClassificado;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Double getPrecoInicial() {
		return precoInicial;
	}

	public void setPrecoInicial(Double precoInicial) {
		this.precoInicial = precoInicial;
	}

	public String getTelefoneContato() {
		return telefoneContato;
	}

	public void setTelefoneContato(String telefoneContato) {
		this.telefoneContato = telefoneContato;
	}

}
