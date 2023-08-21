package com.example.duancore.controller.DangNhap;

import com.example.duancore.entity.User;
import com.example.duancore.repository.UserRepository;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class Login {


    @Autowired
    ServletContext context;

    @Autowired
    private UserRepository userRepository;

    //Todo code login
    @GetMapping(value = "/login")
    public String showLoginForm(Model model){

        model.addAttribute("user", new User());
        return "DangNhap/Login";

    }


//    //Todo code check login
    @PostMapping("/login")
    public String checkLogin(@Valid
                             @ModelAttribute("user") User user,
                             HttpServletRequest request,
                             BindingResult result,
                             HttpSession session,
                             RedirectAttributes attributes,
                             Model model){

        if(result.hasErrors() || user.getEmail().isEmpty()){

            System.out.println("Đăng nhập thất bại");
            model.addAttribute("mes","Không được để trống dữ liệu");
            return "DangNhap/Login";

        }

        User userData = userRepository.findByEmailAndPassword(user.getEmail(),user.getPassword());
        String maNV = userData.getMaNV();

        if(userData != null){

            System.out.println("Đăng nhập thành công !");
            session.setAttribute("userLog", userData);
            session.setAttribute("maNV",maNV);
            return "redirect:/home";

        }

        model.addAttribute("message","Email or Passwork incorrect");
        return "DangNhap/Login";

    }


    //Todo code logout
    @GetMapping("logout")
    public String logout(Model model,
                         User user,
                         HttpSession session){

        session.removeAttribute(user.getEmail());
        model.addAttribute("user",new User());
        return "DangNhap/Login";

    }


    //Todo code create account
    @GetMapping("addAccountUser")
    public String save(Model model){

           model.addAttribute("user",new User());
           return "DangNhap/Enregistrer";

    }



    @PostMapping("addAccountUser")
    public String saveUsser(Model model,
                            @Valid
                            @ModelAttribute("user") User user,
                            BindingResult result,
                            RedirectAttributes attributes,
                            HttpSession session){

       if(result.hasErrors()){

           System.out.println("Er");
           return "DangNhap/Enregistrer";

       }

       userRepository.save(user);
        List<User> userList = userRepository.findAll();
        model.addAttribute("user", userList);
        attributes.addFlashAttribute("message", "Create new User successfully");

       return "redirect:/login";

    }



}
