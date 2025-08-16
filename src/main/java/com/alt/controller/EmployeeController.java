package com.alt.controller;

import com.alt.dto.EmployeeDTO;
import com.alt.dto.ProductDTO;
import com.alt.entity.EmployeeEntity;
import com.alt.repository.EmployeeRepository;
import com.alt.service.EmployeeService;
import com.alt.service.ProductService;
import com.alt.util.EmployeeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping(value = "/emplregister")
    public String getRegistration(Model model) {
        model.addAttribute("employee", new EmployeeDTO());
        model.addAttribute("type", EmployeeType.values());
        return "emplregister";
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
    public String authEmployee(@ModelAttribute("authentication") EmployeeDTO employeeDTO, Model model) {
        Optional<EmployeeEntity> byEmailAndPassword = employeeRepository.findByEmailAndPassword(employeeDTO.getEmail(), employeeDTO.getPassword());
        System.out.println(byEmailAndPassword+"Employee==>"+employeeDTO.getEmail() + employeeDTO.getPassword());
        if(byEmailAndPassword!=null && byEmailAndPassword.isPresent()) {

            List<ProductDTO> allProd = productService.fetchAllProducts();
            model.addAttribute("listProduct", allProd);

            return "listProduct";

        }else{
            return "redirect:/login";
        }

    }

}
