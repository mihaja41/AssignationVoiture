package com.gestion.assignationvoiture.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.gestion.assignationvoiture.dto.ReservationDto;
import com.gestion.assignationvoiture.service.ReservationApiClient;
import java.util.List;

@Controller
public class FrontReservationController {

    @Autowired
    private ReservationApiClient apiClient;

    @GetMapping("/listReservation")
    public String list(Model model) {

       List<ReservationDto> data =
            apiClient.getReservations();

        model.addAttribute("reservations", data);

        return "reservation/reservation-list";
    }
}
