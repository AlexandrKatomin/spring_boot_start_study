package ru.homecredit.springstart.repository;

import org.springframework.stereotype.Repository;
import ru.homecredit.springstart.entity.Person;

import java.util.HashMap;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * @author dima
 */
@Repository
public class PersonRepository {
    HashMap<Long, Person> persons = new HashMap<>();
    Long maxId = persons.keySet().stream().max(Long::compareTo).get();

    public Person getOne(Long id) {
        return persons.get(id);
    }

    public Person save(Person person) {
        person.setId(maxId + 1);
        return persons.put(maxId + 1, person);
    }

    public Person merge(Person person) throws Exception {

        Person result = persons.values().stream().filter(getPersonPredicate(person).
                or(equalsByName(person))).findFirst().
                ifPresent(p->{
                    Optional<Person> p1 = Optional.of(p);
                    p.setAge(person.getAge() == 0 ? result.getAge() : person.getAge());
        result.setName(person.getName() == null ? result.getName() : person.getName());
        result.setPassport(person.getPassport() == null ? result.getPassport());}).orElseThrow(() -> new Exception("Object not found"));


        result.setAge(person->{24});


    }

}

    private Predicate<Person> getPersonPredicate(Person person) {
        return p -> p.getPassport().equals(person.getPassport());
    }

    private Predicate<Person> equalsByName(Person person) {
        return p -> person.getName().equals(p.getName());
    }

    public void delete(Person person) {

    }
}
