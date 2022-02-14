package at.htl.vehicleworkshop.boundary;

import at.htl.vehicleworkshop.entity.User;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.transaction.Transactional;
import javax.validation.constraints.NotEmpty;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v1/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @POST
    @Transactional
    @PermitAll
    public Response addUser(
            @NotEmpty @QueryParam("username") String username,
            @NotEmpty @QueryParam("password") String password) {
        User.add(username, password, "user");
        return Response.ok().build();
    }

    @POST
    @Transactional
    @PermitAll
    public Response addEmployee(
            @NotEmpty @QueryParam("username") String username,
            @NotEmpty @QueryParam("password") String password) {
        User.add(username, password, "emp");
        return Response.ok().build();
    }
}
