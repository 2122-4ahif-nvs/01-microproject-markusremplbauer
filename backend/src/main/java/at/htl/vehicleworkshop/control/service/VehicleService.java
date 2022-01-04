package at.htl.vehicleworkshop.control.service;

import at.htl.vehicleworkshop.control.repository.VehicleRepository;
import at.htl.vehicleworkshop.entity.Vehicle;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class VehicleService {
    @Inject
    VehicleRepository vehicleRepository;


    public List<Vehicle> findAll() {
        return vehicleRepository.listAll();
    }

    public Vehicle findById(Long id) {
        return vehicleRepository.findById(id);
    }

    public List<Vehicle> findByOwnerId(Long id) {
        return vehicleRepository.findByOwnerId(id);
    }

    public void addVehicle(Vehicle vehicle) {
        vehicle.id = null;
        vehicleRepository.persist(vehicle);
    }

    public Vehicle removeVehicle(long vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId);
        vehicleRepository.deleteById(vehicleId);
        return vehicle;
    }
}
