package com.alt.controller;

import com.alt.dto.EmployeeDTO;
import com.alt.service.EmployeeService;
import com.alt.util.EmployeeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value="/emplregister")
    public String getRegistration(Model model){
        model.addAttribute("employee", new EmployeeDTO());
        model.addAttribute("type", EmployeeType.values());
        return "emplregister";
    }

    @PostMapping(value="/saveemployee")
    public String saveEmployee(@ModelAttribute("employee")EmployeeDTO employeeDTO, Model model){
        employeeService.registerEmployee(employeeDTO);
        System.out.println("<UNK> <UNK> <UNK> <UNK> <UNK> <UNK> <UNK> <UNK> <UNK>");
        System.out.println(employeeDTO.getFname() + " " + employeeDTO.getLname());
        return "redirect:/emplregister";
    }
}
