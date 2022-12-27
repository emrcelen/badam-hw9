package com.garanti.endpoints;

import com.garanti.model.Ders_Ogrenci;
import com.garanti.repo.Ders_OgrenciRepo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;

@Path(value = "/dogr")
public class DogrEndpoints {
    private Ders_OgrenciRepo dogrRepo;

    public DogrEndpoints(){
        this.dogrRepo = new Ders_OgrenciRepo();
    }
    // localhost:9090/FirstRestfulService/dogr/getAll
    @GET
    @Path(value = "getAll")
    @Produces(value = MediaType.APPLICATION_JSON)
    public ArrayList<Ders_Ogrenci> getAll(){
        return this.dogrRepo.getAll();
    }
    // localhost:9090/FirstRestfulService/dogr/getById/id
    @GET
    @Path(value = "/getById/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Ders_Ogrenci getByPathId(@PathParam(value = "id") int id){
        return this.dogrRepo.getById(id);
    }
    // localhost:9090/FirstRestfulService/dogr/getById?id=id
    @GET
    @Path(value = "/getById")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Ders_Ogrenci getByQueryId(@QueryParam(value = "id") int id){
        return this.dogrRepo.getById(id);
    }
    // localhost:9090/FirstRestfulService/dogr/save
    @POST
    @Path(value = "/save")
    @Consumes(value = MediaType.APPLICATION_JSON)
    public String save(Ders_Ogrenci ders_ogrenci){
        this.dogrRepo.save(ders_ogrenci);
        return "Ders_Öğrenci Kaydı Başarılı Bir Şekilde Gerçekleşti.";
    }
}
