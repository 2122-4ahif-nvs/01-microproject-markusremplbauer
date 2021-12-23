package at.htl.vehicleworkshop.control;

import at.htl.vehicleworkshop.entity.Employee;
import at.htl.vehicleworkshop.entity.EmployeeSkill;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.*;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class EmployeeSkillRepositoryTest {
    @Inject
    EmployeeSkillRepository employeeSkillRepository;
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

        EmployeeSkill employeeSkill = new EmployeeSkill(emp, "BMW Service");
        employeeSkillRepository.persist(employeeSkill);

        tx.commit();

        Employee persistedEmp = employeeRepository.findById(emp.id);
        EmployeeSkill persistedEmployeeSkill = employeeSkillRepository.findById(employeeSkill.id);

        assertEquals(employeeSkill, persistedEmployeeSkill);
    }
}