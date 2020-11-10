package com.facec.estagio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.facec.estagio.entities.Nematoide;

public interface NematoideRepository extends JpaRepository<Nematoide, Long>{

	@Query("select f from Nematoide f where f.especie like :especie order by f.especie")
	List<Nematoide> queryByEspecie(@Param("especie") String especie);

	@Query("select f from Nematoide f where f.genero like :genero order by f.genero")
	List<Nematoide> queryByGenero(@Param("genero") String genero);	
	
}
