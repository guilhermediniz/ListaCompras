import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

public class EnderecoLocalDeCompra {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EnderecoLocalDeCompra_SEQ")
	@SequenceGenerator(name = "EnderecoLocalDeCompra_SEQ", sequenceName = "seq_", allocationSize = 1)
	@Column(name = "id", updatable = false, nullable = false)
	
	private Long id;
	private Long idEndereco;
	private Long idLocalCompra;
	private boolean Endereco;
	private boolean Usuario;
	@ManyToOne
	private usuario usuarioProprietario;
	private Date dataCriacao;
	private Date dataUltimaAlteracao;
	private float frequenciaUsada;
	private String descricao;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getIdEndereco() {
		return idEndereco;
	}

	public void setidEndereco(Long idEndereco ) {
		this.idEndereco = idEndereco;
	}

	public Long getidLocalCompra() {
		return idLocalCompra;
	}

	public void setidLocalCompra(Long idLocalCompra) {
		this.idLocalCompra = idLocalCompra;
	}

	public boolean getEndereco() {
		return Endereco;
	}

	public void setEndereco(boolean Endereco) {
		this.Endereco = Endereco;
	}

	public boolean getUsuario() {
		return Usuario;
	}

	public void setUsuario(boolean Usuario) {
		this.Usuario = Usuario;
	}
	
	
	public usuario getUsuarioProprietario() {
		return usuarioProprietario;
	}

	public void setUsuarioProprietario(usuario usuarioProprietario) {
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
    
	public float getFrequenciaUsada() {
		return frequenciaUsada;
	}

	public void setFrequenciaUsada(float FrequenciaUsada) {
		this.frequenciaUsada = frequenciaUsada;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
