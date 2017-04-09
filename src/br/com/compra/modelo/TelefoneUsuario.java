package br.com.compra.modelo;

import java.util.Date;



public class TelefoneUsuario {
	
	private Long id;
	private Long idTelefone;
	private Long idUsuario;
	private boolean Telefone;
	private boolean usuario;
	private String descricao;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public Long getIdTelefone() {
		return idTelefone;
	}

	public void setIdTelefone(Long idTelefone) {
		this.idTelefone = idTelefone;
	}

	public Long getIdUser() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public boolean getTelefone () {
		return Telefone;
	}

	public void setTelefone(boolean Telefone) {
		this.Telefone = Telefone;
	}

	public boolean getUsuario() {
		return usuario;
	}

	public void setUsuario(boolean Usuario) {
		this.usuario = Usuario;
	}

	

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
