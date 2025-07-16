package com.example.sof3012_sd20102_bl2_su25.B2_Hibernate.servlet;

import com.example.sof3012_sd20102_bl2_su25.B2_Hibernate.entity.Category1;
import com.example.sof3012_sd20102_bl2_su25.B2_Hibernate.service.CategoryService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

// Value => Duong danh web
@WebServlet(value = {
        // Duong dan bat dau bang dau /
        // Duong dan la duy nhat trong toan bo project
        // url & uri
        "/category/hien-thi", // GET => uri
        "/category/detail", // GET
        "/category/update", // POST
        "/category/view-update",// GET
        "/category/add", // POST
        "/category/view-add", // GET
        "/category/search", // GET
        "/category/delete", // GET
})
public class CategoryServlet extends HttpServlet {

    private CategoryService cateService = new CategoryService();
    // java => server
    // giao dien => client
    // http method: J4, J5: Get & Post
    // Get => hien thi hoac lay ra
    // Post => Form : Xu ly form(che giau tt)

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 6 noi dung cua duong dan
        // B1: Lay ra uri cua duong
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            // hien thi
            this.hienThiDuLieu(request, response);
        } else if (uri.contains("detail")) {
            // detail
            this.detailCate(request, response);
        } else if (uri.contains("view-update")) {
            // view - update
            this.viewUpdateCate(request, response);
        } else if (uri.contains("view-add")) {
            // view-add
            this.viewAddCate(request, response);
        } else if (uri.contains("delete")) {
            // delete
            this.deleteCate(request, response);
        } else {
            // search
            this.searchCate(request, response);
        }
        // liet ke tat ca vao day
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 2 noi dung
        String uri = request.getRequestURI();
        if (uri.contains("update")) {
            // update
            this.updateCate(request, response);
        } else {
            // add
            this.addCate(request, response);
        }
    }

    private void addCate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void updateCate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void detailCate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewUpdateCate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewAddCate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void deleteCate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void searchCate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void hienThiDuLieu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // B1: Goi ham getAll => service
        List<Category1>listCate = cateService.getAll();
        // B2: Day du lieu tu servlet => jsp: setAttribute(ts1, ts2)
        // ts1: ten minh dat => jsp dung
        // ts2: gia tri cua bien
//        int a = 5;
        request.setAttribute("test",listCate);
        //B3:Chuyen trang : getRequestDispatcher
        request.getRequestDispatcher("/buoi3/categorys.jsp").forward(request,response);
    }
}
