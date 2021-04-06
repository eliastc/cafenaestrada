package br.com.mpsuporteti.cafenaestrada.repositories;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.mpsuporteti.cafenaestrada.domain.Categoria;
import br.com.mpsuporteti.cafenaestrada.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>  {

	@Transactional(readOnly = true)
	//@Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat WHERE obj.nome LIKE %:nome% AND cat IN :categorias")
	Page<Produto> findDistinctByNomeIgnoreCaseContainingAndCategoriasIn(String nome, List<Categoria> categorias, Pageable pageRequest);
}
