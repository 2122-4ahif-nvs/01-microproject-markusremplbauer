package at.htl.vehicleworkshop.control;

import static org.junit.jupiter.api.Assertions.*;

import at.htl.vehicleworkshop.entity.Employee;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.*;
import java.time.LocalDate;

@QuarkusTest
class EmployeeRepositoryTest {
    @Inject
    EmployeeRepository employeeRepository;

    @Inject
    UserTransaction tx;

    @Test
    public void testPersist() throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {
        tx.begin();
        Employee emp = new Employee(
                "Max Mustermann",
                "max.mustermann@gmail.com",
                "1234567689",
                LocalDate.of(2000, 10, 10),
                1600.00,
                "Mechanik"
        );
        employeeRepository.persist(emp);
        tx.commit();

        Employee persistedEmp = employeeRepository.findById(emp.id);

        assertEquals(emp, persistedEmp);
    }
}