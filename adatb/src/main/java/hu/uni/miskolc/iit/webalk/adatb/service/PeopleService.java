package hu.uni.miskolc.iit.webalk.adatb.service;

public interface PeopleService {
    Iterable<People> getAllPeople();
    People create(People people);
    boolean deleteById(Long id);
}
