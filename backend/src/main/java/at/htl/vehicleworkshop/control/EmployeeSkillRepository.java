package at.htl.vehicleworkshop.control;

import at.htl.vehicleworkshop.entity.EmployeeSkill;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EmployeeSkillRepository implements PanacheRepository<EmployeeSkill> {
}
