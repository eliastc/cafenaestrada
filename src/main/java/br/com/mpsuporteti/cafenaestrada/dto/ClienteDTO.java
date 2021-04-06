package br.com.mpsuporteti.cafenaestrada.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.mpsuporteti.cafenaestrada.domain.Cliente;
import br.com.mpsuporteti.cafenaestrada.domain.Veiculo;
import br.com.mpsuporteti.cafenaestrada.services.validation.ClienteUpdate;

@ClienteUpdate
public class ClienteDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 5, max = 120, message = "O tamanho deve estar entre 5 e 120 caracteres")
	private String nome;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Email(message = "Email inválido")
	private String email;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Veiculo> veiculos = new ArrayList<>();
	
	public ClienteDTO() {		
	}
	
	public ClienteDTO(Cliente obj) {
		id = obj.getId();
		nome = obj.getNome();
		email = obj.getEmail();		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
}
