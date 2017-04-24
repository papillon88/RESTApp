package com.eightyeight.papillon.endpoints;

import com.eightyeight.papillon.dto.Message;
import com.eightyeight.papillon.dto.Profile;
import com.eightyeight.papillon.service.ProfileService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by papillon on 4/23/2017.
 */

@Path("/profiles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileResource {

    private ProfileService profileService = new ProfileService();

    @GET
    //@Produces(MediaType.APPLICATION_XML)
    public List<Profile> getMessages(){
        return profileService.getAllProfiles();
    }

    @GET
    @Path("/{profileName}")
    //@Produces(MediaType.APPLICATION_XML)
    public Profile getProfile(@PathParam("profileName") String profile){
        return profileService.getProfile(profile);
    }

    @POST
    //@Produces(MediaType.APPLICATION_XML)
    public List<Profile> addProfile(Profile profile){
        return profileService.addProfile(profile);
    }

    @PUT
    @Path("/{profileName}")
    public Profile updateProfile(@PathParam("profileName") String profileName, Profile profile){
        profile.setProfileName(profileName);
        return profileService.updateProfile(profile);
    }

    @DELETE
    @Path("/{profileName}")
    public Profile deleteProfile(@PathParam("profileName") String profileName){
        return profileService.removeProfile(profileName);
    }

}
