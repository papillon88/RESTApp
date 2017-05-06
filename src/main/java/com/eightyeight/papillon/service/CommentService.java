package com.eightyeight.papillon.service;

import com.eightyeight.papillon.database.Database;
import com.eightyeight.papillon.dto.Comment;
import com.eightyeight.papillon.dto.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by papillon on 5/5/2017.
 */
public class CommentService {

    private Map<Long,Message> messageMap;

    public CommentService(){
        messageMap = Database.getMessages();
        System.out.println("comment service created");
    }

    public List<Comment> getComments(long messageId){
        return new ArrayList<Comment>(messageMap.get(messageId).getComments().values());
    }
    public Comment getComment(long messageId,long commentId){
        return messageMap.get(messageId).getComments().get(commentId);
    }
    public List<Comment> addComment(long messageId,Comment comment){
        Map<Long,Comment> commentsInMessage = messageMap.get(messageId).getComments();
        commentsInMessage.put((long)commentsInMessage.size()+1,comment);
        return new ArrayList<Comment>(commentsInMessage.values());
    }
    public List<Comment> updateComment(long messageId,long commentId,Comment comment){
        messageMap.get(messageId).getComments().put((long)commentId,comment);
        return new ArrayList<Comment>(messageMap.get(messageId).getComments().values());
    }
    public List<Comment> removeComment(long messageId,long commentId){
        messageMap.get(messageId).getComments().remove(commentId);
        return new ArrayList<Comment>(messageMap.get(messageId).getComments().values());
    }
}
