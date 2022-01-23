package at.htl.vehicleworkshop.control.service;

import at.htl.vehicleworkshop.control.repository.ServiceRepository;
import at.htl.vehicleworkshop.entity.Service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class ServiceService {
    @Inject
    ServiceRepository serviceRepository;

    public List<Service> findAll() {
        return serviceRepository.listAll();
    }

    public Service findById(Long id) {
        return serviceRepository.findById(id);
    }


    public void addService(Service service) {
        service.id = null;
        serviceRepository.persist(service);
    }

    public Service removeService(long serviceId) {
        Service service = serviceRepository.findById(serviceId);
        serviceRepository.deleteById(serviceId);
        return service;
    }
}
