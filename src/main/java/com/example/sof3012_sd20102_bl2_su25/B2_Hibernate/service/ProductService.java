package com.example.sof3012_sd20102_bl2_su25.B2_Hibernate.service;

import com.example.sof3012_sd20102_bl2_su25.B2_Hibernate.entity.Product;
import com.example.sof3012_sd20102_bl2_su25.B2_Hibernate.repository.ProductRepository;

import java.util.List;

public class ProductService {

    private ProductRepository repo = new ProductRepository();

    public List<Product> getAll(){
        return repo.getAll();
    }

}
