package pl.pjatk.jazs24808nbp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.jazs24808nbp.service.CurrencyService;

import java.time.LocalDate;

@RestController
@Tag(name = "Kontroler Zlota", description = "Endpointy do zarządzania zlotem")
public class CurrencyController {

    private final CurrencyService currencyService;

    @Autowired
    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/average-gold-rate")
    @Operation(summary = "Średni kurs zlota", description = "Pobierz średni kurs zlota w zaleznosci od podanej daty")
    public ResponseEntity<Double> getAverageGoldRate(
            @RequestParam("start_date")LocalDate startDate,
            @RequestParam("end_date") LocalDate endDate){

        double averageRate = currencyService.calculateAverageGoldRate(startDate, endDate);

        return ResponseEntity.ok(averageRate);
    }
}