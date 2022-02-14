package at.htl.vehicleworkshop.boundary.api

import at.htl.vehicleworkshop.control.service.ServiceService
import at.htl.vehicleworkshop.entity.Service
import javax.annotation.security.RolesAllowed
import javax.inject.Inject
import javax.transaction.Transactional
import javax.validation.Valid
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/service")
@RolesAllowed("user", "admin")
class ServiceApi {
    @Inject
    lateinit var serviceService: ServiceService

    @GET
    @Path("findAll")
    fun findAllServices(): List<Service> {
        return serviceService.findAll()
    }

    @POST
    @Transactional
    @Path("addService")
    @Consumes(MediaType.APPLICATION_JSON)
    fun addService(service: @Valid Service): Service {
        serviceService.addService(service)
        return service
    }

    @GET
    @Path("find/{id}")
    fun findServiceById(@PathParam("id") serviceId: Long): Service {
        return serviceService.findById(serviceId)
    }

    @DELETE
    @Transactional
    @Path("remove/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun removePerson(@PathParam("id") serviceId: Long): Service {
        return serviceService.removeService(serviceId)
    }
}