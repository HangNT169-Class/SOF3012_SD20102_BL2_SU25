package com.example.sof3012_sd20102_bl2_su25.B2_Hibernate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="product")
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_code")
    private String productCode;

    @Column(name="product_name")
    private String productName;

    @Column(name = "price")
    private Float price;

    @Column(name = "description")
    private String description;

    // 1 product => 1 category
    // 1 category => N product
    // N-1: @ManyToOne
    // 1-N: @OneToMany
    // N-N: @ManyToMany

    // Khoa ngoai
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category1 cate;

}
