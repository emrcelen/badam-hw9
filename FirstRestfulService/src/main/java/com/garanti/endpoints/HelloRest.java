package com.garanti.endpoints;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

// localhost:9090/FirstRestfulService/hello
@jakarta.ws.rs.Path(value = "rest")
public class HelloRest
{
    @GET
    @Path(value = "hello")
    public String abuziddin()
    {
        // localhost:9090/FirstRestfulService/rest/hello
        return "hello jakarta rest";
    }
}