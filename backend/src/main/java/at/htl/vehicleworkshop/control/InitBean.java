package at.htl.vehicleworkshop.control;

import at.htl.vehicleworkshop.entity.Customer;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@ApplicationScoped
public class InitBean {

    @Inject
    CustomerRepository customerRepository;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    void init(@Observes StartupEvent event) {
        Customer c = new Customer("Tim Lang", "tim.lang@gmail.com", "068898399194", LocalDate.parse("10.10.2002", formatter),0);
        customerRepository.save(c);
    }

}
