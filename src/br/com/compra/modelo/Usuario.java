package br.com.compra.modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Transient;

import br.com.compra.modelo.abstrata.pessoa;
import br.com.lista.model.GroupUser;
import br.com.lista.model.Item;
import br.com.lista.model.ListItem;

@Entity
public class Usuario extends pessoa {

	private String email;
	private String senha;
	protected Date dataCriacao;
	protected Date dataUltimaAlteracao;
	@Transient
	private List<ListaItem> listaItemLista;	
	@Transient
	private GrupoUsuario grupoUsuario;
	@Transient
	private List<Item> itemLista;
	
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

	public Date getDataCriacao() {
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

	public List<ListaItem> getListaItemLista() {
		return listaItemLista;
	}

	public void setListaItemLista(List<ListaItem> listaItemLista) {
		this.listaItemLista = listaItemLista;
	}

	public GrupoUsuario getGrupoUsuario() {
		return grupoUsuario;
	}

	public void setGrupoUsuario(GrupoUsuario grupoUsuario) {
		this.grupoUsuario = grupoUsuario;
	}

	public List<Item> getItemLista() {
		return itemLista;
	}

	public void setItemLista(List<Item> itemLista) {
		this.itemLista = itemLista;
	}		
}