package br.com.compra.modelo;

public class LocalDeCompraItemPreco {
	
	private Long id;
	private Long idItem;
	
	private String nomeItem;
	private Long idLocalCompra;
	private boolean item;
	private boolean LocalCompra;
	private float preco;

	public String getNomeItem() {
		return nomeItem;
	}

	public void setNomeItem(String nomeItem) {
		this.nomeItem = nomeItem;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdItem() {
		return idItem;
	}

	public void setIdItem(Long idItem) {
		this.idItem = idItem;
	}

	public Long getIdLocalCompra() {
		return idLocalCompra;
	}

	public void setIdLocalCompra(Long idLocalCompra) {
		this.idLocalCompra = idLocalCompra;
	}

	public boolean getItem() {
		return item;
	}

	public void setItem(boolean item) {
		this.item = item;
	}

	public boolean getLocalCompra() {
		return LocalCompra;
	}

	public void setLocalCompra(boolean LocalCompra) {
		this.LocalCompra = LocalCompra;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	
	
}
