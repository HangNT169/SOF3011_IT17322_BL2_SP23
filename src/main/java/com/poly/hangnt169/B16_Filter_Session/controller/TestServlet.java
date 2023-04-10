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
@WebServlet(name = "TestServlet", value = "/test")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Chay /login => Thanh cong => Hien thi username vua dang nhap
        // Chay /test => Hien thi username vua dang nhap
//        //B1: Lay gia tru jsp
//        String user1 = request.getParameter("uname");
//        // B2: Truyen gia tri nay jsp
//        request.setAttribute("u1", user1);
        // C2: Goi thong qua servlet
        HttpSession session = request.getSession();
        // Lay gia tri cua session
        String lists[] = (String[]) session.getAttribute("listString");
        String username = (String) session.getAttribute("username1");
        request.getRequestDispatcher("/buoi16/test.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
