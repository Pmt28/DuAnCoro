package com.example.duancore.config;

import com.example.duancore.entity.*;
import com.example.duancore.filter.LogGinInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.example.duancore.filter.adminInterceptor;

@Configuration
public class WebMVCConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");

        registry
                .addResourceHandler("/upload/**")
                .addResourceLocations("/upload/");
    }

    @Bean("thanhToan")
    public HinhThucThanhToan getThanhToan(){
        HinhThucThanhToan vm = new HinhThucThanhToan();
        return vm;
    }

    @Bean("khachHang")
    public KhachHang getKhachHang(){
        KhachHang vm = new KhachHang();
        return vm;
    }


    @Bean("sanPham")
    public SanPham getSanPham(){
        SanPham sp = new SanPham();
        return sp;
    }


    @Bean("GioHang")
    public GioHang gioHang(){

        GioHang gh = new GioHang();

        return gh;

    }

    @Bean("ChiTietSanPham")
    public ChiTietSanPham chiTietSanPham(){

        ChiTietSanPham ctsp = new ChiTietSanPham();

        return ctsp;

    }


    //   Authorize the size web

    @Autowired
    LogGinInterceptor loginInterceptor;

    @Autowired
    adminInterceptor adminInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){

        //Các file được xem
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/checkout", "/profile","","/category/list");


        //Phân quyền bắt đăng nhập
        registry.addInterceptor(adminInterceptor)
                .addPathPatterns("/admin/**","/sanPham/create", "/product/create", "/product/edit/{id}","/category/create","/category/edit/{id}","/product/delete/{id}","/category/delete/{id}");

      }


    //how to code all language




}




