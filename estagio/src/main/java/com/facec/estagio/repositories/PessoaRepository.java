package com.facec.estagio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.facec.estagio.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

	@Query("select p from Pessoa p where p.nome like :nome order by p.nome")
	List<Pessoa> queryByNome(@Param("nome") String nome);

	@Query("select p from Pessoa p where p.municipio like :municipio order by p.municipio")
	List<Pessoa> queryByCidade(@Param("municipio") String municipio);	
	
}
