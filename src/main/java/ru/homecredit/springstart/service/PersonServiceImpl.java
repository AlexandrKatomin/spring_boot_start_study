package ru.homecredit.springstart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.homecredit.springstart.dto.PersonDto;
import ru.homecredit.springstart.entity.Person;
import ru.homecredit.springstart.repository.PersonRepository;

/**
 * @author dima
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository repository;

    @Override
    public PersonDto get(Long id) {
        return map(repository.getOne(id));
    }

    @Override
    public void save(PersonDto dto) {
        repository.save(mapToEntity(dto));
    }

    @Override
    public PersonDto update(PersonDto dto) {
        return map(repository.merge(mapToEntity(dto)));
    }

    @Override
    public void delete(PersonDto dto) {
        repository.delete(mapToEntity(dto));
    }

    //todo refactor to Dozer
    public PersonDto map(Person person) {
        PersonDto dto = new PersonDto();
        dto.setName(person.getName());
        dto.setAge(person.getAge());
        dto.setPassport(person.getPassport());
        return dto;
    }

    public Person mapToEntity(PersonDto dto) {
        Person person = new Person();
        person.setName(dto.getName());
        person.setAge(dto.getAge());
        person.setPassport(dto.getPassport());
        return person;
    }
}
