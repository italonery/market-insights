package br.com.mondialgroup.marketinsights.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "sku", length = 50, unique = true, nullable = false)
    private String sku;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(name = "feature1", length = 200)
    private String feature1;

    @Column(name = "feature2", length = 200)
    private String feature2;

    @Column(name = "feature3", length = 200)
    private String feature3;

    @CreationTimestamp
    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @UpdateTimestamp
    @Column(name = "modified_on")
    private LocalDateTime modifiedOn;
}
