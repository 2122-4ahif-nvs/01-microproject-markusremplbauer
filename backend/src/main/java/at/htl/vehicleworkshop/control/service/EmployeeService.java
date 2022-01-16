package at.htl.vehicleworkshop.control.service;

import at.htl.vehicleworkshop.control.repository.EmployeeRepository;
import at.htl.vehicleworkshop.entity.Employee;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class EmployeeService {

    @Inject
    EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.listAll();
    }
}
