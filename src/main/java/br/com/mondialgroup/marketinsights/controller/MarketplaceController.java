package br.com.mondialgroup.marketinsights.controller;

import br.com.mondialgroup.marketinsights.dto.request.MarketplaceRequest;
import br.com.mondialgroup.marketinsights.dto.response.MarketplaceResponse;
import br.com.mondialgroup.marketinsights.mapper.MarketplaceMapper;
import br.com.mondialgroup.marketinsights.model.Marketplace;
import br.com.mondialgroup.marketinsights.service.MarketplaceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/marketplaces")
@RequiredArgsConstructor
public class MarketplaceController {

    private final MarketplaceService marketplaceService;

    @PostMapping
    public ResponseEntity<MarketplaceResponse> saveMarketplace(@Valid @RequestBody MarketplaceRequest request) {
        Marketplace newMarketplace = MarketplaceMapper.toMarketplace(request);
        Marketplace savedMarketplace = marketplaceService.save(newMarketplace);
        return ResponseEntity.status(HttpStatus.CREATED).body(MarketplaceMapper.toMarketplaceResponse(savedMarketplace));
    }

    @GetMapping
    public ResponseEntity<List<MarketplaceResponse>> getAllMarketplaces() {
        List<MarketplaceResponse> marketplaces = marketplaceService.findAll()
                .stream()
                .map(MarketplaceMapper::toMarketplaceResponse)
                .toList();
        return ResponseEntity.ok(marketplaces);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarketplaceResponse> getByMarketplaceId(@PathVariable Long id) {
        return marketplaceService.findById(id)
                .map(marketplace -> ResponseEntity.ok(MarketplaceMapper.toMarketplaceResponse(marketplace)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByMarketplaceId(@PathVariable Long id) {
        Marketplace marketplace = marketplaceService.findById(id).orElse(null);
        if (marketplace != null) {
            marketplaceService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.notFound().build();
    }
}
