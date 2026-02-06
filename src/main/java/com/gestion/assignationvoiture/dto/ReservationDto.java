package com.gestion.assignationvoiture.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReservationDto {

    @JsonProperty("id_reservation")
    private Long id;

    @JsonProperty("hotel_name")
    private String hotelName;

    @JsonProperty("customer_id")
    private Integer customerId;

    @JsonProperty("passenger_nbr")
    private Integer passengerNbr;

    @JsonProperty("arrival_date")
    private LocalDateTime arrivalDate;
    

    public Long getId() {
        return id;
    }   
    public void setId(Long id) {
        this.id = id;
    }
    public String getHotelName() {
        return hotelName;   
    }
    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
    public Integer getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    public Integer getPassengerNbr() {
        return passengerNbr;
    }
    public void setPassengerNbr(Integer passengerNbr) {
        this.passengerNbr = passengerNbr;
    }
    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }
    public void setArrivalDate(LocalDateTime arrivalDate) {
        this.arrivalDate = arrivalDate;
    }   
}
