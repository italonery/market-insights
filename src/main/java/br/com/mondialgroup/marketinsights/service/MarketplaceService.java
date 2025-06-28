package br.com.mondialgroup.marketinsights.service;

import br.com.mondialgroup.marketinsights.model.Marketplace;
import br.com.mondialgroup.marketinsights.repository.MarktplaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MarketplaceService {

    private final MarktplaceRepository marktplaceRepository;

    public Marketplace save(Marketplace marketplace) {
        return marktplaceRepository.save(marketplace);
    }

    public List<Marketplace> findAll() {
        return marktplaceRepository.findAll();
    }

    public Optional<Marketplace> findById(Long id) {
        return marktplaceRepository.findById(id);
    }

    public void delete(Long id) {
        marktplaceRepository.deleteById(id);
    }
}
