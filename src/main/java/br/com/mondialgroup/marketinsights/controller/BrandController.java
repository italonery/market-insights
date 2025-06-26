package br.com.mondialgroup.marketinsights.controller;

import br.com.mondialgroup.marketinsights.dto.request.BrandResquest;
import br.com.mondialgroup.marketinsights.dto.response.BrandResponse;
import br.com.mondialgroup.marketinsights.mapper.BrandMapper;
import br.com.mondialgroup.marketinsights.model.Brand;
import br.com.mondialgroup.marketinsights.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/brand")
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;

    @GetMapping
    public ResponseEntity<List<BrandResponse>> getAllBrands() {
        List<BrandResponse> brands = brandService.findAll()
                .stream()
                .map(BrandMapper::toBrandResponse)
                .toList();
        return ResponseEntity.ok(brands);
    }

    @PostMapping
    public ResponseEntity<BrandResponse> saveBrand(@RequestBody BrandResquest request) {
        Brand newBrand = BrandMapper.toBrand(request);
        Brand savedBrand = brandService.saveBrand(newBrand);
        return ResponseEntity.status(HttpStatus.CREATED).body(BrandMapper.toBrandResponse(savedBrand));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BrandResponse> getBrandById(@PathVariable Long id) {
        return brandService.findById(id)
                .map(brand -> ResponseEntity.ok(BrandMapper.toBrandResponse(brand)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByBrandId(@PathVariable Long id) {
        Brand brand = brandService.findById(id).orElse(null);
        if (brand != null) {
            brandService.deleteBrand(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.notFound().build();
    }
}
