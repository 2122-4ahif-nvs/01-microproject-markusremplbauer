package at.htl.vehicleworkshop.control;

import at.htl.vehicleworkshop.control.repository.EmployeeRepository;
import at.htl.vehicleworkshop.control.repository.PersonRepository;
import at.htl.vehicleworkshop.control.repository.ServiceRepository;
import at.htl.vehicleworkshop.control.repository.VehicleRepository;
import at.htl.vehicleworkshop.entity.*;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.transaction.*;
import java.time.LocalDate;

@ApplicationScoped
public class InitBean {

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

    void init(@Observes StartupEvent event) throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {
        tx.begin();
        Person owner = new Person(
                "Max Mustermann",
                "max.mustermann@gmail.com",
                "1234567689",
                LocalDate.of(2000, 10, 10));

        personRepository.persist(owner);

        Vehicle vehicle1 = new Vehicle("1LNHM87A31Y667552", "S63 AMG", "Mercedes", "COUPE", owner);
        Vehicle vehicle2 = new Vehicle("1FTZX1722XKA76091", "C63 AMG", "Mercedes", "COUPE", owner);
        Vehicle vehicle3 = new Vehicle("JH4KA7670MC006807", "G Klass", "Mercedes", "SUV", owner);

        vehicleRepository.persist(vehicle1);
        vehicleRepository.persist(vehicle2);
        vehicleRepository.persist(vehicle3);

        Employee emp = new Employee(
                "Max Mustermann",
                "max.mustermann@gmail.com",
                "1234567689",
                LocalDate.of(2000, 10, 10),
                1600.00,
                "Mechanik"
        );
        employeeRepository.persist(emp);

        Service service1 = new Service(vehicle1, emp, 600.00, null, LocalDate.now().plusDays(3));
        Service service2 = new Service(vehicle2, emp, 400.00, null, LocalDate.now().plusDays(3));
        Service service3 = new Service(vehicle1, emp, 500.00, null, LocalDate.now().plusDays(3));
        serviceRepository.persist(service1);
        serviceRepository.persist(service2);
        serviceRepository.persist(service3);

        User.add("admin", "admin", "admin");
        User.add("user", "user", "user");
        tx.commit();
    }

}