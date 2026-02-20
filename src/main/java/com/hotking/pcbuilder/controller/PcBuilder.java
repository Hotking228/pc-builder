package com.hotking.pcbuilder.controller;

import com.hotking.pcbuilder.entity.Product;
import com.hotking.pcbuilder.service.CategoryService;
import com.hotking.pcbuilder.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/builder")
@SessionAttributes({"build"})
public class PcBuilder {

    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping
    public String showBuild(
                            Model model,
                            @SessionAttribute(value = "build", required = false) List<Product> components){
        if(components == null) {
            components = new ArrayList<>();
            model.addAttribute("build", components);
        }

        model.addAttribute("categories", categoryService.findAll());


        return "builder/builder";
    }

    @GetMapping("/select/{slug}")
    public String selectComponent(
                                  Model model,
                                  @PathVariable("slug") String slug){
        model.addAttribute("components", productService.findAllBySlug(slug));

        return "/builder/components";
    }

    @PostMapping
    public String addComponentToBuild(Model model,
                                      @ModelAttribute("component") Long id,
                                      @SessionAttribute(value = "build", required = false) List<Product> components){
        if(components == null) {
            components = new ArrayList<>();
            model.addAttribute("build", components);
        }
        components.add(productService.findByIdEntity(id));

        return "redirect:/builder";
    }
}
