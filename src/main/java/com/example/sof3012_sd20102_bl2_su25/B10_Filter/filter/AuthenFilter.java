package com.example.sof3012_sd20102_bl2_su25.B10_Filter.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "AuthenFilter", value = {
        // Liet ke cac duong dan can dang nhap
//        "/category/hien-thi", // GET => uri
//        "/category/detail", // GET
//        "/category/update", // POST
//        "/category/view-update",// GET
//        "/category/add", // POST
//        "/category/view-add", // GET
//        "/category/search", // GET
//        "/category/delete", // GET
        "/cagegory/*"
})
public class AuthenFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        // khoi tao 1 lan duy nhat khi web chay
    }

    public void destroy() {
        // Chay 1 lan duy nhat khi chuong trinh stop
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        // B1: Chuyen loai Servlet & Response ve HTTP
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        // B2: Check session
        HttpSession session = req.getSession();
        // B3:Check tai khoan
        if(session.getAttribute("uname") != null){
            // nhap roi => check dieu kien
            String username = (String) session.getAttribute("uname");
            // check tk
            if (username.equalsIgnoreCase("HangNT169") ||
                    username.equalsIgnoreCase("NguyenVV4")
            ) {
                // tk dung > quay ve trang category
                chain.doFilter(request, response);
            }else{
                res.sendRedirect("/login");
            }
        }else{
            // chua dang nhap => /login
            res.sendRedirect("/login");
        }
        // code => do filter
    }
}
