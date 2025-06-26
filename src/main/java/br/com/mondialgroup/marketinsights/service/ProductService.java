package br.com.mondialgroup.marketinsights.service;

import br.com.mondialgroup.marketinsights.model.Brand;
import br.com.mondialgroup.marketinsights.model.Category;
import br.com.mondialgroup.marketinsights.model.Product;
import br.com.mondialgroup.marketinsights.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final BrandService brandService;
    private final CategoryService categoryService;

    public Product save(Product product) {
        product.setBrand(this.findBrand(product.getBrand()));
        product.setCategory(this.findCategory(product.getCategory()));
        return productRepository.save(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> findByBrand(Long brandId) {
        return productRepository.findProductsByBrand(Brand.builder().id(brandId).build());
    }

    public List<Product> findByCategory(Long categoryId) {
        return productRepository.findProductsByCategory(Category.builder().id(categoryId).build());
    }

    public List<Product> findByBrandAndCategory(Long brandId, Long categoryId) {
        Category category = Category.builder().id(categoryId).build();
        Brand brand = Brand.builder().id(brandId).build();
        return productRepository.findProductsByBrandAndCategory(brand, category);
    }

    public Optional<Product> update(Long productId, Product updateProduct) {
        Optional<Product> optProduct = productRepository.findById(productId);
        if (optProduct.isPresent()) {

            Brand brand = this.findBrand(updateProduct.getBrand());
            Category category = this.findCategory(updateProduct.getCategory());

            Product product = optProduct.get();
            product.setSku(updateProduct.getSku());
            product.setName(updateProduct.getName());
            product.setBrand(brand);
            product.setCategory(category);
            product.setFeature1(updateProduct.getFeature1());
            product.setFeature2(updateProduct.getFeature2());
            product.setFeature3(updateProduct.getFeature3());

            productRepository.save(product);
            return Optional.of(product);
        }
        return Optional.empty();
    }

    private Brand findBrand(Brand brand) {
        Brand brandFound = brandService.findById(brand.getId()).orElse(null);
        return brandFound;
    }

    private Category findCategory(Category category) {
        Category categoryFound = categoryService.findById(category.getId()).orElse(null);
        return categoryFound;
    }
}
