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
    private static final Map<Long,Profile> profiles = new HashMap<Long, Profile>();

    public static Map<Long,Message> getMessages(){
        return messages;
    }

    public static Map<Long,Profile> getProfiles(){
        return profiles;
    }


}
