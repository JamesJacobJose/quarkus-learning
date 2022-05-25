package division;

import java.util.Objects;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;


@Path("/divisions")
@Tag(name = "Divisions")
public class DivisionResource {

    @Inject
    DivisionTransformer divisionTransformer ;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createDivision(DivisionEntity divisionEntity) 
    {
        divisionEntity.persist();
        return Response.status(Status.CREATED).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAllDivisions()
    {
        return Response.ok(DivisionEntity.listAll()).build();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDivisionById(@PathParam("id") Long id) 
    {
        DivisionEntity divisionEntity = DivisionEntity.findById(id);
        return Response.ok(divisionEntity).build();
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response updateDivision(@PathParam("id") Long id, Division division) 
    {
        DivisionEntity divisionEntity = DivisionEntity.findById(id);

        if (Objects.nonNull(division.getOrganizationId())) {
            divisionEntity.organizationId = division.getOrganizationId();
        }
        if (Objects.nonNull(division.getCode())) {
            divisionEntity.code = division.getCode();
        }
        if (Objects.nonNull(division.getName())) {
            divisionEntity.name = division.getName();
        }
        if (Objects.nonNull(division.getShortName())) {
            divisionEntity.shortName = division.getShortName();
        }
        if (Objects.nonNull(division.getTaxIdentifier())) {
            divisionEntity.taxIdentifier = division.getTaxIdentifier();
        }
        if (Objects.nonNull(division.getDetails())) {
            divisionEntity.details = division.getDetails();
        }
        if (Objects.nonNull(division.getNotes())) {
            divisionEntity.notes = division.getNotes();
        }
        if (Objects.nonNull(division.getCreatedBy())) {
            divisionEntity.createdBy = division.getCreatedBy();
        }
        if (Objects.nonNull(division.getUpdatedBy())) {
            divisionEntity.updatedBy = division.getUpdatedBy();
        }
        if (Objects.nonNull(division.getCreatedAt())) {
            divisionEntity.createdAt = division.getCreatedAt();
        }
        if (Objects.nonNull(division.getUpdatedAt())) {
            divisionEntity.updatedAt = division.getUpdatedAt();
        }
        return Response.noContent().build();
    }

    @Path("/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response deleteDivision(@PathParam("id") Long id) 
    {
        DivisionEntity.deleteById(id);
        return Response.noContent().build();
    }
    
}
