import java.util.Date;
import javax.persistence.ManyToOne;

public class TelefoneLocalDeCompra {
	
	private Long id;
	private Long idTelefone;
	private Long idLocalCompra;
	private boolean Telefone;
	private boolean LocalCompra;
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

	public Long getIdLocalCompra() {
		return idLocalCompra;
	}

	public void setIdLocalCompra(Long idLocalCompra) {
		this.idLocalCompra = idLocalCompra;
	}
	
	public boolean getTelefone() {
		return Telefone;
	}

	public void setTelefone(boolean Telefone) {
		this.Telefone = Telefone;
	}

	public boolean getLocalCompra() {
		return LocalCompra;
	}

	public void setLocalCompra(boolean LocalCompra) {
		this.LocalCompra = LocalCompra;
	}

	public User getUsuarioProprietario() {
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

	public void setDescricao(String Descricao) {
		this.descricao = descricao;
	}	
	
	public float getTaxa() {
		return taxa;
	}

	public void setTaxa(float taxa) {
		this.taxa = taxa;
	}

}

