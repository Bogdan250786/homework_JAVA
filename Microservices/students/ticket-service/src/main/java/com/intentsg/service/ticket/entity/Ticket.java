package com.intentsg.service.ticket.entity;


import java.util.Date;

public class Ticket {
    
    private int ticketId;
    private int hallNumber; // зал в якому буде проводитись вистава
    private int placeNumber; // номер місця
    private Date date;
    private int userId;
    
    public Ticket(int ticketId, int hallNumber, int placeNumber, Date date, int userId) {
        this.ticketId = ticketId;
        this.hallNumber = hallNumber;
        this.placeNumber = placeNumber;
        this.date = date;
        this.userId = userId;
    }
    
    public int getTicketId() {
        return ticketId;
    }
    
    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }
    
    public int getHallNumber() {
        return hallNumber;
    }
    
    public void setHallNumber(int hallNumber) {
        this.hallNumber = hallNumber;
    }
    
    public int getPlaceNumber() {
        return placeNumber;
    }
    
    public void setPlaceNumber(int placeNumber) {
        this.placeNumber = placeNumber;
    }
    
    public Date getDate() {
        return date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    public int getUserId() {
        return userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public Ticket() {
    }
}
