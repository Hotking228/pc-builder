package com.hotking.pcbuilder.controller;

import com.hotking.pcbuilder.service.CategoryService;
import com.hotking.pcbuilder.service.ProductService;
import com.hotking.pcbuilder.pcbuild.PcBuild;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/builder")
@SessionAttributes({"build"})
public class PcBuilder {

    private final ProductService productService;
    private final CategoryService categoryService;
    private final PcBuild build;

    @GetMapping
    public String showBuild(
            Model model){

        if(model.getAttribute("build") == null) {
            model.addAttribute("build", build);
        }

        model.addAttribute("categories", categoryService.findAll());


        return "builder/builder";
    }

    @GetMapping("/select/{slug}")
    public String selectComponent(Model model,
                                  @PathVariable("slug") String slug){
        model.addAttribute("components", productService.findAllBySlug(slug)
                .stream()
                .filter(build::validateComponent)
                .toList());

        return "/builder/components";
    }

    @GetMapping("/component/{componentId}")
    public String getComponentInfo(Model model,
                                   @PathVariable("componentId") Integer componentId){

        //TODO: добавить исключение
        model.addAttribute("component", productService.findById(componentId.longValue()).orElseThrow());

        return "/builder/component";
    }

    @PostMapping
    public String addComponentToBuild(Model model,
                                      @ModelAttribute("component") Long id){
        if(model.getAttribute("build") == null) {
            model.addAttribute("build", build);
        }
        build.addComponent(productService.findByIdEntity(id));


        return "redirect:/builder";
    }

    @PostMapping("/remove/{id}")
    public String removeComponent(@PathVariable Integer id){

        build.removeComponent(id.longValue());

        return "redirect:/builder";
    }
}
