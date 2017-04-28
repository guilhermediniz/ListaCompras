package br.com.compra.modelo;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

public class LocalCompra {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LocalCompra_SEQ")
	@SequenceGenerator(name = "LocalCompra_SEQ", sequenceName = "seq_LocalCompra", allocationSize = 1)
	@Column(name = "id", updatable = false, nullable = false)
	
	private Long id;
	private String nome;
	private String descricao;	
	@Transient
	private Endereco Endereco;
	@Transient
	private float preco;
	@Transient
	private Lista<LocalDeCompraItemPreco> localDeCompraItemPreco;
	private String  HoraOperacao;
	private Date dataCriacao;
	private Date dataUltimaAlteracao;
	private String email;
	@Transient
	private Lista<Item> itemLista;
	@Transient
	private Telefone Telefone;
	@ManyToOne
	private Usuario usuarioProprietario;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setName(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
		
	public Lista<LocalDeCompraItemPreco> getLocalDeCompraItemPreco() {
		return LocalDeCompraItemPreco;
	}

	public void setLocalDeCompraItemPreco(Lista<LocalDeCompraItemPreco> LocalDeCompraItemPreco) {
	    this.LocalDeCompraItemPreco = LocalDeCompraItemPreco;
	}
	public String getHoraOperacao() {
		return HoraOperacao;
	}

	public void setHoraOperacao(String HoraOperacao) {
		this.HoraOperacao = HoraOperacao;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getdataUltimaAlteracao() {
		return dataUltimaAlteracao;
	}

	public void setDataUltimaAlteracao(Date dataUltimaAlteracao) {
		this.dataUltimaAlteracao = dataUltimaAlteracao;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Lista<Item> getItemLista() {
		return itemLista;
	}

	public void setItemLista(Lista<Item> itemLista) {
		this.itemLista = itemLista;
	}
	
	public Telefone getTelefone() {
		return Telefone;
	}

	public void setTelefone(Telefone Telefone) {
		this.Telefone = Telefone;
	}
	
	public Usuario getUsuarioProprietario() {
		return usuarioProprietario;
	}

	public void setUsuarioProprietario(Usuario usuarioProprietario) {
		this.usuarioProprietario = usuarioProprietario;
	}
}
