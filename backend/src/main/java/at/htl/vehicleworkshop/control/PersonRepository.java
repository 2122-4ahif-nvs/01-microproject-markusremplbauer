package at.htl.vehicleworkshop.control;

import at.htl.vehicleworkshop.entity.Customer;
import at.htl.vehicleworkshop.entity.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class PersonRepository {

    @Inject
    EntityManager em;

    @Transactional
    public Person save(Person person) {
        return em.merge(person);
    }

    public List<Person> findAll() {
        return em.createNamedQuery("Person.findAll",Person.class).getResultList();
    }

}
