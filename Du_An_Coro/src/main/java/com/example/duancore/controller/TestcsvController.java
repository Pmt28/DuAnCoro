package com.example.duancore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.duancore.repository.TestCSVRepository;
import com.example.duancore.entity.testcsv;

import java.util.List;


@Controller
@RequestMapping(value = "testcsv")
public class TestcsvController {

    @Autowired
    private TestCSVRepository testCSVRepository;

    @GetMapping("list")
    public String showListCSV(Model model){


        List<testcsv> testcsvList = testCSVRepository.findAll();
        model.addAttribute("views",testcsvList);

        return "testcsv/list";



    }


}
