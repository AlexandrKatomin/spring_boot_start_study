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

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

/**
 * @author dima
 */
@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    @Qualifier(value = "personServiceImpl")
    PersonService service;
    List<PersonService> personServiceList;

    @PostConstruct
    public void executeService(Boolean isPlan) {
//        personServiceList.stream().filter(r.isplan == isPlan).findFirst(r -> r.save());
        Set<PersonService> r = personServiceList.stream().filter(r.isplan == isPlan).collect(toSet());
    }

    @GetMapping
    public PersonDto read(Long id) {
        return service.get(id);
    }

    @PostMapping
    public void save(@RequestBody PersonDto dto) {
        service.save(dto);
    }

    @PutMapping
    public PersonDto update(@RequestBody PersonDto dto) throws Exception {
        return service.update(dto);
    }

    @DeleteMapping
    public void delete(@RequestBody PersonDto dto) {
        service.delete(dto);
    }
}
