package com.example.sayla.chatapp;

/**
 * Created by sayla on 04/12/2016.
 */
public class MessageModel  {

    private String Message;
    private String NodeKey;


    public MessageModel(){}

    public MessageModel(String message, String nodeKey) {
        Message = message;
        NodeKey = nodeKey;
    }

    public String getMessage() {
        return Message;
    }

    public String getNodeKey() {
        return NodeKey;
    }
}
