package br.com.mpsuporteti.cafenaestrada.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PontoDistribuicao implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String logradouro;
	private String numero;
	private String pontoReferencia;
	private String bairro;
	private String proximoA;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	/*
	@ManyToOne
	@JoinColumn(name = "cidade_id")
	private Cidade cidade;
	*/
	public PontoDistribuicao() {		
	}

	public PontoDistribuicao(Integer id, String logradouro, String numero, String pontoReferencia, String bairro, String proximoA,
			Cliente cliente) {
		super();
		this.id = id;
		this.logradouro = logradouro;
		this.numero = numero;
		this.setPontoReferencia(pontoReferencia);
		this.bairro = bairro;
		this.proximoA = proximoA;
		this.cliente = cliente;
	//	this.setCidade(cidade);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getPontoReferencia() {
		return pontoReferencia;
	}

	public void setPontoReferencia(String pontoReferencia) {
		this.pontoReferencia = pontoReferencia;
	}
	
	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getProximoA() {
		return proximoA;
	}

	public void setproximoA(String proximoA) {
		this.proximoA = proximoA;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	/*
	@JsonIgnore
	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PontoDistribuicao other = (PontoDistribuicao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
}
