package br.com.mondialgroup.marketinsights.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CategoryListRequest(@Valid List<@NotNull CategoryRequest> categories) {
}
