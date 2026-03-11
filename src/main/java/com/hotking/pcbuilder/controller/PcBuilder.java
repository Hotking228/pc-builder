package com.hotking.pcbuilder.controller;

import com.hotking.pcbuilder.config.Pages;
import com.hotking.pcbuilder.dto.ProductCreateEditDto;
import com.hotking.pcbuilder.entity.Product;
import com.hotking.pcbuilder.entity.Specification;
import com.hotking.pcbuilder.paginator.ProductPage;
import com.hotking.pcbuilder.paginator.ProductPaginator;
import com.hotking.pcbuilder.parsers.VersionParser;
import com.hotking.pcbuilder.service.CategoryService;
import com.hotking.pcbuilder.service.PortService;
import com.hotking.pcbuilder.service.ProductService;
import com.hotking.pcbuilder.pcbuild.PcBuild;
import com.hotking.pcbuilder.service.SpecificationService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;
import java.util.*;

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
    private final SpecificationService specificationService;
    private final PortService portService;
    private final VersionParser versionParser;

    @GetMapping("/create/{slug}")
    public String createProduct(Model model,
                                @PathVariable("slug") String slug){
        model.addAttribute("specs", specificationService.findAllBySlug(slug));
        model.addAttribute("slug", slug);
        return "/builder/createProduct";
    }

    @PostMapping("/create/{slug}")
    public String createProduct(Model model,
                                @PathVariable("slug") String slug,
                                HttpServletRequest req){
        Float price = Float.parseFloat(req.getParameter("price"));
        String manufacturer = req.getParameter("manufacturer");
        String name = req.getParameter("name");
        String vendorCode = req.getParameter("vendorCode");
        List<String[]> specs = specificationService.findAllBySlug(slug);
        Map<String, Specification> map = new HashMap<>();
        for (int i = 0; i < specs.size(); i++) {
            map.put(specs.get(i)[0], Specification.builder()
                            .specValue(req.getParameter(specs.get(i)[0]))
                            .specKey(specs.get(i)[0])
                    .build());
        }
        productService.create(Product.builder()
                        .name(name)
                        .manufacturer(manufacturer)
                        .price(price)
                        .vendorCode(vendorCode)
                        .specifications(map)
                        .category(categoryService.findBySlug(slug))
                    .build());
        return "redirect:/builder/select/%s".formatted(slug);
    }

    @GetMapping
    public String showBuild(
            Model model){

        if(model.getAttribute("build") == null) {
            model.addAttribute("build", build);
        }

        model.addAttribute("categories", categoryService.findAll());


        return "builder/builder";
    }

    @PostMapping("/select/{slug}")
    public String selectComponent(Model model,
                                  @PathVariable("slug") String slug,
                                  @ModelAttribute("page") ProductPage page,
                                  @RequestParam(value = "pageNum", required = false) Integer pageNum,
                                  HttpServletRequest req){




        List<String> possibleSortFields = specificationService.findAllBySlugToSort(slug);
        String[] manufacturers = req.getParameterValues("manufacturer");
        if(req.getParameter(possibleSortFields.get(0)) != null) {
            Map<String, SortOrder> sortOrders = new HashMap<>();
            for (int i = 0; i < possibleSortFields.size(); i++) {
                sortOrders.put(possibleSortFields.get(i), SortOrder.valueOf(req.getParameter(possibleSortFields.get(i))));
            }

            page.setSortOrders(sortOrders);
        }
        if(manufacturers != null && !manufacturers[0].isEmpty()){

            page.setManufacturer(Set.of(manufacturers));
        }
        if(pageNum == null){
            page.setPageNum(pages.getDefaultPage());
        } else {
            page.setPageNum(pageNum);
        }
        if(page.getMinPrice() == null){
            page.setMinPrice(0F);
        }
        if(page.getMaxPrice() == null){
            page.setMaxPrice(1_000_000F);
        }

        page.setPageSize(pages.getPageSize());
        productPage.set(page);

        return "redirect:/builder/select/%s".formatted(slug);
    }

    @GetMapping("/select/{slug}")
    public String selectComponent(Model model,
                                  @PathVariable("slug") String slug){


        if(productPage.isEmpty()){
            ProductPage page = ProductPage.builder()
                    .minPrice(0f)
                    .maxPrice(1_000_000f)
                    .pageNum(pages.getDefaultPage())
                    .pageSize(pages.getPageSize())
                    .manufacturer(new HashSet<>())
                    .build();
            productPage.set(page);
        }

        model.addAttribute("components", productService.findAllBySlug(slug));
        model.addAttribute("slug", slug);
        model.addAttribute("page", productPage);
        model.addAttribute("pageCount", productPaginator.getSize() / pages.getPageSize() +
                ((productPaginator.getSize() % pages.getPageSize() > 0 && productPaginator.getSize() > pages.getPageSize()) ? 1 : 0) - 1);
        model.addAttribute("companies", productService.findCompaniesBySlug(slug));
        model.addAttribute("possibleSortFields", specificationService.findAllBySlugToSort(slug));
        model.addAttribute("sortOrder", SortOrder.values());

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
