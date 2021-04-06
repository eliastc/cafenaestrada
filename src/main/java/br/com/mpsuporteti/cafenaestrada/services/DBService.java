package br.com.mpsuporteti.cafenaestrada.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mpsuporteti.cafenaestrada.domain.Categoria;
import br.com.mpsuporteti.cafenaestrada.domain.Cidade;
import br.com.mpsuporteti.cafenaestrada.domain.Cliente;
import br.com.mpsuporteti.cafenaestrada.domain.Estado;
import br.com.mpsuporteti.cafenaestrada.domain.ItemPedido;
import br.com.mpsuporteti.cafenaestrada.domain.Pagamento;
import br.com.mpsuporteti.cafenaestrada.domain.PagamentoComCartao;
import br.com.mpsuporteti.cafenaestrada.domain.PagamentoComPIX;
import br.com.mpsuporteti.cafenaestrada.domain.Pedido;
import br.com.mpsuporteti.cafenaestrada.domain.PontoDistribuicao;
import br.com.mpsuporteti.cafenaestrada.domain.Produto;
import br.com.mpsuporteti.cafenaestrada.domain.Veiculo;
import br.com.mpsuporteti.cafenaestrada.domain.enums.EstadoPagamento;
import br.com.mpsuporteti.cafenaestrada.domain.enums.TipoCliente;
import br.com.mpsuporteti.cafenaestrada.repositories.CategoriaRepository;
import br.com.mpsuporteti.cafenaestrada.repositories.CidadeRepository;
import br.com.mpsuporteti.cafenaestrada.repositories.ClienteRepository;
import br.com.mpsuporteti.cafenaestrada.repositories.EstadoRepository;
import br.com.mpsuporteti.cafenaestrada.repositories.ItemPedidoRepository;
import br.com.mpsuporteti.cafenaestrada.repositories.PagamentoRepository;
import br.com.mpsuporteti.cafenaestrada.repositories.PedidoRepository;
import br.com.mpsuporteti.cafenaestrada.repositories.PontoDistribuicaoRepository;
import br.com.mpsuporteti.cafenaestrada.repositories.ProdutoRepository;
import br.com.mpsuporteti.cafenaestrada.repositories.VeiculoRepository;

@Service
public class DBService {
	

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	//@Autowired
	//private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PontoDistribuicaoRepository pontoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private VeiculoRepository VeiculoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public void instantiateTestDataBase() throws ParseException {
		Categoria cat1 = new Categoria(null, "Pães");
		Categoria cat2 = new Categoria(null, "Bebidas");
		Categoria cat3 = new Categoria(null, "Bolachas");
		Categoria cat4 = new Categoria(null, "Biscoitos");
		Categoria cat5 = new Categoria(null, "Frios");
		Categoria cat6 = new Categoria(null, "Enlatados");
		Categoria cat7 = new Categoria(null, "Grãos");
		
		Produto p1 = new Produto(null, "Pão Françês", 9.99);
		Produto p2 = new Produto(null, "Refrigerante", 8.98);
		Produto p3 = new Produto(null, "Sanduiche de Queijo", 3.99);
		Produto p4 = new Produto(null, "Sanduiche de Queijo Prato", 3.99);
		Produto p5 = new Produto(null, "Sanduiche de Queijo Coalho", 3.99);
		Produto p6 = new Produto(null, "Sanduiche de Queijo do Reino", 3.99);
		Produto p7 = new Produto(null, "Cachorro Quente", 3.99);
		Produto p8 = new Produto(null, "Sanduiche Misto", 3.99);
		Produto p9 = new Produto(null, "Sanduiche Misto Quente", 3.99);
		Produto p10 = new Produto(null, "Cuscuz", 3.99);
		Produto p11 = new Produto(null, "Macacheira", 3.99);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		cat3.getProdutos().addAll(Arrays.asList(p3, p4, p5));
		cat4.getProdutos().addAll(Arrays.asList(p1, p5));
		cat5.getProdutos().addAll(Arrays.asList(p3, p11));
		cat6.getProdutos().addAll(Arrays.asList(p6,p7,p8,p9));
		cat7.getProdutos().addAll(Arrays.asList(p6,p7,p8,p9, p10, p11));
		
		p1.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p2.getCategorias().addAll(Arrays.asList(cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1, cat5));
		p4.getCategorias().addAll(Arrays.asList(cat3));
		p5.getCategorias().addAll(Arrays.asList(cat3));
		p6.getCategorias().addAll(Arrays.asList(cat6, cat7));
		p7.getCategorias().addAll(Arrays.asList(cat6, cat7));
		p8.getCategorias().addAll(Arrays.asList(cat6, cat7));
		p9.getCategorias().addAll(Arrays.asList(cat6, cat7));
		p10.getCategorias().addAll(Arrays.asList(cat7));
		p11.getCategorias().addAll(Arrays.asList(cat7));
		
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11));
		
		
		Estado est1 = new Estado(null, "Pernambuco");
		Estado est2 = new Estado(null, "Paraíba");
		
		Cidade cid1 = new Cidade(null, "Recife", est1);
		Cidade cid2 = new Cidade(null, "Olinda", est1);
		Cidade cid3 = new Cidade(null, "João Pessoa", est2);
		
		est1.getCidades().addAll(Arrays.asList(cid1, cid2));
		est2.getCidades().addAll(Arrays.asList(cid3));
		
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(cid1,cid2,cid3));
		
		Cliente cli1 = new Cliente(null, "Elias Teotonio", "eliasteocalado@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("3446.5893", "98824.3638"));
		
		//cli1.addPerfil(Perfil.ADMIN);
		
		//aqui vai vir os enderecos dos pontos de distribuicao
	//	Endereco end1 = new Endereco(null, "Rua Souza Bandeira" , "211", "null", "Cordeiro", "50011-150", cli1, cid1);
	//	Endereco end2 = new Endereco(null, "Rua Padre Leonardo Greco" , "129", "A", "Cordeiro", "50720-670", cli1, cid1);
		
		PontoDistribuicao pt1 = new PontoDistribuicao(null, "Av. Caxangá" , "1002", "Farmácia Drogasil", "Cordeiro", "CentroCar", cli1);
		PontoDistribuicao pt2 = new PontoDistribuicao(null, "Av. Caxangá" , "1412", "Igreja Vitoria em Cristo", "Cordeiro", "Exposição de animais", cli1);
		
	//	cli1.getEnderecos().addAll(Arrays.asList(end1, end2));
		cli1.getPontos().addAll(Arrays.asList(pt1));
		cli1.getPontos().addAll(Arrays.asList(pt2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
	//	enderecoRepository.saveAll(Arrays.asList(end1, end2));
		pontoRepository.saveAll(Arrays.asList(pt1, pt2));
		
		
		Veiculo veic1 = new Veiculo(null,"Corsa", "DDF-8415", "Preto", cli1);
		cli1.getVeiculo().addAll(Arrays.asList(veic1));
		VeiculoRepository.saveAll(Arrays.asList(veic1));
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Pedido ped1 = new Pedido(null, sdf.parse("19/01/2021 07:33"),  cli1, pt1);
		Pedido ped2 = new Pedido(null, sdf.parse("22/04/2021 8:17"), cli1, pt2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 3);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComPIX(null, EstadoPagamento.QUITADO, ped2, "81 98824.3638");
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 12.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 17.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 1.5, 1, 19.5);
		
		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
	}

}
