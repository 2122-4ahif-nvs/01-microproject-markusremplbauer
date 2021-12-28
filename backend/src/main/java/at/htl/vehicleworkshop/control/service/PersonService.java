package at.htl.vehicleworkshop.control.service;

import at.htl.vehicleworkshop.control.repository.PersonRepository;
import at.htl.vehicleworkshop.entity.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class PersonService {

    @Inject
    PersonRepository personRepository;

    public List<Person> findAll() {
        return personRepository.listAll();
    }

    public Person getById(Long id) {
        return personRepository.findById(id);
    }


    public void addPerson(Person person) {
        person.id = null;
        personRepository.persist(person);
    }

    public Person removePerson(long personId) {
        Person person = personRepository.findById(personId);
        personRepository.deleteById(personId);
        return person;
    }
}
