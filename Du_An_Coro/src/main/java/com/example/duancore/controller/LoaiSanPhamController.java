package com.example.duancore.controller;


import com.example.duancore.entity.LoaiSanPham;
import com.example.duancore.service.LoaiSanPhamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class LoaiSanPhamController {
    @Autowired
    private LoaiSanPhamService  loaiSanPhamService;

    @GetMapping("/loai-san-pham/hien-thi")
    public String hienThiLoaiSP(@RequestParam(name = "page",defaultValue = "0") Integer pageNo, Model model) {

        Page<LoaiSanPham> page = loaiSanPhamService.findPage(pageNo,3);
        model.addAttribute("loaiSP",page.getContent());
        model.addAttribute("currentPage",page.getNumber());
        model.addAttribute("totalPages",page.getTotalPages());

        model.addAttribute("lsp", new LoaiSanPham());
        return "/loaiSP/loai-san-pham";
    }

    @PostMapping("/loai-san-pham/add")
    public String addChatLieu(@Valid @ModelAttribute("lsp") LoaiSanPham loaiSanPham, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<LoaiSanPham> loaiSanPhams = loaiSanPhamService.getAllLoaiSanPham();
            model.addAttribute("loaiSanPhams", loaiSanPhams);

            return "/zloaiSP/loai-san-pham";
        }
        loaiSanPhamService.addLoaiSanPham(loaiSanPham);
        return "redirect:/loai-san-pham/hien-thi";
    }

    @GetMapping("/loai-san-pham/delete/{id}")
    public String deleteLoaiSP(@PathVariable("id") String id) {
        loaiSanPhamService.deleteLoaiSanPham(id);
        return "redirect:/loai-san-pham/hien-thi";
    }

    @GetMapping("/loai-san-pham/view-update/{id}")
    public String viewUpdate(Model model, @PathVariable("id") String id) {


        LoaiSanPham loaiSanPham = loaiSanPhamService.detailLoaiSanPham(id);
        model.addAttribute("loaiSanPhams", loaiSanPham);

        return "/loai-san-pham/loai-san-pham-update";
    }

    @PostMapping("/loai-san-pham/update")
    public String update(@ModelAttribute LoaiSanPham loaiSanPham, Model model) {
        loaiSanPhamService.updateLoaiSanPham(loaiSanPham);
        model.addAttribute("loaiSanPhams", loaiSanPham);
        return "redirect:/loai-san-pham/hien-thi";
    }
    @PostMapping("/loai-san-pham/sreach")
    public String sreach(@RequestParam(name = "page",defaultValue = "0") Integer pageNo,@RequestParam("ten") String ten,@RequestParam("trangThai") String trangThai, Model model) {
        Page<LoaiSanPham> page = loaiSanPhamService.findPage(pageNo,3);
        model.addAttribute("ten", loaiSanPhamService.sreach(ten,trangThai));
        model.addAttribute("currentPage",page.getNumber());
        model.addAttribute("totalPages",page.getTotalPages());
        model.addAttribute("loaiSP",page.getContent());

        return "redirect:/loai-san-pham/hien-thi";
    }
}
