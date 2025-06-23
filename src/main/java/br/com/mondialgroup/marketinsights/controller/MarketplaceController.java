package br.com.mondialgroup.marketinsights.controller;

import br.com.mondialgroup.marketinsights.dto.request.MarketplaceRequest;
import br.com.mondialgroup.marketinsights.dto.response.MarketplaceResponse;
import br.com.mondialgroup.marketinsights.mapper.MarketplaceMapper;
import br.com.mondialgroup.marketinsights.model.Marketplace;
import br.com.mondialgroup.marketinsights.service.MarketplaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("marketplace")
@RequiredArgsConstructor
public class MarketplaceController {

    private final MarketplaceService marketplaceService;

    @GetMapping
    public ResponseEntity<List<MarketplaceResponse>> getAllMarketplaces() {
        List<MarketplaceResponse> marketplaces = marketplaceService.findAll()
                .stream()
                .map(MarketplaceMapper::toMarketplaceResponse)
                .toList();
        return ResponseEntity.ok(marketplaces);
    }

    @PostMapping
    public ResponseEntity<MarketplaceResponse> saveMarketplace(@RequestBody MarketplaceRequest request) {
        Marketplace newMarketplace = MarketplaceMapper.toMarketplace(request);
        Marketplace savedMarketplace = marketplaceService.saveMarketplace(newMarketplace);
        return ResponseEntity.status(HttpStatus.CREATED).body(MarketplaceMapper.toMarketplaceResponse(savedMarketplace));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarketplaceResponse> getMarketplaceById(@PathVariable Long id) {
        return marketplaceService.findById(id)
                .map(marketplace -> ResponseEntity.ok(MarketplaceMapper.toMarketplaceResponse(marketplace)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByMarketplaceId(@PathVariable Long id) {
        Marketplace marketplace = marketplaceService.findById(id).orElse(null);
        if (marketplace != null) {
            marketplaceService.deleteMarketplace(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.notFound().build();
    }
}
