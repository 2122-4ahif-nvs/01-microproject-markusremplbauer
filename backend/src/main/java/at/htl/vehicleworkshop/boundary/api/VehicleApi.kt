package at.htl.vehicleworkshop.boundary.api

import at.htl.vehicleworkshop.boundary.VehicleResource
import at.htl.vehicleworkshop.control.service.VehicleService
import at.htl.vehicleworkshop.entity.Vehicle
import org.eclipse.microprofile.graphql.*
import javax.annotation.security.RolesAllowed
import javax.inject.Inject
import javax.transaction.Transactional
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("vehicle")
@GraphQLApi
@Produces(MediaType.APPLICATION_JSON)
@RolesAllowed("user", "admin")
class VehicleApi {

    @Inject
    lateinit var vehicleService: VehicleService;

    @GET
    @Path("findAll")
    @Query("allVehicles")
    @Description("Find all Vehicles")
    fun findAllVehicles(): List<Vehicle> {
        return vehicleService.findAll()
    }

    @GET
    @Path("find/{id}")
    @Query("findVehicle")
    @Description("Find Vehicle by vehicleId")
    fun findVehicleById(@Name("vehicleId") @PathParam("id") vehicleId: Long): Vehicle {
        return vehicleService.findById(vehicleId)
    }

    @GET
    @Path("owner/{ownerId}")
    @Query("findVehiclesByOwner")
    @Description("Find Vehicles by ownerId")
    fun findByOwnerId(@Name("ownerId") @PathParam("ownerId") ownerId: Long): List<Vehicle> {
        return vehicleService.findByOwnerId(ownerId)
    }

    @POST
    @Path("addVehicle")
    @Mutation("addVehicle")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    fun addVehicle(vehicle: Vehicle): Vehicle {
        vehicleService.addVehicle(vehicle)
        return vehicle
    }

    @DELETE
    @Path("remove/{id}")
    @Mutation("removeVehicle")
    @Transactional
    fun removeEmployee(@Name("vehicleId") @PathParam("id") vehicleId: Long): Vehicle {
        return vehicleService.removeVehicle(vehicleId)
    }
}