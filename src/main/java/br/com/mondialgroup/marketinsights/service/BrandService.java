package br.com.mondialgroup.marketinsights.service;

import br.com.mondialgroup.marketinsights.model.Brand;
import br.com.mondialgroup.marketinsights.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BrandService {

    private final BrandRepository brandRepository;

    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    public Brand saveBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    public Optional<Brand> findById(Long id) {
        return brandRepository.findById(id);
    }

    public void deleteBrand(Long id) {
        brandRepository.deleteById(id);
    }
}
