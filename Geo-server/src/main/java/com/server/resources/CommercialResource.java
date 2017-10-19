package com.server.resources;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.server.backend.DatabaseBackend;
import com.server.backend.Commercial;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.sql.Date;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;




import static com.google.common.base.Preconditions.checkNotNull;

@Path("/Commercial")
@Produces({MediaType.APPLICATION_JSON})
public class CommercialResource {
    DatabaseBackend databaseBackend;
    GsonBuilder gsonB = new  GsonBuilder().setDateFormat("yyyy-MM-dd");

    public CommercialResource(DatabaseBackend databaseBackend){
        this.databaseBackend = databaseBackend;
    }

    @GET
    @Path("/getAll")
    public List<Commercial> getAll() {
        return databaseBackend.getAll();

    }



    @POST
    @Path("/submitCommercial")
    @Consumes(MediaType.APPLICATION_JSON)
    //@RegisterMapper(CommercialMapper.class)
    public void submitCommercial(String commercialJSON)  {

        checkNotNull(commercialJSON);
        Gson gson = gsonB.create();
        Commercial commercial = gson.fromJson(commercialJSON, Commercial.class);
        System.out.println(commercialJSON);
        System.out.println(commercial.getCompany() + " " + commercial.getCredit() + " " + commercial.getStartDate());
        /*
        try {
            Commercial test = objectMapper.readValue(commercial, Commercial.class);
            System.out.println(test);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        */

       databaseBackend.submitCommercial(commercial.getCompany(), commercial.getCredit(), commercial.getStartDate());

    }

    /*

        @GET
    @Path("submitCommercial/{company}/{credit}/{startDate}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void submitCommercial(@PathParam("company") String company,
                                 @PathParam("credit") double credit,
                                 @PathParam("startDate") String startDate)  {

        checkNotNull(company);
        checkNotNull(credit);
        checkNotNull(startDate);

        Date date = java.sql.Date.valueOf(startDate);

        databaseBackend.submitCommercial(company, credit, date);

    }
     */

    @GET
    @Path("/getNearby/{lat}/{long}/{rad}")
    public List<Commercial> getNearby(@PathParam("lat") double lat,
                                      @PathParam("long") double longitude,
                                      @PathParam("rad") double rad ) {
        /* Return nearby commercials with Redis */

        return null;
    }



}
