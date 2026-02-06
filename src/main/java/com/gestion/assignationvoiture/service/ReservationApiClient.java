package com.gestion.assignationvoiture.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service; 
import org.springframework.web.client.RestTemplate;
import com.gestion.assignationvoiture.dto.ReservationDto;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
@Service
public class ReservationApiClient {

    @Autowired
    private RestTemplate restTemplate;

    
    private String API_URL =
        "http://localhost:9001/project1/reservations";

    public List<ReservationDto> getReservations() {

        ResponseEntity<List<ReservationDto>> response =
            restTemplate.exchange(
                API_URL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ReservationDto>>() {}
            );
        return response.getBody();
    }

}

