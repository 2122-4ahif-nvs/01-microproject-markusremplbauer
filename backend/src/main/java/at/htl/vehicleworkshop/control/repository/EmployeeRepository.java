package at.htl.vehicleworkshop.control.repository;

import at.htl.vehicleworkshop.entity.Employee;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EmployeeRepository implements PanacheRepository<Employee> {
}
