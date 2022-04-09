package dev.ifrs;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.quarkus.oidc.token.propagation.AccessToken;

@RegisterRestClient()
@AccessToken
public interface BackendClient {

    @GET
    @Path("/getSum/{a}/{b}")
    @Produces(MediaType.TEXT_PLAIN)
    @RolesAllowed({ "Admin" })
    public int getSum(@PathParam("a") int a, @PathParam("b") int b);

}