package at.htl.vehicleworkshop.boundary.api

import at.htl.vehicleworkshop.entity.Person
import at.htl.vehicleworkshop.entity.User
import javax.annotation.security.PermitAll
import javax.annotation.security.RolesAllowed
import javax.transaction.Transactional
import javax.validation.constraints.NotEmpty
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.QueryParam
import javax.ws.rs.core.Response

@Path("/user")
class UserApi {

    @POST
    @Transactional
    @PermitAll
    fun addUser(
            @QueryParam("username") username: @NotEmpty String,
            @QueryParam("password") password: @NotEmpty String): Response {
        User.add(username, password, "user")
        return Response.ok().build()
    }

    @POST
    @Transactional
    @PermitAll
    fun addEmployee(
            @QueryParam("username") username: @NotEmpty String,
            @QueryParam("password") password: @NotEmpty String): Response {
        User.add(username, password, "emp")
        return Response.ok().build()
    }


    @GET
    @RolesAllowed("admin")
    @Path("findAll")
    fun findAllUsers(): List<User> {
        return User.listAll()
    }
}