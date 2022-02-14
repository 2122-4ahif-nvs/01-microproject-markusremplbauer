package at.htl.vehicleworkshop.boundary;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import at.htl.vehicleworkshop.control.service.PersonService;
import at.htl.vehicleworkshop.entity.Person;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;

@Path("v1/person")
@RolesAllowed({"user", "admin"})
public class PersonResource {
    @Inject
    PersonService personService;

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance persons(List<Person> persons);

        public static native TemplateInstance person(Person person);

        public static native TemplateInstance error(String error);
    }

    @GET
    @Path("findAll")
    public List<Person> findAllPersons() {
        return personService.findAll();
    }

    @POST
    @Transactional
    @Path("addPerson")
    @Consumes(MediaType.APPLICATION_JSON)
    public Person addPerson(@Valid Person person) {
        personService.addPerson(person);
        return person;
    }

    @GET
    @Path("find/{id}")
    public Person findPersonById(@PathParam("id") Long personId) {
        return personService.findById(personId);
    }

    @DELETE
    @Transactional
    @Path("remove/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person removePerson(@PathParam("id") long personId) {
        Person person = personService.removePerson(personId);
        return person;
    }

    @GET
    @Path("qute/find/{id}")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance quteFindPersonById(@PathParam("id") Long personId) {
        Person person = personService.findById(personId);

        if (person != null) {
            return Templates.person(person);
        }
        return Templates.error(String.format("Person with id %d not found!", personId));

    }

    @GET
    @Path("qute/findAll")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance quteFindAll() {
        return Templates.persons(personService.findAll());
    }

}
