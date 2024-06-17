package com.testingQuarkus.service;

import java.util.List;
import java.util.stream.Collectors;

import com.testingQuarkus.dto.PersonDTO;
import com.testingQuarkus.mapper.PersonMapper;
import com.testingQuarkus.model.Person;
import com.testingQuarkus.repository.PersonRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class PersonSerivce {

    @Inject
    PersonRepository repository;

    public List<PersonDTO> listAll() {
        return repository.listAll()
                            .stream()
                            .map(PersonMapper::toDTO)
                            .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) {
        return PersonMapper.toDTO(repository.findById(id));
    }

    @Transactional
    public void add(PersonDTO person) {
        repository.persist(PersonMapper.toEntity(person));
    }

    @Transactional
    public void update(Long id, PersonDTO person) {
        Person entity = repository.findById(id);
        if(entity == null) return;
        entity.setName(person.name());
        entity.setAge(person.age());
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
