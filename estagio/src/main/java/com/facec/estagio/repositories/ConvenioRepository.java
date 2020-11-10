package com.facec.estagio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.facec.estagio.entities.Convenio;

public interface ConvenioRepository extends JpaRepository<Convenio, Long> {
	
	@Query("select c from Convenio c where c.nome like :nome order by c.nome")
	List<Convenio> queryByConvenio(@Param("nome") String nome);

	@Query("select c from Convenio c where c.cnpj like :cnpj order by c.cnpj")
	List<Convenio> queryByCnpj(@Param("cnpj") String cnpj);	
	
}
