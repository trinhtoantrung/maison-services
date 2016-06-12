package com.t3.services;

import com.t3.beans.requests.Customer;
import com.t3.dao.MaisonServicesDao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by TrungTrinh on 6/12/16.
 */

@Path("/services")
public class MaisonService {

    @GET
    @Path("/test")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getSampleCustomer() {
        Customer sampleCustomer = new Customer();
        sampleCustomer.setFullName("Trinh Toan Trung");
        sampleCustomer.setEmail("trinhtoantrung@gmail.com");
        sampleCustomer.setMobile("0937906688");
        sampleCustomer.setAddress("Etown - Cong Hoa");
        return sampleCustomer;
    }

    @POST
    @Path("/createCustomer")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCustomer(Customer customer) {
        Boolean resultValue = false;

        try {
            resultValue = MaisonServicesDao.createCustomer(customer);
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }

        String result = "Customer saved: " + resultValue;

        if (resultValue) {
            return Response.status(201).entity(result).build();
        } else {
            return  Response.status(204).entity(result).build();
        }
    }
}
