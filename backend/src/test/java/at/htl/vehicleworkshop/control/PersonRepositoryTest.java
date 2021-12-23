package at.htl.vehicleworkshop.control;

import at.htl.vehicleworkshop.entity.Person;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class PersonRepositoryTest extends RepositoryTest {

    @Test
    @TestTransaction
    public void testPersist() {
        Person person = new Person(
                "Max Mustermann",
                "max.mustermann@gmail.com",
                "1234567689",
                LocalDate.of(2000, 10, 10));

        personRepository.persist(person);

        Person persistedPerson = personRepository.findById(person.id);

        assertEquals(person, persistedPerson);
    }

}