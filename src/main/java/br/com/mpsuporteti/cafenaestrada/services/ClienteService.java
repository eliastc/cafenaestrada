package br.com.mpsuporteti.cafenaestrada.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.mpsuporteti.cafenaestrada.domain.Cliente;
import br.com.mpsuporteti.cafenaestrada.domain.Veiculo;
import br.com.mpsuporteti.cafenaestrada.domain.enums.TipoCliente;
import br.com.mpsuporteti.cafenaestrada.dto.ClienteDTO;
import br.com.mpsuporteti.cafenaestrada.dto.ClienteNewDTO;
import br.com.mpsuporteti.cafenaestrada.repositories.ClienteRepository;
import br.com.mpsuporteti.cafenaestrada.repositories.VeiculoRepository;
import br.com.mpsuporteti.cafenaestrada.services.exceptions.DataIntegrityException;
import br.com.mpsuporteti.cafenaestrada.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
		}

	public Cliente insert(Cliente obj) {
		obj.setId(null);
		obj = repo.save(obj);
		veiculoRepository.saveAll(obj.getVeiculo());
		return obj;
	}
	
	public Cliente update(Cliente obj) {
		Cliente newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());		
	}


	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);		
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir");
		}
	}
	
	public List<Cliente> findAll() {
		return repo.findAll();
	}
	
	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Cliente fromDTO(ClienteDTO objDto) {
		return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null);
	}
	
	public Cliente fromDTO(ClienteNewDTO objDto) {
		Cliente cli = new Cliente(null, objDto.getNome(), objDto.getEmail(), objDto.getCpfOuCnpj(), TipoCliente.toEnum(objDto.getTipo()));
		Veiculo vei = new Veiculo(null, objDto.getModelo() ,objDto.getPlaca(), objDto.getCor(), cli);
		cli.getVeiculo().add(vei);
		cli.getTelefones().add(objDto.getTelefone1());
		if(objDto.getTelefone2()!=null) {
			cli.getTelefones().add(objDto.getTelefone2());
		}		
		return cli;
	}
}
