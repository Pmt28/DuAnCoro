package com.example.duancore.controller;



import com.example.duancore.entity.SanPham;
import com.lowagie.text.DocumentException;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.duancore.repository.SanPhamRepository;
import com.example.duancore.controller.user.sanPhamExportExcel;
import com.example.duancore.controller.user.sanPhamPDFExport;



import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/sanPham")
public class SanPhamController {


    @Autowired
    ServletContext context;

    @Autowired
    private SanPhamRepository sanPhamRepository;

//    @Qualifier xác định tên của một Bean mà bạn muốn chỉ định inject.

    @Autowired
    @Qualifier ("sanPham")
    private SanPham sp;

//    Todo code create

    @GetMapping("create")
    public String createProduct(Model model){

        model.addAttribute("product", new SanPham());
        return "sanpham/create";
//         Đường dẫn trả về

    }

    //    Todo code create

    @PostMapping("create")
    public String saveProduct(Model model,
                              @Valid
                              @ModelAttribute("product") SanPham product,
                              BindingResult result,
                              RedirectAttributes attributes
                              ){

        if(result.hasErrors()){

            return "sanpham/create";

        }


        sanPhamRepository.save(product);

        attributes.addFlashAttribute("message","Create new sản phẩm was successfully");
        return "redirect:/sanPham/list";

    }



    //Todo code list

    @GetMapping("list")
    public String showListProduct(Model model){

        List<SanPham> products = sanPhamRepository.findAll();
        System.out.println(products.size());
        model.addAttribute("products", products);

        return "sanpham/list";

    }

    //Todo code delete

    @GetMapping("delete/{masp}")
    public String deleteProduct(@PathVariable("masp") String masp){

        if(sanPhamRepository.existsById(masp)){

            sanPhamRepository.deleteById(masp);

        }

        return "redirect:/sanPham/list";

    }



    //Todo code edit

    @GetMapping("edit/{masp}")
    public String edit(@PathVariable("masp")
                                    SanPham sanPham,
                                    Model model)
    {
        sp.setTensp(sanPham.getTensp());
        sp.setNgaysua(sanPham.getNgaysua());
        sp.setTrangthai(sanPham.getTrangthai());
        model.addAttribute("sp",sp);
        model.addAttribute("action","/sanPham/update/" + sanPham.getMasp());
        return "sanpham/update";
    }

    @PostMapping("update/{masp}")
    public String update(@PathVariable("masp") SanPham sanPham,
                         @Valid
                         @ModelAttribute("sp") SanPham spp,
                         BindingResult result
    ) {
        if (result.hasErrors()) {

            return "sanpham/update";

        } else {

            java.util.Date date =new java.util.Date();

//            sanPham.setNgaysua(date);
            sanPham.setNgaysua(spp.getNgaysua());
            sanPham.setTensp(spp.getTensp());
            sanPham.setNgaysua(spp.getNgaysua());
            sanPham.setTrangthai(spp.getTrangthai());
            sanPhamRepository.save(sanPham);
        }

        return "redirect:/sanPham/list";

    }


    // Todo code export File PDF

    @GetMapping("exportFilePDF")
    public void FileFDP(

            HttpServletResponse response

    ) throws DocumentException, IOException {

        response.setContentType("application/pdf");

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currenDateTime = dateFormat.format(new Date());

        String headerkey = "Content-Disposition";
        String headerValue = "attachment; filename=Product_"+currenDateTime+".pdf";

        response.setHeader(headerkey,headerValue);

        List<SanPham> products = sanPhamRepository.findAll();

        sanPhamPDFExport pdfExport = new sanPhamPDFExport(products);
        pdfExport.export(response);

    }

//Todo code Export Excal

    @GetMapping("exportFileExcel")
    public void FileExcel(
            Model model,
            HttpServletResponse response)throws IOException{

        response.setContentType("application/octet-stream");

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currenDateTime = dateFormat.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Product_"+currenDateTime+".xlsx";

        response.setHeader(headerKey,headerValue);

        List<SanPham> products = sanPhamRepository.findAll();

        sanPhamExportExcel exportExcel = new sanPhamExportExcel(products);
        exportExcel.export(response);

    }





}
