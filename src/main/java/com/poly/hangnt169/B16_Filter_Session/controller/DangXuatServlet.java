package com.poly.hangnt169.B16_Filter_Session.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @author hangnt169
 */
@WebServlet(name = "DangXuatServlet", value = "/dang-xuat1")
public class DangXuatServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Dang xuat => Xoa session
        // Co 2 cach xoa session
        HttpSession session = request.getSession();
        // C1: remove - Xoa Lan luot
//        session.removeAttribute("username1");
        // C2: invalidate => Xoa tat ca
        session.invalidate();
        // Sau khi xoa xong thi quay lai trang dang nhap
        response.sendRedirect("/Login");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
