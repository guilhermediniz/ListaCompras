package br.com.compra.modelo;

import java.util.Date;
import java.util.List;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

public class ListaItem {
	
	private Long id;
	private String nome;
	private String descricao;
	@ManyToOne
	private Usuario usuarioProprietario;
	private Date dataCriacao;
	private Date dataUltimaAlteracao;
	@Transient
	private List<Item>itemLista;
	private Date dataCompra;
	@Transient
	private float peso;
	@Transient
	private Lista<GrupoUsuario> grupoLista;
	
	public Lista<Item> updateItemLista(ItemListaItemService itemListaItemService) throws Exception {
		this.itemLista=itemListaItemService.findByIdListItem(this.id);
		return itemLista;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Usuario getUsuarioProprietario() {
		return usuarioProprietario;
	}

	public void setUsuarioProprietario(Usuario usuarioProprietario) {
		this.usuarioProprietario = usuarioProprietario;
	}

	public Date getdataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	 public Date getDataUltimaAlteracao() {
			return dataUltimaAlteracao;
		    }

    public void setDataUltimaAlteracao(Date dataUltimaAlteracao) {
		    this.dataUltimaAlteracao = dataUltimaAlteracao;
	}

    public List<Item>getItemLista() {
	return itemLista;
    }

    public void setItemLista(List<Item> itemLista) {
	this.itemLista = itemLista;
    }

	public Date getDataCompra() {
	return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
	this.dataCompra = dataCompra;
	}	

}
