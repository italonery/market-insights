package br.com.mondialgroup.marketinsights.repository;

import br.com.mondialgroup.marketinsights.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
