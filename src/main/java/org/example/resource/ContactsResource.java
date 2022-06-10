package org.example.resource;

import io.dropwizard.jersey.params.LongParam;
import org.example.controller.Contanct;
import org.example.repository.ContactsRepository;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;
import java.util.Collections;
import java.util.OptionalLong;

@Path("/contacts")
@Produces(MediaType.APPLICATION_JSON)
public class ContactsResource {

    private ContactsRepository repository;

    public ContactsResource(ContactsRepository repository){
        this.repository=repository;
    }

    @GET
    @Path("/healthCheck")
    public String healthCheck(){
        return "Ping received at "+new Date();
    }

    @GET
    public List<Contanct> allContacts(){
        return repository.getAll();
    }

    @GET
    @Path("{id}")
//    public Contanct contact(@PathParam("id") OptionalLong id){
//        Optional<Contanct> result=repository.getById(id.get());
//            return result
//                .orElseThrow(() ->
//                        new WebApplicationException("Contact not found", 404));
        public Contanct contact(@PathParam("id")LongParam id){
        return repository.getById(id.get())
                .orElseThrow(() ->
                        new WebApplicationException("Contact not found", 404));
    }


    @POST
    public Contanct create(Contanct contanct){
        return repository.save(contanct);
    }

    @PUT
    @Path("{id}")
    public Contanct update(@PathParam("id") LongParam id, Contanct contanct) {
        return repository.update(id.get(), contanct)
                .orElseThrow(() ->
                        new WebApplicationException("Contact not found", 404));
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") LongParam id) {
        repository.delete(id.get());
        return Response.ok().build();
    }


}
