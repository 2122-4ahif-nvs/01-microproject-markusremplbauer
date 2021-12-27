package at.htl.vehicleworkshop.control.repository;

import at.htl.vehicleworkshop.entity.Vehicle;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class VehicleRepository implements PanacheRepository<Vehicle> {
    public List<Vehicle> findByOwnerId(Long id) {
        return list("owner.id", id);
    }
}
