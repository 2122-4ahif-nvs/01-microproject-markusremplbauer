package at.htl.vehicleworkshop.boundary;

import at.htl.vehicleworkshop.control.service.EmployeeService;
import io.quarkus.security.identity.SecurityIdentity;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/employee")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeResource {

    @Inject
    EmployeeService employeeService;

    @Inject
    SecurityIdentity securityIdentity;

    @GET
    @Path("findAll")
    public Response findAllPersons() {
        if(!securityIdentity.hasRole("admin") && !securityIdentity.hasRole("emp")) {
            return Response.status(403).build();
        }
        return Response.ok(employeeService.findAll()).build();
    }
}
