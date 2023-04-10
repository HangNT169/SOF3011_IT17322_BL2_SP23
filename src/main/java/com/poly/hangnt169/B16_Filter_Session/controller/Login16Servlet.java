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
@WebServlet(name = "Login16Servlet", value = "/Login")
public class Login16Servlet extends HttpServlet {

    /*
     * Dang nhap voi tai khoan PhongTT35 vs mk 123456
     * => Dang nhap thanh cong => chuyen vao trang ket-qua.jsp.
     * Va trong trong ket qua .jsp => Hien thi ten user vua dang nhap
     * => Dang nhap that bai => quay trang lai trang dang nhap va hien thi loi "Tai khoan hoac mat khau sai"
     */
    /*
     * Khi đăng nhập thành công => Chạy được nội dung trang "/sinh-vien/hien-thi".
     * Nếu chưa đăng nhập mà ấn "/sinh-vien/hien-thi" => Bắt quay trở lại đăng nhập
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String abc[] = {"abc", "qưe", "rtyu", "apds"};
        request.setAttribute("demo", abc);
        HttpSession session = request.getSession();
        session.setAttribute("listString", abc);
        request.getRequestDispatcher("/buoi16/buoi16_login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("uname");
        String pass = request.getParameter("psw");
        // Co 4 loai bien :
        // request : <=>scope (Angular JS): Chỉ có giá trị trong file jsp mà nó được gọi sang
        // session: <=> rootScope (Angular JS): Có giá trị trong toàn project (Cùng hoặc Khác jsp/servlet đều được)
        // page:
        // application:
        if (user.equalsIgnoreCase("PhongTT35") && pass.equals("123456")) {
            // B1: Tao ra 1 doi tuong session
            HttpSession session = request.getSession();
            // B2: Set gia tri cho session
            session.setAttribute("username1", user);
//            request.setAttribute("username", user);
            request.getRequestDispatcher("/buoi16/ket-qua.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "Tai khoan hoac mat khau sai");
            request.getRequestDispatcher("/buoi16/buoi16_login.jsp").forward(request, response);
        }
    }
}
