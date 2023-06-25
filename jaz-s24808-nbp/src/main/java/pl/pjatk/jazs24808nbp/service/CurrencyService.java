package pl.pjatk.jazs24808nbp.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.pjatk.jazs24808nbp.model.CurrencyQuery;
import pl.pjatk.jazs24808nbp.repository.CurrencyQueryRepository;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class CurrencyService {
    private final RestTemplate restTemplate;
    private final CurrencyQueryRepository currencyQueryRepository;

    public CurrencyService(CurrencyQueryRepository currencyQueryRepository) {
        this.currencyQueryRepository = currencyQueryRepository;
        this.restTemplate = new RestTemplate();
    }

    public double calculateAverageGoldRate(LocalDate startDate, LocalDate endDate) {
        // Pobierz dane z API NBP dla danej waluty i liczby dni
        String apiUrl = "http://api.nbp.pl/api/cenyzlota/{startDate}/{endDate}/?format=json";
        String url = apiUrl.replace("{startDate}", startDate.toString()).replace("{endDate}", endDate.toString());

        ResponseEntity<CurrencyQuery> response = restTemplate.getForEntity(url, CurrencyQuery.class);
        CurrencyQuery currencyQuery = response.getBody();

        double averageRate = currencyQuery.getCalculatedRate();

        CurrencyQuery query = new CurrencyQuery();
        query.setCurrency("Złoto");
        query.setStartDate(startDate);
        query.setEndDate(endDate);
        query.setCalculatedRate(averageRate);
        query.setQueryDate(LocalDate.now());
        query.setQueryTime(LocalTime.now());

        currencyQueryRepository.save(currencyQuery);

        return averageRate;
    }
}
