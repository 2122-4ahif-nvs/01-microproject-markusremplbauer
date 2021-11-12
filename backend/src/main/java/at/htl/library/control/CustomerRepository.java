package at.htl.library.control;

import at.htl.library.entity.Customer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class CustomerRepository {

    @Inject
    EntityManager em;

    @Transactional
    public Customer save(Customer customer) {
        return em.merge(customer);
    }

    public List<Customer> findAll() {
        return em.createNamedQuery("Customer.findAll",Customer.class).getResultList();
    }


}
