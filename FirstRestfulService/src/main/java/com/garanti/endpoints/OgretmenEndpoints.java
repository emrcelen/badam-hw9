package com.garanti.endpoints;

import com.garanti.model.Ogretmen;
import com.garanti.repo.OgretmenRepo;
import jakarta.json.Json;
import jakarta.json.JsonReader;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.StringReader;
import java.util.ArrayList;

@Path(value = "ogretmen")
public class OgretmenEndpoints
{
    private OgretmenRepo repo;

    public OgretmenEndpoints()
    {
        this.repo = new OgretmenRepo();
    }

    @GET
    @Path(value = "getAll")
    @Produces(value = MediaType.APPLICATION_JSON)
    public ArrayList<Ogretmen> getAll()
    {
        // localhost:9090/FirstRestfulService/ogretmen/getAll
        return repo.getAll();
    }

    @GET
    @Path(value = "getById")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Ogretmen getByIdQueryParam(@QueryParam(value = "id")  Integer id)
    {
        // localhost:9090/FirstRestfulService/ogretmen/getById?id=1
        return repo.getById(id);
    }

    @GET
    @Path(value = "getById/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Ogretmen getByIdPathParam(@PathParam(value = "id") Integer id)
    {
        // path param yazarsam bütün param 'lar set edilmiş olmak zorunda
        // localhost:9090/FirstRestfulService/ogretmen/getById/1
        return repo.getById(id);
    }

    @GET
    @Path(value = "getByHeaderId")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Ogretmen getByIdHeaderParam(@HeaderParam(value = "id")int id){
        return repo.getById(id);
    }

    @POST
    @Path(value = "save")
    @Consumes(value = MediaType.APPLICATION_JSON)
    public String save(Ogretmen ogretmen)
    {
        // localhost:9090/FirstRestfulService/ogretmen/save
        repo.save(ogretmen);
        return "Başarı ile kaydedildi";
    }

    // localhost:9090/FirstRestfulService/ogretmen/deleteById/id
    @DELETE
    @Path(value = "deleteById/{id}")
    public String deleteById(@PathParam(value = "id") int id){
        if(repo.deleteById(id))
            return "Başarılı bir şekilde silme işlemini gerçekleştirdi.";
        return "Silme işlemi gerçekleştirilemedi.";
    }
    // localhost:9090/FirstRestfulService/ogretmen/deleteById/
    @DELETE
    @Path(value = "deleteById")
    public String deleteByHeaderId(@HeaderParam(value = "id") int id){
        if(repo.deleteById(id))
            return "Başarılı bir şekilde silme işlemini gerçekleştirdi.";
        return "Silme işlemi gerçekleştirilemedi.";
    }

}