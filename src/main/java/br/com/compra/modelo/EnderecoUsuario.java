package br.com.compra.modelo;

public class EnderecoUsuario {
	
	private Long id;
	private Long idEndereco;
	private Long idUsuario;
	private boolean Endereco;
	private boolean Usuario;
	
	
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

}
