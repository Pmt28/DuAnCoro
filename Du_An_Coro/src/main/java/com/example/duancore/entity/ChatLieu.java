package com.example.duancore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "ChatLieu")
public class ChatLieu implements Serializable {

      @Id
      private String maCL;

      private String ten;
      private String ngayTao;
      private String ngaySua;
      private int trangThai;


}
