package ru.homecredit.springstart.entity;

import lombok.Data;

/**
 * @author dima
 */
@Data
public class Person {
    public Long id;
    public String name;
    public Integer age;
    public String passport;
    public String phone;
    public Person manager;
}
