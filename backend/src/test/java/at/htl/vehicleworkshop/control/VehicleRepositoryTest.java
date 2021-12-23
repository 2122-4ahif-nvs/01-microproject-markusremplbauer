package at.htl.vehicleworkshop.control;

import at.htl.vehicleworkshop.entity.Person;
import at.htl.vehicleworkshop.entity.Vehicle;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.*;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class VehicleRepositoryTest {
    @Inject
    PersonRepository personRepository;

    @Inject
    VehicleRepository vehicleRepository;

    @Inject
    UserTransaction tx;

    @Test
    public void testPersist() throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {
        tx.begin();
        Person owner = new Person(
                "Max Mustermann",
                "max.mustermann@gmail.com",
                "1234567689",
                LocalDate.of(2000, 10, 10));

        personRepository.persist(owner);

        Vehicle vehicle = new Vehicle("1LNHM87A31Y667552", "S63 AMG", "Mercedes", "COUPE", owner);
        vehicleRepository.persist(vehicle);
        tx.commit();

        Vehicle persistedVehicle = vehicleRepository.findById(vehicle.id);

        assertEquals(vehicle, persistedVehicle);
    }
}