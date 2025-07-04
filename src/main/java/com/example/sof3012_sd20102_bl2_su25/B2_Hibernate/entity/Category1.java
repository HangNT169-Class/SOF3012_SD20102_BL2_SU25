package com.example.sof3012_sd20102_bl2_su25.B2_Hibernate.entity;

// wildcard

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity // DANH DAU DAY LA THUC THE
@Table(name = "category") // Ten bang lay tu => SQL
@Builder
public class Category1 {

    // liet ke tat ca thuoc tinh
    @Id // Khoa chinh
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_code")
    private String categoryCode;

    @Column(name = "category_name")
    private String categoryName;

    // Ctrl Alt O => Fix import => Xoa thu vien thua
    // Ctrl Aly L => Format
    // Java 3: Truy van bang SQL Server
    // Java 4: Truy van bang HQL (Hibernate Query Language) => TRUY VAN TREN THUC THE (CLASS)
    // Hibernate: ORM (Object Relationship Mapping)

}
