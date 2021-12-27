package at.htl.vehicleworkshop.control.repository;

import at.htl.vehicleworkshop.entity.EmployeeSkill;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EmployeeSkillRepository implements PanacheRepository<EmployeeSkill> {
}
