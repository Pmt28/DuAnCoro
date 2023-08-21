package com.example.duancore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "KhachHang")
public class KhachHang {
    @Id
    @Column(name = "maKH")
    private String maKH;

    @Column(name = "tenKH")
    private String tenKH;

    @Column(name = "ngaySinh")
    private Date ngaySinh;

    @Column(name = "gioiTinh")
    private String gioiTinh;

    @Column(name = "soDienThoai")
    private String soDienThoai;

    @Column(name = "diaChi")
    private String diaChi;

    @Column(name = "ngayTao")
    private Date ngayTao;

    @Column(name = "ngaySua")
    private Date ngaySua;

    @Column(name = "trangThai")
    private Integer trangThai;


    //Join bảng hóa đơn với giỏ hàng

    @OneToMany(mappedBy = "maKH", fetch = FetchType.LAZY)
    List<GioHang> gioHangList;

    @OneToMany(mappedBy = "maKH",fetch = FetchType.LAZY)
    List<HoaDon> hoaDonList;


}

