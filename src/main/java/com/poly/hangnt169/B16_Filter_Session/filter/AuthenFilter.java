package com.poly.hangnt169.B16_Filter_Session.filter;

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

/**
 * @author hangnt169
 */
//Liet ke tat ca duong dan cac ban muon check dang nhap
//@WebFilter({
//        "/sinh-vien/hien-thi", //GET
//        "/sinh-vien/search", //GET
//        "/sinh-vien/remove", //GET
//        "/sinh-vien/detail", // GET
//        "/sinh-vien/view-update", //GET
//        "/sinh-vien/view-add", //GET
//        "/sinh-vien/add", //POST
//        "/sinh-vien/update" //POST
//})
@WebFilter({"/sinh-vien/*","/CategoryServlet"})
public class AuthenFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        // Tat ca moi code viet trong doFilter
        // B1: Goi HTTPServlet , HTTPResponse
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        // B2: Goi session ra
        HttpSession session = req.getSession();
        // B3: Check quyen
        String user = (String) session.getAttribute("username1");
        // Neu chua dang nhap
        if (user == null) {
            res.sendRedirect("/Login");
        } else {
            // Neu da dang nhap => filter chay toi trang can thiet
            chain.doFilter(request, response);
        }
    }
}
