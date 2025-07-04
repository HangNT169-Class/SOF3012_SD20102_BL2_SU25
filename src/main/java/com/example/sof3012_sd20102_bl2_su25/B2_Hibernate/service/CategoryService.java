package com.example.sof3012_sd20102_bl2_su25.B2_Hibernate.service;

import com.example.sof3012_sd20102_bl2_su25.B2_Hibernate.entity.Category1;
import com.example.sof3012_sd20102_bl2_su25.B2_Hibernate.repository.CategoryRepository;

import java.util.List;

public class CategoryService {

    private CategoryRepository cateRepository = new CategoryRepository();

    // Viet cac ham
    // logic => toan bo project
    public List<Category1> getAll() {
        return cateRepository.getAll();
    }

    public Category1 getOne(Long id) {
        return cateRepository.getOne(id);
    }

    public void addCate(Category1 cate) {
        cateRepository.addCate(cate);
    }

    public void updateCate(Category1 cate) {
        cateRepository.updateCate(cate);
    }

    public void deleteCate(Long id) {
        cateRepository.deleteCate(getOne(id));
    }

}
