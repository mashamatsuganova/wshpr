package org.example.webshopproject.controllers;
import jakarta.servlet.http.HttpSession;
import org.example.webshopproject.entities.Product;
import org.example.webshopproject.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
public class MainController {
    private ProductService productService;
    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/index")
    public String homePage() {
        return "index";
    }



    @GetMapping("/form")
    public String formPage() {
        return "form";
    }

    @GetMapping("/shop")
    public String shopPage(Model model, HttpSession session) {
        List<Product> allProducts = (List<Product>) productService.getAllProducts();
        //List<Product> allProducts = (List)productService.getAllProducts();
        //изменено 08,04,2024
        model.addAttribute("products", allProducts);
        return "shop";
    }

    @GetMapping("/details/{id}")
    public String detailsPage(Model model, @PathVariable("id") Long id) {
        Product selectedProduct = productService.getProductById(id);
        model.addAttribute("selectedProduct", selectedProduct);
        return "details";
    }


    @GetMapping("/find_by_title")
    public String detailsPageByTitle(Model model, @RequestParam("title") String title) {
        Product selectedProduct = productService.getProductByTitle(title);
        model.addAttribute("selectedProduct", selectedProduct);
        return "details";
    }


    @GetMapping("/products/delete/{id}")
    public String deleteProductById(@PathVariable("id") Long id) {
        productService.deleteProductById(id);
        return "redirect:/shop";
    }

}
