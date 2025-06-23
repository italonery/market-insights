package br.com.mondialgroup.marketinsights.repository;

import br.com.mondialgroup.marketinsights.model.Marketplace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarktplaceRepository extends JpaRepository<Marketplace, Long> {
}
