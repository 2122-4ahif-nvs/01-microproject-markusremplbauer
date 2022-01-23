package at.htl.vehicleworkshop.control.service;

import at.htl.vehicleworkshop.control.repository.EmployeeRepository;
import at.htl.vehicleworkshop.entity.Employee;
import at.htl.vehicleworkshop.entity.Person;

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

    public void addEmployee(Employee employee) {
        employeeRepository.persist(employee);
    }

    public Employee removeEmployee(long employeeId) {
        Employee employee = employeeRepository.findById(employeeId);
        employeeRepository.deleteById(employeeId);
        return employee;
    }

    public Employee findById(long employeeId) {
        return employeeRepository.findById(employeeId);
    }
}
