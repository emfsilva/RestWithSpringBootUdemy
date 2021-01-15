package io.github.emfsilva.service;

import io.github.emfsilva.converter.DozerConverter;
import io.github.emfsilva.data.vo.v1.PersonVO;
import io.github.emfsilva.exception.ResourceNotFoundException;
import io.github.emfsilva.data.model.Person;
import io.github.emfsilva.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public PersonVO create(PersonVO person) {
        var entity = DozerConverter.parseObject(person, Person.class);
        var vo = DozerConverter.parseObject(personRepository.save(entity), PersonVO.class);
        return vo;
    }

    public PersonVO update(PersonVO person) {
        var entity = personRepository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        var vo = DozerConverter.parseObject(personRepository.save(entity), PersonVO.class);
        return vo;
    }

    public List<PersonVO> findAll() {
        return DozerConverter.parseListObjects(personRepository.findAll(), PersonVO.class);
    }

    public PersonVO findById(Long id) {
        var entity =  personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found this ID"));
        return DozerConverter.parseObject(entity, PersonVO.class);
    }

    public void delete(Long id) {
        Person entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found this ID"));
        personRepository.delete(entity);
    }
}
