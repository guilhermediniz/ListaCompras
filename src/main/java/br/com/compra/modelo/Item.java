package br.com.compra.modelo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ITEM_SEQ")
	@SequenceGenerator(name = "ITEM_SEQ", sequenceName = "seq_item", allocationSize = 1)
	@Column(name = "id", updatable = false, nullable = false)
	
	private Long id;
	private String nome;
	private String marca;
	private String descricao;
	private String DicasUltilizacao;
	@Transient
	private int numeroVendas;
	@Transient
	private int numeroLugares;
	@Transient
	private int ListaNumero;
	private Date dataCriacao;
	private Date dataUltimaAlteracao;
	private String HoraOperacao;
	@ManyToOne
	private Usuario usuarioProprietario;
	@Transient
	private List<ListaItem> listaItemLista;
	
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

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
		
	}
	
	public String getDicasUltilizacao() {
		return DicasUltilizacao ;
	}

	public void setDicasUltilizacao(String DicasUltilizacao) {
		this.DicasUltilizacao = DicasUltilizacao;
	}

	public int getNumeroVendas() {
		return numeroVendas;
	}

	public void setNumeroVendas(int numeroVendas) {
		this.numeroVendas = numeroVendas;
	}
	
	public int getNumeroLugares() {
		return numeroLugares;
	}

	public void setNumeroLugares(int numeroLugares) {
		this.numeroLugares = numeroLugares;
	}

	public int getListaNumero() {
		return ListaNumero;
	}

	public void setListaNumero(int ListaNumero) {
		this.ListaNumero = ListaNumero;
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
	
	public String getHoraOperacao() {
		return HoraOperacao;
	}

	public void setHoraOperacao(String HoraOperacao) {
		this.HoraOperacao = HoraOperacao;
	}
	public Usuario getUsuarioProprietario() {
		return usuarioProprietario;
	}

	public void setUsuarioProprietario(Usuario usuarioProprietario) {
		this.usuarioProprietario = usuarioProprietario;
	}
	
	public List<ListaItem> getListaItemLista() {
		return listaItemLista;
	}

	public void setListaItemLista(Lista<ListaItem> listaItemLista) {
		this.listaItemLista = listaItemLista;
	}
	
}