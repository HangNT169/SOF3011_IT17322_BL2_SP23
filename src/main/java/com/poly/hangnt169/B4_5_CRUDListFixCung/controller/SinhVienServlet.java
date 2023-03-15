package com.poly.hangnt169.B4_5_CRUDListFixCung.controller;
/**
 * @author hangnt169
 */

import com.poly.hangnt169.B4_5_CRUDListFixCung.entity.SinhVien;
import com.poly.hangnt169.B4_5_CRUDListFixCung.service.SinhVienService;
import com.poly.hangnt169.B4_5_CRUDListFixCung.service.impl.SinhVienServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SinhVienController", value = {
        "/sinh-vien/hien-thi", //GET
        "/sinh-vien/search", //GET
        "/sinh-vien/remove", //GET
        "/sinh-vien/detail", // GET
        "/sinh-vien/view-update", //GET
        "/sinh-vien/view-add", //GET
        "/sinh-vien/add", //POST
        "/sinh-vien/update" //POST
})
public class SinhVienServlet extends HttpServlet {

    private List<SinhVien>sinhViens = new ArrayList<>();
    private SinhVienService service = new SinhVienServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lay ra duong dan tren trinh duyet
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            // hien thi du lieu
            this.hienThiSinhVien(request, response);
        } else if (uri.contains("search")) {
            // search du lieu
            this.searchSinhVien(request, response);
        } else if (uri.contains("remove")) {
            // Remove du lieu
            this.removeSinhVien(request, response);
        } else if (uri.contains("detail")) {
            // detail du lieu
            this.detailSinhVien(request, response);
        } else if (uri.contains("view-add")) {
            // hien thi form add
            this.viewAddSinhVien(request, response);
        } else if (uri.contains("view-update")) {
            // hien thi form update
            this.viewUpdateSinhVien(request, response);
        } else {
            // neu khong vao cac case tren thi quay lai trang hien thi
            this.hienThiSinhVien(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI(); // Lay duoc gia tri o tren duong dan
        if (uri.contains("add")) {
            // hien thi du lieu
            this.addSinhVien(request, response);
        } else if (uri.contains("update")) {
            // search du lieu
            this.updateSinhVien(request, response);
        } else {
            // neu khong vao cac case tren thi quay lai trang hien thi
            this.hienThiSinhVien(request, response);
        }
    }

    private void updateSinhVien(HttpServletRequest request, HttpServletResponse response) {
    }

    private void addSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // B1: Lay du lieu tu form
        String mssv = request.getParameter("mssv");
        String ten = request.getParameter("ten");
        String tuoi = request.getParameter("tuoi");
        String diaChi = request.getParameter("diaChi");
        String gioiTinhStr = request.getParameter("gioiTinh");

        // B2: Khoi tao doi tuong
//        SinhVien sv = new SinhVien(mssv,ten,Integer.valueOf(tuoi),diaChi,Boolean.valueOf(gioiTinh));
        SinhVien sv = SinhVien.builder()
                .gioiTinh(Boolean.valueOf(gioiTinhStr))
                .mssv(mssv)
                .diaChi(diaChi)
                .ten(ten)
                .tuoi(Integer.valueOf(tuoi))
                .build();
        // B3: Add vao list
        service.addSinhVien(sinhViens,sv);

        // B4: Set gia tri va chuyen trang
        request.setAttribute("listSV",sinhViens);
        request.getRequestDispatcher("/buoi4/sinhviens.jsp").forward(request,response);
    }

    private void viewUpdateSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lay du lieu jsp ve servlet
        String viTri = request.getParameter("id");
        SinhVien sv = service.getOne(sinhViens,Integer.parseInt(viTri));
        request.setAttribute("sinhVien",sv);
        request.getRequestDispatcher("/buoi4/update-sinh-vien.jsp").forward(request,response);
    }

    private void viewAddSinhVien(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/buoi4/add-sinh-vien.jsp");
    }

    private void detailSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lay du lieu jsp ve servlet
        String viTri = request.getParameter("id");
        SinhVien sv = service.getOne(sinhViens,Integer.parseInt(viTri));
        request.setAttribute("sinhVien",sv);
        request.getRequestDispatcher("/buoi4/detail-sinh-vien.jsp").forward(request,response);
    }

    private void removeSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lay du lieu jsp ve servlet
        String viTri = request.getParameter("id1");
        service.removeSinhVien(sinhViens,Integer.valueOf(viTri));
        // C1: Copy past ham hien thi
//        if(sinhViens.isEmpty()){
//            sinhViens = service.fakeData();
//        }
//        request.setAttribute("listSV",sinhViens);
//        request.getRequestDispatcher("/buoi4/sinhviens.jsp").forward(request,response);
        // C2: Goi lai ham hien thi
//        this.hienThiSinhVien(request,response);
        // C3: Send direct
        response.sendRedirect("/sinh-vien/hien-thi");
    }

    private void searchSinhVien(HttpServletRequest request, HttpServletResponse response) {
    }

    private void hienThiSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // fakedata
        if(sinhViens.isEmpty()){
            sinhViens = service.fakeData();
        }
        request.setAttribute("listSV",sinhViens);
        request.getRequestDispatcher("/buoi4/sinhviens.jsp").forward(request,response);
    }
}
