package br.com.mpsuporteti.cafenaestrada.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mpsuporteti.cafenaestrada.domain.PontoDistribuicao;
import br.com.mpsuporteti.cafenaestrada.repositories.PontoDistribuicaoRepository;

@Service
public class PontoDistribuicaoService {
	
	@Autowired
	private PontoDistribuicaoRepository repo;
	
	public PontoDistribuicao update(PontoDistribuicao obj) {
		//PontoDistribuicao newObj = find(obj.getId());
	//	updateData(newObj, obj);
		return repo.save(obj);
	}
	
	
}
