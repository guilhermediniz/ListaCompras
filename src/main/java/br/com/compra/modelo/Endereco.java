package br.com.compra.modelo;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.springframework.data.annotation.Transient;

public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Endereco_SEQ")
	@SequenceGenerator(name = "Endereco_SEQ", sequenceName = "seq_endereco", allocationSize = 1)
	@Column(name = "id", updatable = false, nullable = false)
	
	private Long id;
	private String rua;
	private String complemento;
	private String bairro;
	private String cidade;
	private String distrito;
	private int numero;
	private String codigo;
	private float latitude;
	private float longitude;
	@Transient
	private float distancia;
	@ManyToOne
	private Usuario UsuarioProprietario;
	private Date dataCriacao;
	private Date dataUltimaAlteracao;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	
	public Usuario getUsuarioProprietario() {
		return UsuarioProprietario;
	}

	public void setUsuarioProprietario(Usuario UsuarioProprietario) {
		this.UsuarioProprietario = UsuarioProprietario;
	}

	public Date getdataCriacao() {
		return dataCriacao;
	}

	public void setdataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getdataUltimaAlteracao() {
		return dataUltimaAlteracao;
	}

	public void setdataUltimaAlteracao(Date dataUltimaAlteracao) {
		this.dataUltimaAlteracao = dataUltimaAlteracao;
	}
	
	
}
