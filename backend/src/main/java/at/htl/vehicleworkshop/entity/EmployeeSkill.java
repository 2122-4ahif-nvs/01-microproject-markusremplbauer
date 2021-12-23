package at.htl.vehicleworkshop.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "VW_EMPLOYEE_SKILL")
public class EmployeeSkill extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ES_ID")
    public Long id;
    @Column(name = "ES_SKILL")
    public String skill;
    @OneToOne
    @JoinColumn(name = "ES_E_ID")
    public Employee employee;

    @Override
    public String toString() {
        return "EmployeeSkill{" +
                "id=" + id +
                ", skill='" + skill + '\'' +
                ", employee=" + employee +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeSkill that = (EmployeeSkill) o;
        return Objects.equals(id, that.id) && Objects.equals(skill, that.skill) && Objects.equals(employee, that.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, skill, employee);
    }
}
