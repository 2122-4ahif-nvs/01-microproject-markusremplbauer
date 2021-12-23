package at.htl.vehicleworkshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "VW_Employee")
public class Employee extends Person {
    @Column(name = "E_SALARY")
    public Double salary;
    @Column(name = "E_JOB")
    public String job;

    public Employee() {
    }

    public Employee(String name, String email, String phoneNumber, LocalDate dob, Double salary, String job) {
        super(name, email, phoneNumber, dob);
        this.salary = salary;
        this.job = job;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary='" + salary + '\'' +
                ", job='" + job + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dob=" + dob +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(salary, employee.salary) && Objects.equals(job, employee.job);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), salary, job);
    }
}
