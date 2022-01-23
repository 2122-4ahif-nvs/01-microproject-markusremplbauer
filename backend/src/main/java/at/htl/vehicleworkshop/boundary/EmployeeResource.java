package at.htl.vehicleworkshop.boundary;

import at.htl.vehicleworkshop.control.service.EmployeeService;
import at.htl.vehicleworkshop.entity.Employee;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/employee")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RolesAllowed({"emp", "admin"})
public class EmployeeResource {

    @Inject
    EmployeeService employeeService;

    @GET
    @Path("findAll")
    public Response findAllPersons() {
        return Response.ok(employeeService.findAll()).build();
    }

    @POST
    @Transactional
    @Path("addEmployee")
    public Response addEmployee(@Valid Employee employee) {
        employeeService.addEmployee(employee);
        return Response.ok(employee).build();
    }

    @GET
    @Path("find/{id}")
    public Response findEmployeeById(@PathParam("id") long employeeId) {
        Employee employee = employeeService.findById(employeeId);
        return (employee == null
                ? Response.status(404)
                : Response.ok(employee))
                .build();
    }


    @DELETE
    @Transactional
    @Path("remove/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeEmployee(@PathParam("id") long employeeId) {
        Employee employee = employeeService.removeEmployee(employeeId);
        return (employee == null
                ? Response.status(404)
                : Response.ok(employee))
                .build();
    }
}
