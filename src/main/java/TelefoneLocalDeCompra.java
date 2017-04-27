public class TelefoneLocalDeCompra {
	
	private Long id;
	private Long idTelefone;
	private Long idLocalCompra;
	private boolean Telefone;
	private boolean LocalCompra;
	private String descricao;
	
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

	public boolean getLocalCompra() {
		return LocalCompra;
	}

	public void setLocalCompra(boolean LocalCompra) {
		this.LocalCompra = LocalCompra;
	}

	public boolean getTelefone() {
		return Telefone;
	}

	public void setTelefone(boolean Telefone) {
		this.Telefone = Telefone;
	}

	

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String Descricao) {
		this.descricao = descricao;
	}

	
}
