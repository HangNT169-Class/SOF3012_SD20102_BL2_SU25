package com.example.sof3012_sd20102_bl2_su25.B2_Hibernate.servlet;

import com.example.sof3012_sd20102_bl2_su25.B2_Hibernate.service.CategoryService;
import com.example.sof3012_sd20102_bl2_su25.B2_Hibernate.service.ProductService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet",
        value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    private ProductService service = new ProductService();

    private CategoryService cateService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list",service.getAll());
        request.setAttribute("listCate",cateService.getAll());
        request.getRequestDispatcher("/buoi3/Product.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
