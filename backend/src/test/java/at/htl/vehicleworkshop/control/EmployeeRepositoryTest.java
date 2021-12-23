package at.htl.vehicleworkshop.control;

import static org.junit.jupiter.api.Assertions.*;

import at.htl.vehicleworkshop.entity.Employee;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.*;
import java.time.LocalDate;

@QuarkusTest
class EmployeeRepositoryTest extends RepositoryTest {

    @Test
    @TestTransaction
    public void testPersist() {
        Employee emp = new Employee(
                "Max Mustermann",
                "max.mustermann@gmail.com",
                "1234567689",
                LocalDate.of(2000, 10, 10),
                1600.00,
                "Mechanik"
        );
        employeeRepository.persist(emp);

        Employee persistedEmp = employeeRepository.findById(emp.id);

        assertEquals(emp, persistedEmp);
    }
}