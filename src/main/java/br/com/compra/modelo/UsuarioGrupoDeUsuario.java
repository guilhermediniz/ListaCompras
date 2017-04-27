package br.com.compra.modelo;

import java.util.Date;
import javax.persistence.ManyToOne;



public class UsuarioGrupoDeUsuario {
	
	private Long id;
	private Long idUsuario;
	private Long idGrupo;
	@ManyToOne
	private Usuario usuarioProprietario;
	private Date dataCriacao;
	private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Long getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(Long idGrupo) {
		this.idGrupo = idGrupo;
	}
	

	public Usuario getUsuarioProprietario() {
		return usuarioProprietario;
	}

	public void setUsuarioProprietario(Usuario UsuarioProprietario) {
		this.usuarioProprietario = UsuarioProprietario;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date DataCriacao) {
		this.DataCriacao = DataCriacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}	

