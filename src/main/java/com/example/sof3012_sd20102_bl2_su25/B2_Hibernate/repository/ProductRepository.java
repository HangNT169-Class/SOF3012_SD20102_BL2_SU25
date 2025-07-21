package com.example.sof3012_sd20102_bl2_su25.B2_Hibernate.repository;

import com.example.sof3012_sd20102_bl2_su25.B2_Hibernate.entity.Product;
import com.example.sof3012_sd20102_bl2_su25.B2_Hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class ProductRepository {
    private Session s;

    public ProductRepository() {
        s = HibernateUtil.getFACTORY().openSession();
    }

    public List<Product> getAll(){
        return s.createQuery("FROM Product ").list();
    }

    public static void main(String[] args) {
        System.out.println(new ProductRepository().getAll());
    }
}
