package br.com.mondialgroup.marketinsights.service;

import br.com.mondialgroup.marketinsights.model.Marketplace;
import br.com.mondialgroup.marketinsights.model.HistoryPrice;
import br.com.mondialgroup.marketinsights.model.Product;
import br.com.mondialgroup.marketinsights.repository.HistoryPriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoryPriceService {

    private final HistoryPriceRepository priceRepository;
    private final ProductService productService;
    private final MarketplaceService marketplaceService;

    public HistoryPrice save(HistoryPrice price) {
        price.setProduct(this.findProduct(price.getProduct()));
        price.setMarketplace(this.findMarketplace(price.getMarketplace()));
        return priceRepository.save(price);
    }

    public List<HistoryPrice> findAll() {
        return priceRepository.findAll();
    }

    private Product findProduct(Product product) {
        Product productFound = productService.findById(product.getId()).orElse(null);
        return productFound;
    }

    private Marketplace findMarketplace(Marketplace marketplace) {
        Marketplace marketplaceFound = marketplaceService.findById(marketplace.getId()).orElse(null);
        return marketplaceFound;
    }
}
