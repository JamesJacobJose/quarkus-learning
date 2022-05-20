package division;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response deleteDivision(@PathParam("id") Long id) 
    {
        DivisionEntity.deleteById(id);
        return Response.noContent().build();
    }
    
}
