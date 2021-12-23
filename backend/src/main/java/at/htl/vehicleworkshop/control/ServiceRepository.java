package at.htl.vehicleworkshop.control;

import at.htl.vehicleworkshop.entity.Service;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ServiceRepository implements PanacheRepository<Service> {
}
