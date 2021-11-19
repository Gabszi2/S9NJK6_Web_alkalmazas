package hu.uni.miskolc.iit.webalk.adatb.service;

import hu.uni.miskolc.iit.webalk.adatb.repository.PeopleRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;


import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PeopleServiceImpl implements PeopleService {
    private final PeopleRepository peopleRepository;

    public PeopleServiceImpl(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }


    @Override
    public Iterable<People> getAllPeople() {

        return StreamSupport.stream(peopleRepository.findAll().spliterator(), false)
                .map(People::new)
                .collect(Collectors.toList());
    }


    @Override
    public People create(People people) {
        return new People(peopleRepository.save(people.toEntity()));
    }

    @Override
    public void deleteById(Long id) {
        try {
            peopleRepository.deleteById(id);
        }catch (EmptyResultDataAccessException ex){
            throw new NoSuchEntityException(id);
        }
    }

    @Override
    public People getById(Long id) {
        Optional<hu.uni.miskolc.iit.webalk.adatb.repository.People> optionalPeople=peopleRepository.findById(id);
        if (optionalPeople.isEmpty()){
            throw  new NoSuchEntityException(id);
        }
        return new People(optionalPeople.get());
    }

    @Override
    public void save(People people) {
        Optional<hu.uni.miskolc.iit.webalk.adatb.repository.People> optionalPeople=peopleRepository.findById(people.getId());
        if (optionalPeople.isEmpty()){
            throw  new NoSuchEntityException(people.getId());
        }
        peopleRepository.save(people.toEntity());
    }

}
/*
	@Override
	public Iterable<People> gettAllPeople() {
		List<People> rv = new ArrayList<>();

		StreamSupport.stream(peopleRepository.findAll().spliterator(), false);
		for(hu.me.iit.webalk.db.repository.People people : peopleRepository.findAll()) {
			rv.add(new People(people));
		}

		return rv;
	}*/