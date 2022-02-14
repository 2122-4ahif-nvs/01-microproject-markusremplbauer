package at.htl.vehicleworkshop.boundary.api

import at.htl.vehicleworkshop.control.service.PersonService
import at.htl.vehicleworkshop.entity.Person
import io.quarkus.qute.CheckedTemplate
import io.quarkus.qute.TemplateInstance
import javax.annotation.security.RolesAllowed
import javax.inject.Inject
import javax.transaction.Transactional
import javax.validation.Valid
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/person")
@RolesAllowed("user", "admin")
class PersonApi {

    @Inject
    lateinit var personService:PersonService;

    @CheckedTemplate
    object Templates {
        external fun persons(persons: List<Person>): TemplateInstance
        external fun person(person: Person): TemplateInstance
        external fun error(error: String): TemplateInstance
    }

    @GET
    @Path("findAll")
    fun findAllPersons(): List<Person> {
        return personService.findAll()
    }

    @POST
    @Transactional
    @Path("addPerson")
    @Consumes(MediaType.APPLICATION_JSON)
    fun addPerson(person: @Valid Person): Person {
        personService.addPerson(person)
        return person
    }

    @GET
    @Path("find/{id}")
    fun findPersonById(@PathParam("id") personId: Long): Person {
        return personService.findById(personId)
    }

    @DELETE
    @Transactional
    @Path("remove/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun removePerson(@PathParam("id") personId: Long): Person {
        return personService.removePerson(personId)
    }

    @GET
    @Path("qute/find/{id}")
    @Produces(MediaType.TEXT_HTML)
    fun quteFindPersonById(@PathParam("id") personId: Long): TemplateInstance {
        val person = personService.findById(personId)
        return if (person != null) {
            Templates.person(person)
        } else Templates.error("Person with id $personId not found!")
    }

    @GET
    @Path("qute/findAll")
    @Produces(MediaType.TEXT_HTML)
    fun quteFindAll(): TemplateInstance {
        return Templates.persons(personService.findAll())
    }
}