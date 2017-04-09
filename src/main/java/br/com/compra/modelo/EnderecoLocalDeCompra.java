package br.com.compra.modelo;

public class EnderecoLocalDeCompra {
	
	private Long id;
	private Long idEndereco;
	private Long idLocalCompra;
	private boolean Endereco;
	private boolean Usuario;
	
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
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
