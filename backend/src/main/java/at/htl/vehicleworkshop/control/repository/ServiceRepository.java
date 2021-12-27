package at.htl.vehicleworkshop.control.repository;

import at.htl.vehicleworkshop.entity.Service;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ServiceRepository implements PanacheRepository<Service> {
}
