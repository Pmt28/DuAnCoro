package com.example.duancore.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "SanPham")
public class SanPham {

    @Id
    @NotBlank(message = "Vui lòng nhập mã sản phẩm")
    @Column(name = "maSP")
    private String masp;

    @NotBlank(message = "Vui lòng nhập tên sản phẩm")
    @Column(name = "tenSP")
    private String tensp;

    @Column(name = "ngayTao")
    private String ngaytao;

    @Column(name = "ngaySua")
    private String ngaysua;

    @Column(name = "trangThai")
    private int trangthai;


    public SanPham() {
    }

    public SanPham(@NotBlank(message = "Vui lòng nhập mã sản phẩm") String masp, @NotBlank(message = "Vui lòng nhập tên sản phẩm") String tensp, String ngaytao, String ngaysua, int trangthai) {
        this.masp = masp;
        this.tensp = tensp;
        this.ngaytao = ngaytao;
        this.ngaysua = ngaysua;
        this.trangthai = trangthai;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }


    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(String ngaytao) {
        this.ngaytao = ngaytao;
    }

    public String getNgaysua() {
        return ngaysua;
    }

    public void setNgaysua(String ngaysua) {
        this.ngaysua = ngaysua;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    @OneToMany(mappedBy = "sanpham", fetch = FetchType.LAZY)
    private List<ChiTietSanPham> chiTietSanPhamList;

    public SanPham(List<ChiTietSanPham> chiTietSanPhamList) {
        this.chiTietSanPhamList = chiTietSanPhamList;
    }

    public List<ChiTietSanPham> getChiTietSanPhamList() {
        return chiTietSanPhamList;
    }

    public void setChiTietSanPhamList(List<ChiTietSanPham> chiTietSanPhamList) {
        this.chiTietSanPhamList = chiTietSanPhamList;
    }
}
