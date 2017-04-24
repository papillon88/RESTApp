package com.eightyeight.papillon.database;

import com.eightyeight.papillon.dto.Message;
import com.eightyeight.papillon.dto.Profile;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by papillon on 4/10/2017.
 */
public class Database {

    private static final Map<Long,Message> messages = new HashMap<Long, Message>();
    private static final Map<String,Profile> profiles = new HashMap<String, Profile>();

    public static Map<Long,Message> getMessages(){
        return messages;
    }

    public static Map<String,Profile> getProfiles(){
        return profiles;
    }


}
