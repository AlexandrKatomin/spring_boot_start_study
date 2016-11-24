package ru.homecredit.springstart.dto;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

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
}
