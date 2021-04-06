package br.com.mpsuporteti.cafenaestrada.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mpsuporteti.cafenaestrada.domain.ItemPedido;
import br.com.mpsuporteti.cafenaestrada.domain.Pedido;
import br.com.mpsuporteti.cafenaestrada.domain.enums.EstadoPagamento;
import br.com.mpsuporteti.cafenaestrada.repositories.ItemPedidoRepository;
import br.com.mpsuporteti.cafenaestrada.repositories.PagamentoRepository;
import br.com.mpsuporteti.cafenaestrada.repositories.PedidoRepository;
import br.com.mpsuporteti.cafenaestrada.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
		}
	
	@Transactional
	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(new Date());
		obj.getPagamento().setEstado(EstadoPagamento.QUITADO);
		obj.getPagamento().setPedido(obj);
		obj = repo.save(obj);
		pagamentoRepository.save(obj.getPagamento());
		for(ItemPedido ip : obj.getItens()) {
			ip.setDesconto(0.0);			
		//	ip.setProduto(produtoService.find(ip.getProduto().getId()));
			ip.setPreco(produtoService.find(ip.getProduto().getId()).getPreco());
			ip.setPedido(obj);
		}
		
		itemPedidoRepository.saveAll(obj.getItens());
		return obj;
	}

}
