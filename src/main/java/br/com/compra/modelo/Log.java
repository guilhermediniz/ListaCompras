package br.com.compra.modelo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class Log {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOG_SEQ")
	@SequenceGenerator(name = "LOG_SEQ", sequenceName = "seq_log", allocationSize = 1)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	private String tipo;
	private String descricao;
	private Long idUsuario;
	private Date dataCriacao;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao= dataCriacao;
	}
	
}
