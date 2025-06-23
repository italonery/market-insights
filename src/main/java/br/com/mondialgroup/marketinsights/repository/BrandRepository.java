package br.com.mondialgroup.marketinsights.repository;

import br.com.mondialgroup.marketinsights.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
}
