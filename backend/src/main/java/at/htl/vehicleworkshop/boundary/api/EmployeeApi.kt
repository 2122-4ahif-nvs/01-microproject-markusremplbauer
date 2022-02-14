package at.htl.vehicleworkshop.boundary.api

import at.htl.vehicleworkshop.control.service.EmployeeService
import at.htl.vehicleworkshop.entity.Employee
import javax.annotation.security.RolesAllowed
import javax.inject.Inject
import javax.transaction.Transactional
import javax.validation.Valid
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/employee")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RolesAllowed("emp", "admin")
class EmployeeApi {
    @Inject
    lateinit var employeeService: EmployeeService

    @GET
    @Path("findAll")
    fun findAllPersons(): Response {
        return Response.ok(employeeService.findAll()).build()
    }

    @POST
    @Transactional
    @Path("addEmployee")
    fun addEmployee(employee: @Valid Employee?): Response {
        employeeService.addEmployee(employee)
        return Response.ok(employee).build()
    }

    @GET
    @Path("find/{id}")
    fun findEmployeeById(@PathParam("id") employeeId: Long): Response {
        val employee = employeeService.findById(employeeId)
        return (if (employee == null) Response.status(404) else Response.ok(employee))
                .build()
    }


    @DELETE
    @Transactional
    @Path("remove/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun removeEmployee(@PathParam("id") employeeId: Long): Response {
        val employee = employeeService.removeEmployee(employeeId)
        return (if (employee == null) Response.status(404) else Response.ok(employee))
                .build()
    }
}