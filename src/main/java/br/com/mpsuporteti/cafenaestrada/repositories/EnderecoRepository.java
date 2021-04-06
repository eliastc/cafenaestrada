package br.com.mpsuporteti.cafenaestrada.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mpsuporteti.cafenaestrada.domain.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer>  {

}
