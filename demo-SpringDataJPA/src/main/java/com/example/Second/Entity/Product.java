package com.example.Second.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name="products",
        schema = "ecommercedb",
uniqueConstraints = {
        @UniqueConstraint(
                name="sku_unique",
                columnNames="sku"
        )
})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "product_generator")
    @SequenceGenerator(name ="product_generator",
    sequenceName = "product_sequence_name",allocationSize = 1)
    private Long id;
  @Column(name="stock_keeping_unit",nullable = false)
    private  String sku;
  @Column(nullable = false)
    private String name;

    private String description;

    private BigDecimal price;



    private Boolean active;

    private String imageUrl;
  @CreationTimestamp
    private LocalDateTime dateCreated;
  @UpdateTimestamp
    private LocalDateTime lastUpdated;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
