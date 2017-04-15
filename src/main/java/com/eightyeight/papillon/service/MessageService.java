package com.eightyeight.papillon.service;

import com.eightyeight.papillon.database.Database;
import com.eightyeight.papillon.dto.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by papillon on 4/10/2017.
 */
public class MessageService {

    private Map<Long,Message> messageMap;

    public MessageService(){
        messageMap = Database.getMessages();
        messageMap.put(1L,new Message(1,"Hello Debaspreet","debaspreet"));
        messageMap.put(2L,new Message(2,"Hello devopreet","devopreet"));
        messageMap.put(3L,new Message(3,"Hello Arnab","arnab"));
        messageMap.put(4L,new Message(4,"Hello Sandhya","jingles"));
        messageMap.put(5L,new Message(5,"Hello Sandy","momo"));
    }

    public List<Message> getAllMessages(){
        return new ArrayList<Message>(messageMap.values());
    }

    public Message getMessage(long id){
        return messageMap.get(id);
    }

    public List<Message> addMessage(Message message){
        message.setId(messageMap.size()+1);
        messageMap.put(message.getId(),message);
        return this.getAllMessages();
    }

    public List<Message> updateMessage(Message message){
        messageMap.put(message.getId(),message);
        return new ArrayList<Message>(messageMap.values());
    }

    public List<Message> removeMessage(long id){
        messageMap.remove(id);
        return new ArrayList<Message>(messageMap.values());
    }
}
