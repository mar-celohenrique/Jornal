package br.ufc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.Length;

@Entity(name = "noticia")
public class Noticia {

	@Id
	@Column(name = "idNoticia", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idNoticia;

	@Column(nullable = false)
	private String titulo;
	@Column(nullable = false)
	private String subtitulo;
	@Column(nullable = false)
	private String data;
	@Column(nullable = false)
	@Length(max = 10000)
	private String texto;

	@Column(name = "idSecao", insertable = false, updatable = false, nullable = false)
	private Long idSecao;
	
	@Column(name = "idJornalista", insertable = false, updatable = false)
	private Long idJornalista;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "idJornalista", referencedColumnName = "idJornalista")
	private Jornalista jornalista;

	public Long getIdJornalista() {
		return idJornalista;
	}

	public void setIdJornalista(Long idJornalista) {
		this.idJornalista = idJornalista;
	}

	public Jornalista getJornalista() {
		return jornalista;
	}

	public void setJornalista(Jornalista jornalista) {
		this.jornalista = jornalista;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "idSecao", referencedColumnName = "idSecao")
	private Secao secao;

	public Long getIdNoticia() {
		return idNoticia;
	}

	public void setIdNoticia(Long idNoticia) {
		this.idNoticia = idNoticia;
	}

	public Long getIdSecao() {
		return idSecao;
	}

	public void setIdSecao(Long idSecao) {
		this.idSecao = idSecao;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSubtitulo() {
		return subtitulo;
	}

	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}

	public Secao getSecao() {
		return secao;
	}

	public void setSecao(Secao secao) {
		this.secao = secao;
	}

}
