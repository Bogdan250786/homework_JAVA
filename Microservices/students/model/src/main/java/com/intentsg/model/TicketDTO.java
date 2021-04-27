package com.intentsg.model;


import java.time.LocalDate;


public class TicketDTO {
    
    private int ticketId;
    private int hallNumber; // зал в якому буде проводитись вистава
    private int placeNumber; // номер місця
    LocalDate date;
    private int userId;
    
    public TicketDTO(int ticketId, int hallNumber, int placeNumber, LocalDate date, int userId) {
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
    
    public LocalDate getDate() {
        return date;
    }
    
    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    public int getUserId() {
        return userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public TicketDTO() {
    }
}
