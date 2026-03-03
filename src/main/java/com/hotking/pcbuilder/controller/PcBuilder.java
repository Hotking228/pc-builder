package com.hotking.pcbuilder.controller;

import com.hotking.pcbuilder.config.Pages;
import com.hotking.pcbuilder.entity.Product;
import com.hotking.pcbuilder.paginator.ProductPage;
import com.hotking.pcbuilder.paginator.ProductPaginator;
import com.hotking.pcbuilder.service.CategoryService;
import com.hotking.pcbuilder.service.ProductService;
import com.hotking.pcbuilder.pcbuild.PcBuild;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/builder")
@SessionAttributes({"build"})
public class PcBuilder {

    private final ProductService productService;
    private final CategoryService categoryService;
    private final PcBuild build;
    private final Pages pages;
    private final ProductPage productPage;
    private final ProductPaginator productPaginator;

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
                                  @PathVariable("slug") String slug,
                                  @RequestParam(value = "sortOrder", required = false) SortOrder order,
                                  @RequestParam(value = "pageNumber", required = false) Integer pageNumber){




        productPage.setPageSize(pages.getPageSize());
        productPage.setPageNum(pages.getDefaultPage());
        productPage.setMaxPrice(100_000F);
        productPage.setMinPrice(0F);



        model.addAttribute("components", productService.findAllBySlug(slug));


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
