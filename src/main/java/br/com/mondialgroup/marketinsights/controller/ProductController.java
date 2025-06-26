package br.com.mondialgroup.marketinsights.controller;

import br.com.mondialgroup.marketinsights.dto.request.ProductRequest;
import br.com.mondialgroup.marketinsights.dto.response.ProductResponse;
import br.com.mondialgroup.marketinsights.mapper.ProductMapper;
import br.com.mondialgroup.marketinsights.model.Product;
import br.com.mondialgroup.marketinsights.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponse> saveProduct(@RequestBody ProductRequest request) {
        Product newProduct = ProductMapper.toProduct(request);
        Product savedProduct = productService.save(newProduct);
        return ResponseEntity.status(HttpStatus.CREATED).body(ProductMapper.toProductResponse(savedProduct));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        List<ProductResponse> products = productService.findAll()
                .stream()
                .map(ProductMapper::toProductResponse)
                .toList();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getByProductId(@PathVariable Long id) {
        return productService.findById(id)
                .map(product -> ResponseEntity.ok(ProductMapper.toProductResponse(product)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductResponse>> searchProducts(@RequestParam(required = false) Long brand,
                                                                @RequestParam(required = false) Long category) {
        List<Product> products;

        if (brand != null && category != null) {
            products = productService.findByBrandAndCategory(brand, category);
        } else if (brand != null) {
            products = productService.findByBrand(brand);
        } else if (category != null) {
            products = productService.findByCategory(category);
        } else {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(products.stream()
                .map(ProductMapper::toProductResponse)
                .toList());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable Long id, @RequestBody ProductRequest request) {
        return productService.update(id, ProductMapper.toProduct(request))
                .map(product -> ResponseEntity.ok(ProductMapper.toProductResponse(product)))
                .orElse(ResponseEntity.notFound().build());
    }

}
