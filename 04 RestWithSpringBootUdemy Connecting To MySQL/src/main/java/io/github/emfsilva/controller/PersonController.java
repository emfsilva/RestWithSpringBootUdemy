package io.github.emfsilva.controller;

import io.github.emfsilva.model.Person;
import io.github.emfsilva.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personService;

	@GetMapping(value = "/{id}")
	public Person findById(@PathVariable("id") Long id) {
		return personService.findById(id);
	}

	@GetMapping
	public List<Person> findAll() {
		return personService.findAll();
	}

	@PostMapping
	public Person create(@RequestBody Person person){
		return personService.create(person);
	}

	@PutMapping
	public Person update(@RequestBody Person person) {
		return personService.update(person);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		personService.delete(id);
		return ResponseEntity.ok().build();
	}

}
