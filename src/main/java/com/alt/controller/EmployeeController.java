package com.alt.controller;

import com.alt.dto.EmployeeDTO;
import com.alt.dto.ProductDTO;
import com.alt.entity.EmployeeEntity;
import com.alt.repository.EmployeeRepository;
import com.alt.service.EmployeeService;
import com.alt.service.ProductService;
import com.alt.util.EmployeeType;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Optionals;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ProductService productService;

    @Autowired
    private EmployeeRepository employeeRepository;


    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/login"; // Redirect to login page
    }

    @GetMapping(value = "/emplregister")
    public String getRegistration(Model model,HttpSession session) {
        String user = (String) session.getAttribute("user");

        if(user!=null){
            model.addAttribute("employee", new EmployeeDTO());
        model.addAttribute("type", EmployeeType.values());
        return "emplregister";}
        else{
            return "redirect:/login";
        }
    }

    @PostMapping(value = "/saveemployee")
    public String saveEmployee(@ModelAttribute("employee") EmployeeDTO employeeDTO, Model model) {
        employeeService.registerEmployee(employeeDTO);
        System.out.println("<UNK> <UNK> <UNK> <UNK> <UNK> <UNK> <UNK> <UNK> <UNK>");
        System.out.println(employeeDTO.getFname() + " " + employeeDTO.getLname());
        return "redirect:/emplregister";
    }
    @GetMapping(value="/login")
    public String login(Model model) {
        model.addAttribute("authentication", new EmployeeDTO());
        return "login";
    }
    @PostMapping(value = "/login")
    public String authEmployee(@ModelAttribute("authentication") EmployeeDTO employeeDTO, Model model, HttpSession session, RedirectAttributes re) {
        Optional<EmployeeEntity> byEmailAndPassword = employeeRepository.findByEmailAndPassword(employeeDTO.getEmail(), employeeDTO.getPassword());
        System.out.println(byEmailAndPassword+"Employee==>"+employeeDTO.getEmail() + employeeDTO.getPassword());
        if(byEmailAndPassword!=null && byEmailAndPassword.isPresent()) {
            session.setAttribute("user",employeeDTO.getEmail());
            System.out.println("user session value is ->"+session.getAttribute("user"));
            List<ProductDTO> allProd = productService.fetchAllProducts();
            model.addAttribute("listProduct", allProd);
            re.addFlashAttribute("msg","user succesfully logged in!");
            return "redirect:/list_product";
        }else{
            System.out.println("login failed sysout");
            re.addFlashAttribute("error","login failed");
            return "redirect:/login";
        }

    }

}
