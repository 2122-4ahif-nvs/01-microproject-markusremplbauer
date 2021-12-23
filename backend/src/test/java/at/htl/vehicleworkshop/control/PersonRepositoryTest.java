package at.htl.vehicleworkshop.control;

import at.htl.vehicleworkshop.entity.Employee;
import at.htl.vehicleworkshop.entity.Person;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.*;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class PersonRepositoryTest {
    @Inject
    PersonRepository personRepository;

    @Inject
    UserTransaction tx;

    @Test
    public void testPersist() throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {
        tx.begin();
        Person person = new Person(
                "Max Mustermann",
                "max.mustermann@gmail.com",
                "1234567689",
                LocalDate.of(2000, 10, 10));

        personRepository.persist(person);
        tx.commit();

        Person persistedPerson = personRepository.findById(person.id);

        assertEquals(person, persistedPerson);
    }

}