package at.htl.vehicleworkshop.control;

import org.junit.jupiter.api.BeforeEach;

import javax.inject.Inject;
import javax.transaction.Transactional;

public abstract class RepositoryTest {
    @Inject
    EmployeeRepository employeeRepository;

    @Inject
    EmployeeSkillRepository employeeSkillRepository;

    @Inject
    PersonRepository personRepository;

    @Inject
    ServiceRepository serviceRepository;

    @Inject
    VehicleRepository vehicleRepository;

    @BeforeEach
    @Transactional
    public void init() {
        employeeSkillRepository.deleteAll();
        serviceRepository.deleteAll();
        vehicleRepository.deleteAll();
        employeeRepository.deleteAll();
        personRepository.deleteAll();
    }
}
