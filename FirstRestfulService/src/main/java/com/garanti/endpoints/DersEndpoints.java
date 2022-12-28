package com.garanti.endpoints;

import com.garanti.model.Ders;
import com.garanti.repo.DersRepo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;

@Path(value = "ders")
public class DersEndpoints {
    private DersRepo dersRepo;

    public DersEndpoints(){
        this.dersRepo = new DersRepo();
    }

    // localhost:9090/FirstRestfulService/ders/getAll
    @GET
    @Path(value = "getAll")
    @Produces(value = MediaType.APPLICATION_JSON)
    public ArrayList<Ders> getAll(){
        return this.dersRepo.getAll();
    }
    // localhost:9090/FirstRestfulService/ders/getById/id
    @GET
    @Path(value = "getById/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Ders getByPathId(@PathParam("id") int id){
        return this.dersRepo.getById(id);
    }
    // localhost:9090/FirstRestfulService/ders/getById?id=id
    @GET
    @Path(value = "getById")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Ders getByQueryId(@QueryParam("id") int id){
        return this.dersRepo.getById(id);
    }
    // localhost:9090/FirstRestfulService/ders/save
    @POST
    @Path(value = "save")
    @Consumes(value = MediaType.APPLICATION_JSON)
    public String save(Ders ders){
        this.dersRepo.save(ders);
        return "Başarılı bir şekilde ders kaydı gerçekleşti.";
    }
    // localhost:9090/FirstRestfulService/ders/deleteById/id
    @DELETE
    @Path(value = "deleteById/{id}")
    public String deleteById(@PathParam(value = "id") int id){
        if(dersRepo.deleteById(id))
            return "Başarılı bir şekilde silme işlemini gerçekleştirdi.";
        return "Silme işlemi gerçekleştirilemedi.";
    }
    // localhost:9090/FirstRestfulService/ders/deleteById/
    @DELETE
    @Path(value = "deleteById")
    public String deleteByHeaderId(@HeaderParam(value = "id") int id){
        if(dersRepo.deleteById(id))
            return "Başarılı bir şekilde silme işlemini gerçekleştirdi.";
        return "Silme işlemi gerçekleştirilemedi.";
    }
}
