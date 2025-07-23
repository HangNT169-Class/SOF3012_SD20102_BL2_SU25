package com.example.sof3012_sd20102_bl2_su25.B8_Scope;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "TestServlet", value = "/TestServlet")
public class TestServlet extends HttpServlet {
    // Scope : Pham vi truy cap cua bien tren web
    // public, protected, default, private => bien/ham trong code Java
    // application, session, request, page => danh cho moi req gui di

    /**
     * Cu phap chung cua scope:
     * - Servlet:
     *      + (loai servlet).setAttribute(gt1,gt2)
     * VD: request.setAttribute(..,...)
     * - JSP:
     *      + (loai servlet)Scope."ten"
     * VD: requestScope.ten
     * page: chi co gia tri tai 1 file jsp dung no.
     * Khong co gt o servlet
     * application : giong session
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Session
        // B1: Goi session
        HttpSession s = request.getSession();
        s.setAttribute("session1","Hello Scope Session");
        // timeout: default - 30 phut
        // muon cau hinh => web.xml
        request.setAttribute("test","Hello Scope Request");
        request.getRequestDispatcher("/buoi9/test.jsp").forward(request,response);
        // servlet 1 => gia tri => jsp 1
        // servlet 2 & jsp 2
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
