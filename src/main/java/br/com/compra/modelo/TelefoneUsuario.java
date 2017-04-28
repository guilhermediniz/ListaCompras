package br.com.compra.modelo;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

public class TelefoneUsuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="TelefoneUsuario_SEQ")
	@SequenceGenerator(name = "TelefoneUsuario_SEQ", sequenceName = "seq_TelefoneUsuario", allocationSize = 1)
	@Column(name = "id", updatable = false, nullable = false)
	
	private Long id;
	private Long idTelefone;
	private Long idUsuario;
	private boolean Telefone;
	private boolean usuario;
	
	@ManyToOne
	private Usuario usuarioProprietario;
	private Date dataCriacao;
	private String descricao;
	private float taxa;
	
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

	public Long getIdUsuario() {
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

	public float getTaxa() {
		return taxa;
	}

	public void setTaxa(float taxa) {
		this.taxa = taxa;
	}
}
