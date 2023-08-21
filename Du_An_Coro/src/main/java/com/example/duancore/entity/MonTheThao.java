package com.example.duancore.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "monthethao")
public class MonTheThao implements Serializable {

    @Id
    @NotEmpty(message = "dien ma mon the thao")
    private String mamtt;

    @NotEmpty(message = "dien ten mon the thao")
    private String ten;

    private String ngaytao;
    private String ngaysua;
    private int trangthai;

    @OneToMany(mappedBy = "monthethao", fetch = FetchType.LAZY)
    private List<ChiTietSanPham> chiTietSanPhamList;

    public MonTheThao(List<ChiTietSanPham> chiTietSanPhamList) {
        this.chiTietSanPhamList = chiTietSanPhamList;
    }

    public List<ChiTietSanPham> getChiTietSanPhamList() {
        return chiTietSanPhamList;
    }

    public void setChiTietSanPhamList(List<ChiTietSanPham> chiTietSanPhamList) {
        this.chiTietSanPhamList = chiTietSanPhamList;
    }
}
