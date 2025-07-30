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
        "/category/*",
        "/ProductServlet"
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
                // neu la role Admin => truy cap tat ca cac duong dan
                // Neu la role nhan vien => chi truy cap vao cac duong danh cua category
                // con cac duong dan khac k truy cap => 403
                // tk dung > quay ve trang category
//                chain.doFilter(request, response);
                String role = (String) session.getAttribute("role1");
                if(role.equalsIgnoreCase("Admin")){
                    chain.doFilter(request, response);
                }else {
                    // Check uri
                    String uri = req.getRequestURI();
                    if(uri.contains("/category/")){
                        // duoc phep truy cap
                        chain.doFilter(request, response);
                    }
                    // De bao co bn duong dan duoc truy cap cua role Nhan vien
                    // thi bang day else o giua
                    else{
                        // loi 403
                        res.sendRedirect("/buoi10/403-page.jsp");
                    }
                }
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
