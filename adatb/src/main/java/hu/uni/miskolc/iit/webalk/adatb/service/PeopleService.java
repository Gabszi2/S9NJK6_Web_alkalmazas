package hu.uni.miskolc.iit.webalk.adatb.service;

public interface PeopleService {
    Iterable<People> getAllPeople();
    People create(People people);
    void deleteById(Long id);

    People getById(Long id);

    void save(People toPeople);
}
