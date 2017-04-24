package com.eightyeight.papillon.service;

import com.eightyeight.papillon.database.Database;
import com.eightyeight.papillon.dto.Profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by papillon on 4/23/2017.
 */
public class ProfileService {

    private Map<String,Profile> profiles;

    public ProfileService(){
        profiles  = Database.getProfiles();
        profiles.put("devopreet",new Profile(1L,"chowdhury","devopreet","devopreet"));
        profiles.put("puta",new Profile(3L,"choudhary","jyotiranee","puta"));
        profiles.put("jingless",new Profile(4L,"gandhi","sandhya","jingless"));

    }

    public List<Profile> getAllProfiles(){
        return new ArrayList<Profile>(profiles.values());
    }

    public Profile getProfile(String profileName){
        return profiles.get(profileName);
    }

    public List<Profile> addProfile(Profile profile){
        profile.setId(profiles.size() + 1);
        profiles.put(profile.getProfileName(),profile);
        return new ArrayList<Profile>(profiles.values());
    }

    public Profile updateProfile(Profile profile){
        if(profile.getProfileName().isEmpty()){
            return null;
        }
        profiles.put(profile.getProfileName(),profile);
        return profile;
    }

    public Profile removeProfile(String profileName){
        return profiles.remove(profileName);
    }



}
