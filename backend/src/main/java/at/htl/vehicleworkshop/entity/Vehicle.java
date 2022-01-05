package at.htl.vehicleworkshop.entity;

import javax.persistence.*;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Objects;

@Entity(name = "VW_VEHICLE")
public class Vehicle extends PanacheEntityBase{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "V_ID")
    public Long id;

    @Column(name = "V_VIN")
    public String vin;

    @Column(name = "V_MODEL")
    public String model;

    @Column(name = "V_MANUFACTURER")
    public String manufacturer;

    @Column(name = "V_TYPE")
    public String type;

    @ManyToOne
    @JoinColumn(name = "V_P_ID")
    @OnDelete(action = OnDeleteAction.CASCADE)
    public Person owner;

    public Vehicle() {
    }

    public Vehicle(String vin, String model, String manufacturer, String type, Person owner) {
        this.vin = vin;
        this.model = model;
        this.manufacturer = manufacturer;
        this.type = type;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", vin='" + vin + '\'' +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", type='" + type + '\'' +
                ", owner=" + owner +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(id, vehicle.id) && Objects.equals(vin, vehicle.vin) && Objects.equals(model, vehicle.model) && Objects.equals(manufacturer, vehicle.manufacturer) && Objects.equals(type, vehicle.type) && Objects.equals(owner, vehicle.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vin, model, manufacturer, type, owner);
    }
}
