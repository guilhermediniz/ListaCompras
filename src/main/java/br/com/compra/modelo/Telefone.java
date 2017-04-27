package br.com.compra.modelo;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

public class Telefone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Telefone_SEQ")
	@SequenceGenerator(name = "Telefone_SEQ", sequenceName = "seq_telefone", allocationSize = 1)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	private String ddd;
	private String numero;
	private float media;
	@ManyToOne
	private Usuario usuarioProprietario;
	private Date dataCriacao;
	private Date dataUltimaAlteracao;
	@Transient
	private LocalCompra listaItemLista;
	@Transient
	private Usuario usuarioLista;
	private String operacaoHora;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumber(String numero) {
		this.numero = numero;
	}
	
	public float getMedia() {
		return media;
	}

	public void setMedia(float Media) {
		this.media = media;
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

	public Date getDataUltimaAlteracao() {
		return dataUltimaAlteracao;
	}

	public void setDataUltimaAlteracao(Date dataUltimaAlteracao) {
		this.dataUltimaAlteracao = dataUltimaAlteracao;
	}

	public LocalCompra getListaItemLista() {
		return listaItemLista  
		
	}

	public void setListaItemLista(LocalCompra listaItemLista) {
		this.listaItemLista = listaItemLista;
	}

	public Usuario getUsuarioLista() {
		return usuarioLista;
	}

	public void setUsuarioLista(Usuario UsuarioLista) {
		this.usuarioLista = usuarioLista;
	}

	public String getOperacaoHora() {
		return operacaoHora;
	}

	public void setOperacaoHora(String operacaohora) {
		this.operacaoHora = operacaohora;
	}	
}