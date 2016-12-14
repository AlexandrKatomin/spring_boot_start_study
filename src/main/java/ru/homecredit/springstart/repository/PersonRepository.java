package ru.homecredit.springstart.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import ru.homecredit.springstart.entity.Person;

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.Optional.ofNullable;

/**
 * @author dima
 */
@Repository
@Cacheable
public class PersonRepository {
    HashMap<Long, Person> persons = new HashMap<>();
    Long maxId = persons.keySet().stream().max(Long::compareTo).orElseGet(() -> 0L);

    @Cacheable
    public Person getOne(Long id) {
        return persons.get(id);
    }

    public Person save(Person person) {
        person.setId(maxId + 1);
        return persons.put(maxId + 1, person);
    }

    public Person merge(Person person) throws Exception {
//        translate(person);

        return persons.values().stream()
                .filter(getPersonByPasport(person).or(getPersonByName(person)))
                .findFirst()
                .map(p -> {
                    BiConsumer<Function<Person, Integer>, BiConsumer<Person, Integer>> initInteger = (getter, setter) -> setIfNotPresent(getter, setter, person, p);
                    BiConsumer<Function<Person, String>, BiConsumer<Person, String>> initString = (getter, setter) -> setIfNotPresent(getter, setter, person, p);

                    initInteger.accept(Person::getAge, Person::setAge);
                    initString.accept(Person::getName, Person::setName);

                    setIfNotPresent(person.getPassport(), p.getPassport());
                    setIfNotPresent(person.getPhone(), p.getPhone());
                    save(p);
                    return p;
                })
                .orElseThrow(NoSuchElementException::new);
    }

//    private void translate(Person person) {
//        BiConsumer handler = (getter, setter) -> setIfNotPresent(getter, setter, person, p2);
//    }

    private <U> U orElse(U t, U t1) {
        return ofNullable(t).orElse(t1);
    }

    private <T extends Person, U> void setIfNotPresent
            (Function<T, ? extends U> getter,
             BiConsumer<T, ? super U> setter,
             T t, T t1) {

        setter.accept(t1, (getter.apply(t) == null) ? getter.apply(t1) : getter.apply(t));
    }

    private <T> T setIfNotPresent(T t, T t1) {
        return t1 = ofNullable(t).orElse(t1);
    }

    private Predicate<Person> getPersonByPasport(Person person) {
        return p -> p.getPassport().equals(person.getPassport());
    }

    private Predicate<Person> getPersonByName(Person person) {
        return p -> person.getName().equals(p.getName());
    }

    public void delete(Person person) {
        persons.values().stream()
                .filter(getPersonByPasport(person).or(getPersonByName(person)))
                .findFirst()
                .map(p -> p.getManager())
                .map(p -> p.getManager())
                .map(p -> p.getName())
                .ifPresent(p -> persons.remove(p));
    }
}
