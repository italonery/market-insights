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

    public List<Marketplace> findAll() {
        return marktplaceRepository.findAll();
    }

    public Marketplace saveMarketplace(Marketplace marketplace) {
        return marktplaceRepository.save(marketplace);
    }

    public Optional<Marketplace> findById(Long id) {
        return marktplaceRepository.findById(id);
    }

    public void deleteMarketplace(Long id) {
        marktplaceRepository.deleteById(id);
    }
}
