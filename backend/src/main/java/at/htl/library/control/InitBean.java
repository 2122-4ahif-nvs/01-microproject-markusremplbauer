package at.htl.library.control;

import at.htl.library.entity.Customer;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.time.LocalDate;

@ApplicationScoped
public class InitBean {

    @Inject
    CustomerRepository customerRepository;

    void init(@Observes StartupEvent event) {
        Customer c = new Customer("Tim Lang", "tim.lang@gmail.com", "068898399194", LocalDate.parse("10.10.2002"));
        customerRepository.save(c);
    }

}
