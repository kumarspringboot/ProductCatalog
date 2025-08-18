package com.alt.controller;

import com.alt.dto.ProductDTO;
import com.alt.service.ProductService;
import com.alt.util.ProductType;
import jakarta.persistence.Access;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping(value="/")
    public String getRegistrationPage(Model model,HttpSession session) {
            String user = (String) session.getAttribute("user");
            if(user!=null) {
                model.addAttribute("product", new ProductDTO());
                model.addAttribute("type", ProductType.values());
                return "register";
            }else{
                return "redirect:/login";
            }

    }

    @PostMapping(value="/register")
//    public String saveProduct(@ModelAttribute("product")ProductDTO productDTO, Model model) {
        public String saveProduct(@ModelAttribute("product")ProductDTO productDTO, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        String user = (String) session.getAttribute("user");

        if(user!=null) {
            ProductDTO productDTO1 = productService.registerProduct(productDTO);
            redirectAttributes.addFlashAttribute("msg", "Product Registered Succesfully" + productDTO1.getId());
            return "redirect:/list_product";
        }else{
            return "redirect:/login";
        }
    }

    @GetMapping(value="/list_product")
    public String getListOfProduct(Model model, HttpSession session) {

        String user = (String)session.getAttribute("user");

        if(user!=null){
        List<ProductDTO> allProd = productService.fetchAllProducts();
        model.addAttribute("listProduct", allProd);
        return "listProduct";
        }
        else{
            System.out.println("invalid user");
            return "redirect:/login";
        }
    }

    @GetMapping(value="/delete/{id}")
    public String deleteProduct(@PathVariable("id")Long id,HttpSession session) {
        String user = (String)session.getAttribute("user");
        if(user!=null) {
            productService.deleteProduct(id);
            return "redirect:/list_product";
        }else{
            return "redirect:/login";
        }
    }

    @GetMapping(value="/edit/{id}")
    public String editProduct(@PathVariable("id")Long id,Model model,HttpSession session) {
        String user = (String)session.getAttribute("user");

        if(user!=null) {
            ProductDTO productByID = productService.fetchProduct(id);
            model.addAttribute("product", productByID);
            model.addAttribute("type", ProductType.values());
            return "edit";
        }else{
            System.out.println("invalid user");
            return "redirect:/login";
        }
    }

    @PostMapping(value="/update")
    public String updateProduct(@ModelAttribute("product")ProductDTO productDTO,Model model,HttpSession session) {
        String user = (String) session.getAttribute("user");

        if(user!=null) {
            productService.updateProduct(productDTO);
            return "redirect:/list_product";
        }else{
            return "redirect:/login";
        }
    }



}