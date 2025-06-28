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

    public Brand save(Brand brand) {
        return brandRepository.save(brand);
    }

    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    public Optional<Brand> findById(Long id) {
        return brandRepository.findById(id);
    }

    public void delete(Long id) {
        brandRepository.deleteById(id);
    }
}
