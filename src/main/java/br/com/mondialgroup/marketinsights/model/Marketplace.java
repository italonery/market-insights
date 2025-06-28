package br.com.mondialgroup.marketinsights.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
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

//    @CreationTimestamp
    @CreatedDate
    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @CreatedBy
    @Column(name = "created_by",length = 50)
    private String createdBy;

//    @UpdateTimestamp
    @LastModifiedDate
    @Column(name = "modified_on")
    private LocalDateTime modifiedOn;

    @LastModifiedBy
    @Column(name = "modified_by", length = 50)
    private String modifiedBy;

}
