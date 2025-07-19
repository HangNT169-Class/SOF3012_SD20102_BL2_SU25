package com.example.sof3012_sd20102_bl2_su25.B2_Hibernate.repository;


import com.example.sof3012_sd20102_bl2_su25.B2_Hibernate.entity.Category1;
import com.example.sof3012_sd20102_bl2_su25.B2_Hibernate.util.HibernateUtil;
import jakarta.persistence.Query;
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
    public void addCate(Category1 cate) {
        // Transation => Dam bao tinh toan ven
        try {
            // B1: Lay ra & bat dau 1 transation
            s.getTransaction().begin();
            // B2: Them phan tu
            s.persist(cate);
            // B3: Commit
            s.getTransaction().commit();
        } catch (Exception e) {
            // loi
            e.printStackTrace();
            s.getTransaction().rollback();
        }
    }

    public void updateCate(Category1 cate) {
        // Transation => Dam bao tinh toan ven
        try {
            // B1: Lay ra & bat dau 1 transation
            s.getTransaction().begin();
            // B2: Them phan tu
            s.merge(cate);
            // B3: Commit
            s.getTransaction().commit();
        } catch (Exception e) {
            // loi
            e.printStackTrace();
            s.getTransaction().rollback();
        }
    }

    public void deleteCate(Category1 cate) {
        // Transation => Dam bao tinh toan ven
        try {
            // B1: Lay ra & bat dau 1 transation
            s.getTransaction().begin();
            // B2: Them phan tu
            s.delete(cate);
            // B3: Commit
            s.getTransaction().commit();
        } catch (Exception e) {
            // loi
            e.printStackTrace();
            s.getTransaction().rollback();
        }
    }

    // Search
    public List<Category1> searchByName(String name) {
        // B1: Viet HQL : ? phai kem vi tri : ?1, ?2..
        String hql = "SELECT cate FROM Category1 cate WHERE cate.categoryName = ?1";
        // B2: Tao cau query: import jakatar
        Query q = s.createQuery(hql, Category1.class);
        // B3: Set gia tri cho dau ?
        q.setParameter(1, name);
        // B4: return list
        return q.getResultList();
        // Neu cau query tra ra nhieu dong => getResultList
        // Cau query tra ra 1 dong  => getSingleResult
    }

    // Search:
    // 1. Tim kiem danh sach category trong khoang gia tri id
    // 2. Tim kiem 1 category theo ID (khong dung cach cua ham getOne)
    // 3. Sap xep danh sach category tang dan theo ten
    public List<Category1> searchById(Long min, Long max) {
        String hql = "select c from Category1 c where c.id <= ?1 AND c.id >= ?2";
        Query q = s.createQuery(hql, Category1.class);
        q.setParameter(1, max);
        q.setParameter(2, min);
        return q.getResultList();
    }

    public Category1 getOne2(Long id){
        String hql="select  cate from Category1  cate where cate.id =?1";
        Query q=s.createQuery(hql,Category1.class);
        q.setParameter(1,id);
        return (Category1) q.getSingleResult();
    }
    public List<Category1> sapxep(){
        String hql ="SELECT c from Category1 c order by c.categoryName";
        Query q = s.createQuery(hql, Category1.class);
        return q.getResultList();
    }
    // Phan trang: SQL
    // mySQL: limit & offset
    // sql server: offset & fetch next

    public List<Category1>phanTrangC1Sql(int pageNo, int pageSize){
        // B1: Tinh offset
        int offset = pageNo * pageSize;
        String sql ="SELECT *  " +
                "FROM category " +
                "ORDER BY id  " +
                "OFFSET ?1 ROWS " +
                "FETCH NEXT ?2 ROW ONLY";
        // HQL => createQuery
        // SQL => createNativeQuery
        Query q = s.createNativeQuery(sql,Category1.class);
        q.setParameter(1,offset);
        q.setParameter(2,pageSize);
        return q.getResultList();
    }

    public List<Category1>phanTrangC2Hql(int pageNo, int pageSize){
        Query q = s.createQuery("FROM Category1 ");
        q.setFirstResult((pageNo-1) * pageSize);
        q.setMaxResults(pageSize);
        return q.getResultList();
    }

    public static void main(String[] args) {
        // pageNo = 0
        System.out.println(new CategoryRepository().phanTrangC2Hql(1,5));
//        System.out.println(new CategoryRepository().getOne2(1L));
       // System.out.println(new CategoryRepository().searchById(3L,10003L));
//        System.out.println(new CategoryRepository().searchByName("fdsaf"));
//        System.out.println(new CategoryRepository().getAll());
//        System.out.println(new CategoryRepository().getOne(1L));
//        Category1 cate = new Category1(null,"Catecode","bnam")
        // Builder
//        Category1 cate = Category1.builder()
//                .categoryCode("ghfgnh")
//                .categoryName("fdsaf")
//                .build();
//        new CategoryRepository().addCate(cate);
    }

}
