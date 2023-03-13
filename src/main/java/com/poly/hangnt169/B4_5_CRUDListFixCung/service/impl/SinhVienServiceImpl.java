package com.poly.hangnt169.B4_5_CRUDListFixCung.service.impl;

import com.poly.hangnt169.B4_5_CRUDListFixCung.entity.SinhVien;
import com.poly.hangnt169.B4_5_CRUDListFixCung.service.SinhVienService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hangnt169
 */
public class SinhVienServiceImpl implements SinhVienService {
    @Override
    public List<SinhVien> fakeData() {
        List<SinhVien> lists = new ArrayList<>();
        // code
        lists.add(new SinhVien("mss1","ten1",10,"Ha noi",false));
        return  lists;
    }
}
