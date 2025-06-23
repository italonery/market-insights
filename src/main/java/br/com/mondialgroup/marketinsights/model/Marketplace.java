package br.com.mondialgroup.marketinsights.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "marketplace")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Marketplace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "abbreviation", length = 6)
    private String abbreviation;

}
