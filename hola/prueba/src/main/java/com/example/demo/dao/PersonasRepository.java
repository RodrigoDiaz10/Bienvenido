package com.example.demo.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import com.example.demo.modelos.Personas ;
public interface PersonasRepository extends CrudRepository<Personas, Long>  {
	@Query("select * from Personas")
	List<Personas> findHistoryById(@Param("id") Long id);
}
