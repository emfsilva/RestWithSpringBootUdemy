package io.github.emfsilva.controller;

import io.github.emfsilva.data.vo.v1.PersonVO;
import io.github.emfsilva.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person/v1")
public class PersonController {

	@Autowired
	private PersonService personService;

	@GetMapping(value = "/{id}", produces = {"application/json", "application/xml"})
	public PersonVO findById(@PathVariable("id") Long id) {
		return personService.findById(id);
	}

	@GetMapping(produces = {"application/json", "application/xml"})
	public List<PersonVO> findAll() {
		return personService.findAll();
	}

	@PostMapping(produces = {"applicatiion/json", "application/xml"},
			consumes = {"application/json", "application/xml"})
	public PersonVO create(@RequestBody PersonVO person){
		return personService.create(person);
	}

	@PutMapping(produces = {"applicatiion/json", "application/xml"},
				consumes = {"application/json", "application/xml"})
	public PersonVO update(@RequestBody PersonVO person) {
		return personService.update(person);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		personService.delete(id);
		return ResponseEntity.ok().build();
	}
}
