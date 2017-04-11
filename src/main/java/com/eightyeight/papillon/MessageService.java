package com.eightyeight.papillon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by papillon on 4/10/2017.
 */
public class MessageService {

    public List<Message> getAllMessages(){
        Message m1 = new Message(1L,"hello earth","debaspreet");
        Message m2 = new Message(2L,"hello mars","devopreet");
        Message m3 = new Message(3L,"hello jupiter","arnab");

        List<Message> list = new ArrayList<Message>();
        list.add(m1);list.add(m2);list.add(m3);
        return list;
    }
}
