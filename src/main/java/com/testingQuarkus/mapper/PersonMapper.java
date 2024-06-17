package com.testingQuarkus.mapper;

import com.testingQuarkus.dto.PersonDTO;
import com.testingQuarkus.model.Person;

public class PersonMapper {

    //if you not want to use the static mapper method you need to use the @ApplicationScoped, in this case you can use the 
    //Dependency Injection in the service class
    
    public static PersonDTO toDTO(Person person) {
        return new PersonDTO(person.getId(), person.getName(), person.getAge());
    }

    public static Person toEntity(PersonDTO personDTO) {
        Person person = new Person();
        person.setId(personDTO.id());
        person.setName(personDTO.name());
        person.setAge(personDTO.age());
        return person;
    }

}
