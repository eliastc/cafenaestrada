package br.com.mpsuporteti.cafenaestrada.domain;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonTypeName;

import br.com.mpsuporteti.cafenaestrada.domain.enums.EstadoPagamento;

@Entity
@JsonTypeName("pagamentoComPIX")
public class PagamentoComPIX extends Pagamento {
	private static final long serialVersionUID = 1L;
	
	private String chave;
	
	public PagamentoComPIX() {		
	}

	public PagamentoComPIX(Integer id, EstadoPagamento estado, Pedido pedido, String chave) {
		super(id, estado, pedido);
		this.chave = chave;
		
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}
}
