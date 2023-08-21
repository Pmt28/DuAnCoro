package com.example.duancore.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "HoaDonChiTiet")
public class HoaDonChiTiet {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @NotBlank(message = "Mã hóa đơn chi tiết không được để trống !")
    @Column(name = "maHDCT")
    private String maHDCT;

    @ManyToOne
    @JoinColumn(name = "maHD")
    private HoaDon maHD;

    @ManyToOne
    @JoinColumn(name = "maCTSP")
    private ChiTietSanPham mactsp;

    @Column(name = "soLuong")
    private int soLuong;

    @Column(name = "gia")
    private BigDecimal gia;

    @Column(name = "thanhTien")
    private BigDecimal thanhTien;

    @Column(name = "ghiChu")
    private String ghiChu;

    @Column(name = "donGia")
    private BigDecimal donGia;

    @Column(name = "ngayTao")
    private String ngayTao;

    @Column(name = "ngaySua")
    private String ngaySua;

    @Column(name = "trangThai")
    private int trangThai;

}
