package at.htl.vehicleworkshop.control;

import at.htl.vehicleworkshop.entity.Person;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {
}
