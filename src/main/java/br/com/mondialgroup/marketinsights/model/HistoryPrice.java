package br.com.mondialgroup.marketinsights.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "hstprice")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class HistoryPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "marketplace_id", nullable = false)
    private Marketplace marketplace;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "date_ref", nullable = false)
    private Date dateRef;
}
