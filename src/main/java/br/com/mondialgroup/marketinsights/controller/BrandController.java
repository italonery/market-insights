package br.com.mondialgroup.marketinsights.controller;

import br.com.mondialgroup.marketinsights.dto.request.BrandResquest;
import br.com.mondialgroup.marketinsights.dto.response.BrandResponse;
import br.com.mondialgroup.marketinsights.mapper.BrandMapper;
import br.com.mondialgroup.marketinsights.model.Brand;
import br.com.mondialgroup.marketinsights.service.BrandService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/brands")
@RequiredArgsConstructor
@Tag(name = "Brands", description = "Recurso responsável pelo gerenciamento de Marcas")
public class BrandController {

    private final BrandService brandService;

    @Operation(
            summary = "Criar Marca",
            description = "Método responsável por criar uma nova Marca",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @ApiResponse(
            responseCode = "201",
            description = "Marca criada",
            content = @Content(schema = @Schema(implementation = BrandResponse.class))
    )
    @PostMapping
    public ResponseEntity<BrandResponse> saveBrand(@Valid @RequestBody BrandResquest request) {
        Brand newBrand = BrandMapper.toBrand(request);
        Brand savedBrand = brandService.save(newBrand);
        return ResponseEntity.status(HttpStatus.CREATED).body(BrandMapper.toBrandResponse(savedBrand));
    }

    @Operation(
            summary = "Listar Marcas",
            description = "Método responsável por listar todas as Marcas",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @ApiResponse(
            responseCode = "200",
            description = "Todas as Marcas",
            content = @Content(schema = @Schema(implementation = BrandResponse.class))
    )
    @GetMapping
    public ResponseEntity<List<BrandResponse>> getAllBrands() {
        List<BrandResponse> brands = brandService.findAll()
                .stream()
                .map(BrandMapper::toBrandResponse)
                .toList();
        return ResponseEntity.ok(brands);
    }

    @Operation(
            summary = "Listar Marca por ID",
            description = "Método responsável por listar Marca por ID",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @ApiResponse(
            responseCode = "200",
            description = "Marca",
            content = @Content(schema = @Schema(implementation = BrandResponse.class))
    )
    @GetMapping("/{id}")
    public ResponseEntity<BrandResponse> getByBrandId(@PathVariable Long id) {
        return brandService.findById(id)
                .map(brand -> ResponseEntity.ok(BrandMapper.toBrandResponse(brand)))
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(
            summary = "Deletar Marca",
            description = "Método responsável por deletar uma Marca",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @ApiResponse(
            responseCode = "204",
            description = "Marca deletada"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByBrandId(@PathVariable Long id) {
        Brand brand = brandService.findById(id).orElse(null);
        if (brand != null) {
            brandService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.notFound().build();
    }
}
