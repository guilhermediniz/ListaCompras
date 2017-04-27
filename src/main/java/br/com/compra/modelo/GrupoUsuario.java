package br.com.compra.modelo;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

public class GrupoUsuario {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GrupoUsuario_SEQ")
	@SequenceGenerator(name = "GrupoUsuario_SEQ", sequenceName = "seq_GrupoUsuario", allocationSize = 1)
	@Column(name = "id", updatable = false, nullable = false)
	
	private Long id;
	private String nome;
	private String descricao;
	@Transient
	private Lista<ListaItem> listaItemLista;
	@Transient
	private Lista<Usuario> usuarioLista;
	@ManyToOne
	private Usuario usuarioProprietario;
	private Date dataCriacao;
	private Date dataUltimaAlteracao;
	private Date dataRemocao;
	

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
	
	public Lista<ListaItem> getListaItemLista() {
		return listaItemLista;
	}

	public void setListaItemLista(Lista<ListaItem> listaItemLista) {
		this.listaItemLista = listaItemLista;
	}
	

	
	public Lista<Usuario> getUsuarioLista() {
		return usuarioLista;
	}

	public void setUsuarioLista(Lista<Usuario> usuarioLista) {
		this.usuarioLista = usuarioLista;
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
		return  dataUltimaAlteracao;
	}

	public void setDataUltimaAlteracao(Date  dataUltimaAlteracao) {
		this. dataUltimaAlteracao =  dataUltimaAlteracao;
	}

	public Date getDataRemocao() {
		return dataRemocao;
	}

	public void setDataRemocao(Date dataRemocao) {
		this.dataRemocao = dataRemocao;

	}
}







