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
    public String list(@RequestParam(required = false) String filterDate, Model model) {

       List<ReservationDto> data =
            apiClient.getReservations();

        // Filtrer par date si un filtre est fourni
        if (filterDate != null && !filterDate.isEmpty()) {
            data = Arrays.stream(data)
                .filter(r -> r.getArrivalDate().startsWith(filterDate))
                .toArray(ReservationDto[]::new);
        }

        model.addAttribute("reservations", data);
        model.addAttribute("filterDate", filterDate != null ? filterDate : "");

        return "reservation/reservation-list";
    }
}
