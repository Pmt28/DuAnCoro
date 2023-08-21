package com.example.duancore.entity;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.ConditionalOnEnabledResourceChain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class ChatLieu implements Serializable {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private String maCL;

      private String ten;
      private Date ngayTao;
      private Date ngaySua;
      private int trangThai;

    public ChatLieu() {
    }

    public ChatLieu(String maCL, String ten, Date ngayTao, Date ngaySua, int trangThai) {
        this.maCL = maCL;
        this.ten = ten;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public String getMaCL() {
        return maCL;
    }

    public void setMaCL(String maCL) {
        this.maCL = maCL;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Date ngaySua) {
        this.ngaySua = ngaySua;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @OneToMany(mappedBy = "chatlieu", fetch = FetchType.LAZY)
    private List<ChiTietSanPham> chiTietSanPhamList;

}