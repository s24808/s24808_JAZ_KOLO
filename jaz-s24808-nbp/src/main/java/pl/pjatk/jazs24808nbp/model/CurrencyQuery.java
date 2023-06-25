package pl.pjatk.jazs24808nbp.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "table")
@Schema(description = "Zloto Tabela")
public class CurrencyQuery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID")
    @Column(name = "id")
    private Long id;

    @Schema(description = "Zloto")
    @Column(name = "currency")
    private String currency;

    @Schema(description = "Czas startu zapytania")
    @Column(name = "startDate")
    private LocalDate startDate;

    @Schema(description = "Czas końca zapytania")
    @Column(name = "endDate")
    private LocalDate endDate;

    @Schema(description = "Średnia")
    @Column(name = "calculated_rate")
    private double calculatedRate;

    @Schema(description = "Data")
    @Column(name = "query_date")
    private LocalDate queryDate;

    @Schema(description = "Godzina")
    @Column(name = "query_time")
    private LocalTime queryTime;

    // konstruktory, gettery, settery

    public CurrencyQuery() {
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getCalculatedRate() {
        return calculatedRate;
    }

    public void setCalculatedRate(double calculatedRate) {
        this.calculatedRate = calculatedRate;
    }

    public void setQueryDate(LocalDate queryDate) {
        this.queryDate = queryDate;
    }

    public void setQueryTime(LocalTime queryTime) {
        this.queryTime = queryTime;
    }
}
