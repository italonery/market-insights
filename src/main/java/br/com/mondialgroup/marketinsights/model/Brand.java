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
@Table(name = "brand")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

//    @CreationTimestamp
    @CreatedDate
    @Column(name = "created_on", updatable = false)
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
