package at.htl.vehicleworkshop.control;

import at.htl.vehicleworkshop.entity.Person;
import at.htl.vehicleworkshop.entity.Vehicle;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
class VehicleRepositoryTest extends RepositoryTest{

    @Test
    @TestTransaction
    public void testPersist() {
        Person owner = new Person(
                "Max Mustermann",
                "max.mustermann@gmail.com",
                "1234567689",
                LocalDate.of(2000, 10, 10));

        personRepository.persist(owner);

        Vehicle vehicle = new Vehicle("1LNHM87A31Y667552", "S63 AMG", "Mercedes", "COUPE", owner);
        vehicleRepository.persist(vehicle);

        Vehicle persistedVehicle = vehicleRepository.findById(vehicle.id);

        assertEquals(vehicle, persistedVehicle);
    }
}