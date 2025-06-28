package br.com.mondialgroup.marketinsights.repository;

import br.com.mondialgroup.marketinsights.model.HistoryPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryPriceRepository extends JpaRepository<HistoryPrice, Long> {
}
