package dev.java10x.controller;
import dev.java10x.domain.Users;
import dev.java10x.service.UserService;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import java.util.UUID;

@Path("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GET
    @Path("/list")
    public Response findAllUsers (@QueryParam("page") @DefaultValue("0") Integer page,
                                  @QueryParam("pageSize") @DefaultValue("10")  Integer pageSize) {
        var users = userService.findAllUsers(page, pageSize);
        return Response.ok(users).build();
    }

    @GET
    @Path("/{id}")
    public Response findUserById (@PathParam("id") UUID userId) {
        return Response.ok(userService.findUserById(userId)).build();
    }

    @PUT
    @Path("/update/{id}")
    @Transactional
    public Response updateUser (@PathParam("id") UUID userId, Users users) {
        return Response.ok(userService.updateUser(userId, users)).build();
    }

    @POST
    @Path("/create")
    @Transactional
    public Response createUser (Users users) {
        return Response.ok(userService.createUser(users)).build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Transactional
    public Response deleteUser (@PathParam("id") UUID userId) {
        userService.deleteUser(userId);
        return Response.ok("User removed").build();
    }

}