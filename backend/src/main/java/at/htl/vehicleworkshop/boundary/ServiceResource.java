package at.htl.vehicleworkshop.boundary;

import at.htl.vehicleworkshop.control.service.ServiceService;
import at.htl.vehicleworkshop.entity.Service;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("v1/service")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RolesAllowed({"user", "admin"})
public class ServiceResource {
    @Inject
    ServiceService serviceService;
    @GET
    @Path("findAll")
    public List<Service> findAllServices() {
        return serviceService.findAll();
    }

    @POST
    @Transactional
    @Path("addService")
    @Consumes(MediaType.APPLICATION_JSON)
    public Service addService(@Valid Service service) {
        serviceService.addService(service);
        return service;
    }

    @GET
    @Path("find/{id}")
    public Service findServiceById(@PathParam("id") Long serviceId) {
        return serviceService.findById(serviceId);
    }

    @DELETE
    @Transactional
    @Path("remove/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Service removePerson(@PathParam("id") long serviceId) {
        return serviceService.removeService(serviceId);
    }
}
