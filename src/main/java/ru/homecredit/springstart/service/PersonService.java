package ru.homecredit.springstart.service;

import ru.homecredit.springstart.dto.PersonDto;

/**
 * @author dima
 */
public interface PersonService {
    PersonDto get(Long id);

    void save(PersonDto dto);

    PersonDto update(PersonDto dto);

    void delete(PersonDto dto);
}
