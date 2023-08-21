package com.example.duancore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "HinhThucThanhToan")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class HinhThucThanhToan {
    @Id
    @Column(name = "maHTTT")
    private String maHTTT;

    @Column(name = "tenHTTT")
    private String tenHTTT;

    @Column(name = "ngayTao")
    private Date ngayTao;

    @Column(name = "ngaySua")
    private Date ngaySua;

    @Column(name = "trangThai")
    private String trangThai;

    @OneToMany(mappedBy = "maHTTT", fetch = FetchType.LAZY)
    List<HoaDon> hoaDonList;





}
