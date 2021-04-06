package br.com.mpsuporteti.cafenaestrada.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.mpsuporteti.cafenaestrada.domain.Veiculo;
import br.com.mpsuporteti.cafenaestrada.services.VeiculoService;

@RestController
@RequestMapping(value = "/veiculos")
public class VeiculoResource {

	@Autowired
	private VeiculoService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody Veiculo obj, @PathVariable Integer id) {
	//	Veiculo obj = service.fromDTO(obj);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	
	
	
	
	
}
