package at.htl.vehicleworkshop.boundary;

import at.htl.vehicleworkshop.entity.User;
import javax.annotation.security.PermitAll;
import javax.transaction.Transactional;
import javax.validation.constraints.NotEmpty;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/api/users")
public class UserResource {

    @POST
    @Transactional
    @PermitAll
    public Response addUser(
            @NotEmpty  @QueryParam("username") String username,
            @NotEmpty @QueryParam("password") String password) {
        User.add(username, password, "user");
        return Response.ok().build();
    }
}