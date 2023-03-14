package com.poly.hangnt169.B2_3_OverviewJavaWeb;
/**
 * @author hangnt169
 */

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "XuLyFormController", value = {"/login", "/ket-qua"})
public class XuLyFormController extends HttpServlet {
    // controller là tầng trung gian giao tiếp giữa client(view - jsp) với server
    // thông qua phương thức HTTPlý
    // Với Java 4,5 học 2 phương thức : GET, POST
    // GET: Hiển thi
    // POST : Xử
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Truyền giá trị từ servlet sang jsp
        request.setAttribute("t1", "Xin chao");
        // chuyen trang
        // chuyen trang
        request.getRequestDispatcher("login.jsp").forward(request, response);
//        response.sendRedirect("/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lay du lieu tu jsp(view)
        String username = request.getParameter("uname");
        String password = request.getParameter("psw");

        // Day du lieu tu servlet sang jsp
        request.setAttribute("u1", username);
        request.setAttribute("u2", password);

        // chuyen trang
        request.getRequestDispatcher("hien-thi.jsp").forward(request, response);
    }
}
