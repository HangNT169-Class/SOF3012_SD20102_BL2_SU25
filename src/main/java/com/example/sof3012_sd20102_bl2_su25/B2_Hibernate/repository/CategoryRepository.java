package com.example.sof3012_sd20102_bl2_su25.B2_Hibernate.repository;


import com.example.sof3012_sd20102_bl2_su25.B2_Hibernate.entity.Category1;
import com.example.sof3012_sd20102_bl2_su25.B2_Hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class CategoryRepository {
    // J3: Connection
    // J4: Session
    private Session s;

    public CategoryRepository() {
        // Mo phien session => 1 lan duy nhat
        s = HibernateUtil.getFACTORY().openSession();
        // Connnection c = DBConnection.getConnection()
    }

    public List<Category1> getAll() {
        return s.createQuery("FROM Category1 ").list();
    }

    // Full CRUD
    // getOne => Lay ra 1
    public Category1 getOne(Long id) {
        return s.find(Category1.class, id);
    }

    // Them/Sua/Xoa
    public void addCate(Category1 cate){
        // Transation => Dam bao tinh toan ven
        try{
            // B1: Lay ra & bat dau 1 transation
            s.getTransaction().begin();
            // B2: Them phan tu
            s.persist(cate);
            // B3: Commit
            s.getTransaction().commit();
        }catch (Exception e){
            // loi
            e.printStackTrace();
            s.getTransaction().rollback();
        }
    }
    public void updateCate(Category1 cate){
        // Transation => Dam bao tinh toan ven
        try{
            // B1: Lay ra & bat dau 1 transation
            s.getTransaction().begin();
            // B2: Them phan tu
            s.merge(cate);
            // B3: Commit
            s.getTransaction().commit();
        }catch (Exception e){
            // loi
            e.printStackTrace();
            s.getTransaction().rollback();
        }
    }
    public void deleteCate(Category1 cate){
        // Transation => Dam bao tinh toan ven
        try{
            // B1: Lay ra & bat dau 1 transation
            s.getTransaction().begin();
            // B2: Them phan tu
            s.delete(cate);
            // B3: Commit
            s.getTransaction().commit();
        }catch (Exception e){
            // loi
            e.printStackTrace();
            s.getTransaction().rollback();
        }
    }

    public static void main(String[] args) {
//        System.out.println(new CategoryRepository().getAll());
//        System.out.println(new CategoryRepository().getOne(1L));
//        Category1 cate = new Category1(null,"Catecode","bnam")
        // Builder
        Category1 cate = Category1.builder()
                .categoryCode("ghfgnh")
                .categoryName("fdsaf")
                .build();
        new CategoryRepository().addCate(cate);
    }

}
