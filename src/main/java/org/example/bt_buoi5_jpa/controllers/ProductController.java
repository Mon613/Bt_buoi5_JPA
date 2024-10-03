package org.example.bt_buoi5_jpa.controllers;

import org.example.bt_buoi5_jpa.entities.Products;
import org.example.bt_buoi5_jpa.repositories.ProductRepository;
import org.example.bt_buoi5_jpa.repositories.ProductRepositoryPaging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class ProductController {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductRepositoryPaging productRepositoryPaging;

    @GetMapping("/getAll")
    public String getAll(Model model, @RequestParam(defaultValue = "1")int page){
        if(page<1){
            page=1;
        }
        int totalRecords = productRepositoryPaging.getTotalRecords();
        int totalPages = totalRecords/6;
        model.addAttribute("totalPage",totalPages);
        if (page>totalPages){
            page=1;
        }
        PageRequest pageRequest = PageRequest.of(page,6);
        model.addAttribute("products",productRepositoryPaging.findAll(pageRequest).get().toList());
//        model.addAttribute("products",productRepository.findAll());
        return "homePage";
    }
    @GetMapping("/save")
    public String save(Model model) {
        Products products = new Products();
        model.addAttribute("product",products);
        return "create";
    }
    @PostMapping("/create")
    public String save(Products products){
        try {
            productRepository.save(products);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/getAll";
    }
    @GetMapping("update/{id}")
    public String update(Model model, @PathVariable(name = "id")Long id){
        Products products = productRepository.findById(id).get();
        model.addAttribute("product",products);
        return "update";
    }
    @PostMapping("/update/{id}")
    public String update(Products products){
        productRepository.save(products);
        return "redirect:/admin/getAll";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        productRepository.deleteById(id);
        return "redirect:/admin/getAll";
    }

}
