package pl.pjatk.jazs24808nbp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pjatk.jazs24808nbp.model.CurrencyQuery;

@Repository
public interface CurrencyQueryRepository extends JpaRepository<CurrencyQuery, Long> {

}
