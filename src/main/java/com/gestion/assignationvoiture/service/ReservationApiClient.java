package com.gestion.assignationvoiture.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service; 
import org.springframework.web.client.RestTemplate;
import com.gestion.assignationvoiture.dto.ReservationDto;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import com.gestion.assignationvoiture.dto.ApiResponse;

@Service
public class ReservationApiClient {

    @Autowired
    private RestTemplate restTemplate;

    private final String API_URL =
        "https://assignationvoitureback-production.up.railway.app/api/reservations";

    public List<ReservationDto> getReservations() {

        ResponseEntity<ApiResponse<List<ReservationDto>>> response =
            restTemplate.exchange(
                API_URL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<ApiResponse<List<ReservationDto>>>() {}
            );

        return response.getBody().getData(); // 🔥 IMPORTANT
    }
}

