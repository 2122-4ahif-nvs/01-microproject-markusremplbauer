package at.htl.vehicleworkshop.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@NamedQuery(
        name = "Customer.findAll",
        query = "select c from Customer c"
)
@Entity
@Table(name = "VW_CUSTOMER")
public class Customer extends Person implements Serializable {

    private Integer customerPoints;

    public Customer() {
    }

    public Customer(String name, String email, String phoneNumber, LocalDate dob, Integer customerPoints) {
        super(name, email, phoneNumber, dob);
        this.customerPoints = customerPoints;
    }

    public Integer getCustomerPoints() {
        return customerPoints;
    }

    public void setCustomerPoints(Integer customerPoints) {
        this.customerPoints = customerPoints;
    }
}
