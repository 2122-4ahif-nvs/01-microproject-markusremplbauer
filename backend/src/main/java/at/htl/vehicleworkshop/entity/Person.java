package at.htl.vehicleworkshop.entity;

import at.htl.vehicleworkshop.control.validation.HasLegalAgeConstraint;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "VW_PERSON")
@Inheritance(strategy = InheritanceType.JOINED)
public class Person extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "P_ID")
    public Long id;

    @NotBlank(message = "Name should not be blank")
    @Column(name = "P_NAME")
    public String name;

    @NotBlank(message = "Email should not be blank")
    @Email
    @Column(name = "P_EMAIL")
    public String email;

    @Column(name = "P_PHONE_NUMBER")
    public String phoneNumber;

    @HasLegalAgeConstraint
    @NotNull(message = "DOB should not be null")
    @Column(name = "P_DOB")
    public LocalDate dob;

    public Person() {
    }

    public Person(String name, String email, String phoneNumber, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
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
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(name, person.name) && Objects.equals(email, person.email) && Objects.equals(phoneNumber, person.phoneNumber) && Objects.equals(dob, person.dob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, phoneNumber, dob);
    }
}
