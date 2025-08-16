package com.alt.controller;

import com.alt.dto.ProductDTO;
import com.alt.service.ProductService;
import com.alt.util.ProductType;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping(value="/")
    public String getRegistrationPage(Model model) {
        model.addAttribute("product", new ProductDTO());
        model.addAttribute("type", ProductType.values());
        return "register";
    }

    @PostMapping(value="/register")
    public String saveProduct(@ModelAttribute("product")ProductDTO productDTO,Model model) {
        productService.registerProduct(productDTO);

        return "redirect:/list_product";
    }

    @GetMapping(value="/list_product")
    public String getListOfProduct(Model model) {
        List<ProductDTO> allProd = productService.fetchAllProducts();
        model.addAttribute("listProduct", allProd);
        return "listProduct";
    }

    @GetMapping(value="/delete/{id}")
    public String deleteProduct(@PathVariable("id")Long id) {
        productService.deleteProduct(id);
        return "redirect:/list_product";
    }

    @GetMapping(value="/edit/{id}")
    public String editProduct(@PathVariable("id")Long id,Model model) {
        ProductDTO productByID = productService.fetchProduct(id);
        model.addAttribute("product", productByID);
        model.addAttribute("type", ProductType.values());
        return "edit";
    }

    @PostMapping(value="/update")
    public String updateProduct(@ModelAttribute("product")ProductDTO productDTO,Model model) {
        productService.updateProduct(productDTO);
        return "redirect:/list_product";
    }
}