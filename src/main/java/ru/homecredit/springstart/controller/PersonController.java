package ru.homecredit.springstart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.homecredit.springstart.dto.PersonDto;
import ru.homecredit.springstart.service.PersonService;

/**
 * @author dima
 */
@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    @Qualifier(value = "personServiceImpl")
    PersonService service;

    @GetMapping
    public PersonDto read(Long id) {
        return service.get(id);
    }

    @PostMapping
    public void save(@RequestBody PersonDto dto) {
        service.save(dto);
    }

    @PutMapping
    public PersonDto update(@RequestBody PersonDto dto) {
        return service.update(dto);
    }

    @DeleteMapping
    public PersonDto delete(@RequestBody PersonDto dto) {
        return service.delete(dto);
    }
}
