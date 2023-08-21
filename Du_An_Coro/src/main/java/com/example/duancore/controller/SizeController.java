package com.example.duancore.controller;

import com.example.duancore.entity.Size;
import com.example.duancore.repository.SizeRepository;
import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller

@RequestMapping(value = "/Size")
public class SizeController {


     @Autowired
     ServletContext context;

     @Autowired
     private SizeRepository sizeRepository;


     @GetMapping("list")
     public String listShow(){

         return "Size/hienThi";

     }


     @GetMapping("listSize")
     public String listSize(Model model){

         List<Size> sizeList = sizeRepository.findAll();

         model.addAttribute("sizelist", sizeList);

         return "Size/list";


     }



}
