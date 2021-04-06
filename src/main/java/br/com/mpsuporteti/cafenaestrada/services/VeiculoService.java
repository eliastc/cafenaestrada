package br.com.mpsuporteti.cafenaestrada.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mpsuporteti.cafenaestrada.domain.Veiculo;
import br.com.mpsuporteti.cafenaestrada.repositories.VeiculoRepository;

@Service
public class VeiculoService {
	
	@Autowired
	private VeiculoRepository repo;
	
	public Veiculo update(Veiculo obj) {
		//Veiculo newObj = find(obj.getId());
	//	updateData(newObj, obj);
		return repo.save(obj);
	}
	
	
}
