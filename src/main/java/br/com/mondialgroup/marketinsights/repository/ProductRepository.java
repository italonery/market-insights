package br.com.mondialgroup.marketinsights.repository;

import br.com.mondialgroup.marketinsights.model.Brand;
import br.com.mondialgroup.marketinsights.model.Category;
import br.com.mondialgroup.marketinsights.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findProductsByCategory(Category category);

    List<Product> findProductsByBrand(Brand brand);

    List<Product> findProductsByBrandAndCategory(Brand brand, Category category);
}
