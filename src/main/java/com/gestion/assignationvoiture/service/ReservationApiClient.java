package com.gestion.assignationvoiture.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.gestion.assignationvoiture.dto.ReservationDto;

@Service
public class ReservationApiClient {

    @Autowired
    private RestTemplate restTemplate;

    private String API_URL =
        "http://localhost:8080/api/reservations";

    public ReservationDto[] getReservations() {
        return restTemplate.getForObject(
            API_URL,
            ReservationDto[].class
        );
    }
}

