package at.htl.vehicleworkshop.boundary;

import at.htl.vehicleworkshop.control.VehicleRepository;
import at.htl.vehicleworkshop.control.VehicleService;
import at.htl.vehicleworkshop.entity.Vehicle;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/vehicle")
@Produces(MediaType.APPLICATION_JSON)
public class VehicleResource {
    @Inject
    VehicleService vehicleService;

    @GET
    @Path("getAll")
    public Response getAll() {
        return Response.ok(vehicleService.getAll()).build();
    }

    @GET()
    @Path("{id}")
    public Response getById(@PathParam("id") Long id) {
        return Response.ok(vehicleService.getById(id)).build();
    }

    @GET
    @Path("owner/{ownerId}")
    public Response getByOwnerId(@PathParam("ownerId") Long id){
        return Response.ok(vehicleService.findByOwnerId(id)).build();
    }
}
