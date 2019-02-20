package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.PersonasRepository;
import com.example.demo.modelos.Personas;
import com.example.demo.Vo.PersonasVo;

@RestController
@RequestMapping("/user")

public class Rest {
	
	@Autowired
	PersonasRepository personasRepository; 
	
	@RequestMapping(value = "/persona/{id}", method = RequestMethod.GET)
	public PersonasVo getMailByHistoryId(@PathVariable Long id) {
		PersonasVo personasVo = new PersonasVo();
		List<Personas> personas = personasRepository.findHistoryById(id);
		personasVo.setPersonas(personas);
		return personasVo;
	
	
	}
}
