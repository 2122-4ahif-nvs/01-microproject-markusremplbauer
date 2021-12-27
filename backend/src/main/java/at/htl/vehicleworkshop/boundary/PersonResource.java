package at.htl.vehicleworkshop.boundary;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import at.htl.vehicleworkshop.control.service.PersonService;
import at.htl.vehicleworkshop.entity.Person;

@Path("/person")
public class PersonResource {
    @Inject
    PersonService personService;

    @GET
    @Path("findAll")
    public List<Person> getAllPersons() {
        return personService.findAll();
    }

    @POST
    @Transactional
    @Path("addPerson")
    @Consumes(MediaType.APPLICATION_JSON)
    public Person addPerson(@Valid Person person) {
        personService.persist(person);
        return person;
    }

    @GET
    @Path("find/{id}")
    public Person findPersonById(@PathParam("id") Long personId) {
        return personService.getById(personId);
    }

    @DELETE
    @Transactional
    @Path("remove/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person removeEmployee(@PathParam("id") long personId) {
        Person person = personService.removePerson(personId);
        return person;
    }
}
