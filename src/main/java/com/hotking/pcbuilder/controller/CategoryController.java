package com.hotking.pcbuilder.controller;

import com.hotking.pcbuilder.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @GetMapping("/categories")
    public String getCategories(Model model){
        model.addAttribute("categories", categoryService.findAll());

        return "categories/categories";
    }

    @GetMapping("/category/{id}")
    public String getCategory(@PathVariable("id")Long id, Model model){
        //TODO: добавить исключение
        model.addAttribute("category", categoryService.findById(id).orElseThrow());

        return "categories/category";
    }
}
