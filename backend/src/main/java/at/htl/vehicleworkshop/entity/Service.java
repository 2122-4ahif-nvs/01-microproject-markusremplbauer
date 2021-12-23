package at.htl.vehicleworkshop.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "VW_SERVICE")
public class Service extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "S_ID")
    public Long id;

    @ManyToOne
    @JoinColumn(name = "S_V_ID")
    public Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "S_P_Id")
    public Employee employee;

    @Column(name = "S_PRICE")
    public Double price;

    @Column(name = "S_DATE_OF_COMPLETION")
    public LocalDate dateOfCompletion;

    @Column(name = "S_PLANNED_DATE_OF_COMPLETION")
    public LocalDate plannedDateOfCompletion;

    public Service() {
    }

    public Service(
            Vehicle vehicle, Employee employee, Double price, LocalDate dateOfCompletion, LocalDate plannedDateOfCompletion
    ) {
        this.vehicle = vehicle;
        this.employee = employee;
        this.price = price;
        this.dateOfCompletion = dateOfCompletion;
        this.plannedDateOfCompletion = plannedDateOfCompletion;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", vehicle=" + vehicle +
                ", employee=" + employee +
                ", price=" + price +
                ", dateOfCompletion=" + dateOfCompletion +
                ", plannedDateOfCompletion=" + plannedDateOfCompletion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return Objects.equals(id, service.id) && Objects.equals(vehicle, service.vehicle) && Objects.equals(employee, service.employee) && Objects.equals(price, service.price) && Objects.equals(dateOfCompletion, service.dateOfCompletion) && Objects.equals(plannedDateOfCompletion, service.plannedDateOfCompletion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vehicle, employee, price, dateOfCompletion, plannedDateOfCompletion);
    }
}
