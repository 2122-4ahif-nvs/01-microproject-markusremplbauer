package at.htl.vehicleworkshop.boundary;


import at.htl.vehicleworkshop.entity.Customer;
import at.htl.vehicleworkshop.control.CustomerRepository;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/customer")
public class CustomerResource {

    @Inject
    CustomerRepository customerRepository;

    @GET
    @Path("findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getEmployees() {
        return customerRepository.findAll();
    }
}