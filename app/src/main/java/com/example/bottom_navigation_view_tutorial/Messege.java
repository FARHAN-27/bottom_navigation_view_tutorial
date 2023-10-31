package com.example.bottom_navigation_view_tutorial;

public class Messege {
    private String sender , receiver , message ;
    private long timestamp ;
    public Messege(String message  , String sender , String receiver , long timestamp )
    {
        this.sender = sender ;
        this.receiver = receiver ;
        this.message = message ;
        this.timestamp = timestamp ;
    }

    public long getTimestamp()
    {
        return this.timestamp ;
    }
    public void setTimestamp(long timestamp)
    {
        this.timestamp = timestamp ;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecevier() {
        return receiver;
    }

    public void setRecevier(String recevier) {
        this.receiver = recevier;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
