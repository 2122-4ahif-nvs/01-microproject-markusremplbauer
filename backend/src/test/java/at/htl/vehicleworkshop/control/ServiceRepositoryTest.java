package at.htl.vehicleworkshop.control;

import at.htl.vehicleworkshop.entity.Employee;
import at.htl.vehicleworkshop.entity.Vehicle;
import at.htl.vehicleworkshop.entity.Person;
import at.htl.vehicleworkshop.entity.Service;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class ServiceRepositoryTest {
    @Inject
    PersonRepository personRepository;

    @Inject
    EmployeeRepository employeeRepository;

    @Inject
    VehicleRepository vehicleRepository;

    @Inject
    ServiceRepository serviceRepository;

    @Inject
    UserTransaction tx;

    @Test
    public void testPersist() throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {
        tx.begin();
        Person owner = new Person(
                "Max Mustermann",
                "max.mustermann@gmail.com",
                "1234567689",
                LocalDate.of(2000, 10, 10));

        personRepository.persist(owner);

        Vehicle vehicle = new Vehicle("1LNHM87A31Y667552", "S63 AMG", "Mercedes", "Coupe", owner);
        vehicleRepository.persist(vehicle);

        Employee emp = new Employee(
                "Max Mustermann",
                "max.mustermann@gmail.com",
                "1234567689",
                LocalDate.of(2000, 10, 10),
                1600.00,
                "Mechanik"
        );
        employeeRepository.persist(emp);

        Service service = new Service(vehicle, emp, 600.00, null, LocalDate.now().plusDays(3));
        serviceRepository.persist(service);
        tx.commit();

        Service persistedService = serviceRepository.findById(service.id);

        assertEquals(service, persistedService);
    }
}