package com.example.sof3012_sd20102_bl2_su25.B11_Ajax.servlet;

import com.example.sof3012_sd20102_bl2_su25.B11_Ajax.entity.SinhVien;
import com.google.gson.Gson;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SinhVienServlet", value = "/api/sinh-vien")
public class SinhVienServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // B1: Fake data
        SinhVien sv = new SinhVien("SV01","Sinh vien 1","Ha noi",10,"Ky thuat phan mem");
//        List<SinhVien>lists = new ArrayList<>();
//        lists.add(sv);
        // B2: Covert object/array ve json
        Gson gson = new Gson();
        String data = gson.toJson(sv);
        // B3: Set content type => application/json
        response.setContentType("application/json");
        // B4: Tuy co the co - Hien thi len giao dien
        PrintWriter out = response.getWriter();
        out.println(data);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
