package at.htl.vehicleworkshop.boundary;

import at.htl.vehicleworkshop.control.service.VehicleService;
import at.htl.vehicleworkshop.entity.Vehicle;
import org.eclipse.microprofile.graphql.*;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/vehicle")
@GraphQLApi
@Produces(MediaType.APPLICATION_JSON)
public class VehicleResource {
    @Inject
    VehicleService vehicleService;

    @GET
    @Path("findAll")
    @Query("allVehicles")
    @Description("Find all Vehicles")
    public List<Vehicle> getAllVehicles() {
        return vehicleService.findAll();
    }

    @GET
    @Query("findVehicle")
    @Description("Find Vehicle by vehicleId")
    @Path("find/{id}")
    public Vehicle findVehicleById(@Name("vehicleId") @PathParam("id") Long vehicleId) {
        return vehicleService.getById(vehicleId);
    }

    @GET
    @Query("findVehiclesByOwner")
    @Description("Find Vehicles by ownerId")
    @Path("owner/{ownerId}")
    public List<Vehicle> findByOwnerId(@Name("ownerId") @PathParam("ownerId") Long ownerId) {
        return vehicleService.findByOwnerId(ownerId);
    }

    @POST
    @Transactional
    @Mutation("addVehicle")
    @Path("addVehicle")
    @Consumes(MediaType.APPLICATION_JSON)
    public Vehicle addVehicle(Vehicle vehicle) {
        vehicleService.persist(vehicle);
        return vehicle;
    }

    @DELETE
    @Transactional
    @Mutation("removeVehicle")
    @Path("remove/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Vehicle removeEmployee(@Name("vehicleId") @PathParam("id") long vehicleId) {
        Vehicle vehicle = vehicleService.removeVehicle(vehicleId);
        return vehicle;
    }
}
