import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

public class EnderecoUsuario {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EnderecoUsuario_SEQ")
	@SequenceGenerator(name = "EnderecoUsuario_SEQ", sequenceName = "seq_EnderecoUsuario", allocationSize = 1)
	@Column(name = "id", updatable = false, nullable = false)
	
	private Long id;
	private Long idEndereco;
	private Long idUsuario;
	private boolean Endereco;
	private boolean Usuario;
	@ManyToOne
	private Usuario usuarioProprietario;
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

	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
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
	
	public Usuario getUsuarioProprietario() {
		return usuarioProprietario;
	}

	public void setUsuarioProprietario(Usuario usuarioProprietario) {
		this.usuarioProprietario = usuarioProprietario;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date DataCriacao) {
		this.dataCriacao = DataCriacao;
	}

	public Date getDataUltimaAlteracao() {
		return dataUltimaAlteracao;
	}

	public void setDataUltimaAlteracao(Date dataUltimaAlteracao) {
		this.dataUltimaAlteracao = dataUltimaAlteracao;
	}
	public float getFrequenciaUsada() {
		return  frequenciaUsada;
	}

	public void setFrequenciaUsada(float  frequenciaUsada) {
		this. frequenciaUsada =  frequenciaUsada;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
