package com.gestion.assignationvoiture.dto;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ReservationDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("hotelName")
    private String hotelName;

    @JsonProperty("customerId")
    private String customerId; // ⚠ String car JSON = "12"

    @JsonProperty("passengerNbr")
    private Integer passengerNbr;

    @JsonProperty("arrivalDate")
    private LocalDateTime arrivalDate;

    public Long getId() {
        return id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public Integer getPassengerNbr() {
        return passengerNbr;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }
}
