package ru.homecredit.springstart.dto;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author dima
 */
@Data
@Component
@Scope(value = "prototype")
public class PersonDto {
    String name;
    Integer age;
    String passport;

    public Optional<String> getNameO() {
        return Optional.ofNullable(name);
    }

    public Optional<Integer> getAgeO() {
        return Optional.ofNullable(age);
    }

    public Optional<String> getPasportO() {
        return Optional.ofNullable(passport);
    }
}
