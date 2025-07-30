package com.example.sof3012_sd20102_bl2_su25.B10_Filter.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/buoi10/login-form.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // B1: Lay tt tren form => getParameter
        String username = request.getParameter("uname1");
        String pass = request.getParameter("pass");
        HttpSession session = request.getSession();
        session.setAttribute("uname",username); // set name cho session
        // B2: Check validate
        if(
                (username.equalsIgnoreCase("HangNT169") && pass.equals("123456"))
                        || (username.equalsIgnoreCase("NguyenVV4") && pass.equals("1234567"))
        ){
//            // truy cap vao trang web "/category/hien-thi
//            response.sendRedirect("/category/hien-thi");
            // them role => author
            // Admin => Hang
            // Nhan vien => Nguyen
            if(username.equalsIgnoreCase("HangNT169")){
                session.setAttribute("role1","Admin");
            }else{
                session.setAttribute("role1","NhanVien");
            }

            response.sendRedirect("/category/hien-thi");
        }else{
            // loi
            request.setAttribute("error","Dang nhap that bai");
            request.getRequestDispatcher("/buoi10/login-form.jsp").forward(request,response);
        }

    }
}
