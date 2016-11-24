package ru.homecredit.springstart.entity;

import lombok.Data;

/**
 * @author dima
 */
@Data
public class Person {
    Long id;
    String name;
    Integer age;
    String passport;
    String phone;
}
