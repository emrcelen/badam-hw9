package com.garanti.endpoints;

import com.garanti.model.Konu;
import com.garanti.repo.KonuRepo;
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

@Path(value = "konu")
public class KonuEndpoints {
    private KonuRepo konuRepo;

    public KonuEndpoints(){
        this.konuRepo = new KonuRepo();
    }
    // localhost:9090/FirstRestfulService/konu/getAll
    @GET
    @Path(value = "getAll")
    @Produces(value = MediaType.APPLICATION_JSON)
    public ArrayList<Konu> getAll(){
        return this.konuRepo.getALl();
    }
    // localhost:9090/FirstRestfulService/konu/getById/id
    @GET
    @Path(value = "getById/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Konu getByPathId(@PathParam(value = "id") int id){
        return this.konuRepo.getById(id);
    }
    // localhost:9090/FirstRestfulService/konu/getById?id=id
    @GET
    @Path(value = "getById")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Konu getByQueryId(@QueryParam(value = "id") int id){
        return this.konuRepo.getById(id);
    }
    // localhost:9090/FirstRestfulService/konu/save
    @POST
    @Path(value = "save")
    @Consumes(value = MediaType.APPLICATION_JSON)
    public String save(Konu konu){
        this.konuRepo.save(konu);
        return "Başarılı bir şekilde konu kaydı gerçekleştirildi.";
    }

    // localhost:9090/FirstRestfulService/konu/deleteById/id
    @DELETE
    @Path(value = "deleteById/{id}")
    public String deleteById(@PathParam(value = "id") int id){
        if(konuRepo.deleteById(id))
            return "Başarılı bir şekilde silme işlemini gerçekleştirdi.";
        return "Silme işlemi gerçekleştirilemedi.";
    }
    // localhost:9090/FirstRestfulService/konu/deleteById/
    @DELETE
    @Path(value = "deleteById")
    public String deleteByHeaderId(@HeaderParam(value = "id") int id){
        if(konuRepo.deleteById(id))
            return "Başarılı bir şekilde silme işlemini gerçekleştirdi.";
        return "Silme işlemi gerçekleştirilemedi.";
    }
}
