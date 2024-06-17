package com.testingQuarkus.controller;

import java.util.List;

import com.testingQuarkus.dto.PersonDTO;
import com.testingQuarkus.model.Person;
import com.testingQuarkus.service.PersonSerivce;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonController {
    
    @Inject
    PersonSerivce service;

    @GET
    public List<PersonDTO> listAll() {
        return service.listAll();
    }

    @GET
    @Path("/{id}")
    public PersonDTO findById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @POST
    public Response add(PersonDTO person) {
        service.add(person);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, PersonDTO person) {
        service.update(id, person);
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

}
