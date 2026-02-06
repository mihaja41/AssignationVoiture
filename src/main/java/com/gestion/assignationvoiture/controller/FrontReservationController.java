package com.gestion.assignationvoiture.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.gestion.assignationvoiture.dto.ReservationDto;
import com.gestion.assignationvoiture.service.ReservationApiClient;


import java.util.List;

@Controller
public class FrontReservationController {

    @Autowired
    private ReservationApiClient apiClient;

    @GetMapping("/listReservation")
    public String list(
            @RequestParam(required = false) String filterDate,
            Model model
    ) {
    
        List<ReservationDto> data = apiClient.getReservations();
    
        if (filterDate != null && !filterDate.isEmpty()) {
    
            LocalDate date = LocalDate.parse(filterDate);
    
            data = data.stream()
                    .filter(r ->
                        r.getArrivalDate() != null &&
                        r.getArrivalDate().toLocalDate().equals(date)
                    )
                    .toList(); // Java 16+
        }
    
        model.addAttribute("reservations", data);
        model.addAttribute("filterDate", filterDate == null ? "" : filterDate);
    
        return "reservation/reservation-list";
    }
}
