package hu.uni.miskolc.iit.webalk.adatb.controller;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import hu.uni.miskolc.iit.webalk.adatb.service.People;

public class PeopleDto {
    private Long id;
    @NotEmpty
    private String name;
    @Min(18)
    private int age;

    public PeopleDto() {

    }
    public PeopleDto(People people) {
        this.id = people.getId();
        this.name = people.getName();
        this.age = people.getAge();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
