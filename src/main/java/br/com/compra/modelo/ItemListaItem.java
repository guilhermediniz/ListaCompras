package br.com.compra.modelo;

import java.util.Date;

import javax.persistence.ManyToOne;

public class ItemListaItem {
	private Long id;
	private Long idItem;
	private Long idListaItem;
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
	
	public Long getIdItem() {
		return idItem;
	}

	public void setIdItem(Long idItem) {
		this.idItem = idItem;
	}

	public Long getIdListItem() {
		return idListaItem;
	}

	public void setIdListItem(Long idListaItem) {
		this.idListaItem = idListaItem;
	}
	
	public Usuario getUsuarioProprietario() {
		return usuarioProprietario;
	}

	public void setUsuarioProprietario(Usuario usuarioProprietario) {
		this.usuarioProprietario = usuarioProprietario;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
