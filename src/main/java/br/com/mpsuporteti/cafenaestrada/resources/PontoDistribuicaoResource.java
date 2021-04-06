package br.com.mpsuporteti.cafenaestrada.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.mpsuporteti.cafenaestrada.domain.PontoDistribuicao;
import br.com.mpsuporteti.cafenaestrada.services.PontoDistribuicaoService;

@RestController
@RequestMapping(value = "/pontos")
public class PontoDistribuicaoResource {

	@Autowired
	private PontoDistribuicaoService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody PontoDistribuicao obj, @PathVariable Integer id) {
	//	PontoDistribuicao obj = service.fromDTO(obj);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	
	
	
	
	
}
