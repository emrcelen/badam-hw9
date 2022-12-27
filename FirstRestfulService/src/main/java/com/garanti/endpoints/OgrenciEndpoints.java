package com.garanti.endpoints;

import com.garanti.model.Ogrenci;
import com.garanti.repo.OgrenciRepo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;

@Path(value = "/ogrenci")
public class OgrenciEndpoints {

    private OgrenciRepo ogrenciRepo;

    public OgrenciEndpoints(){
        this.ogrenciRepo = new OgrenciRepo();
    }

    // localhost:9090/FirstRestfulService/ogrenci/getAll
    @GET
    @Path(value = "getAll")
    @Produces(value = MediaType.APPLICATION_JSON)
    public ArrayList<Ogrenci> getAll(){
        return this.ogrenciRepo.getAll();
    }
    // localhost:9090/FirstRestfulService/ogrenci/getById/id
    @GET
    @Path(value = "getById/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Ogrenci getByPathId(@PathParam(value = "id") int id){
        return this.ogrenciRepo.getById(id);
    }
    // localhost:9090/FirstRestfulService/ogrenci/getById?id=id
    @GET
    @Path(value = "getById")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Ogrenci getByQueryId(@QueryParam(value = "id") int id){
        return this.ogrenciRepo.getById(id);
    }
    // localhost:9090/FirstRestfulService/ogrenci/save
    @POST
    @Path(value = "save")
    @Consumes(value = MediaType.APPLICATION_JSON)
    public String save(Ogrenci ogrenci){
        this.ogrenciRepo.save(ogrenci);
        return "Başarılı bir şekilde öğrenci kaydı oluşturuldu.";
    }

}
