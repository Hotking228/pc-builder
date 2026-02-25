package com.hotking.pcbuilder.validation;

import com.hotking.pcbuilder.entity.*;
import com.hotking.pcbuilder.service.CategoryLimitService;
import com.hotking.pcbuilder.service.CompatibilityRuleService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Transactional(readOnly = true)
@Component
@RequiredArgsConstructor
public class BuildCompletenessValidator implements ConstraintValidator<Build, PcBuild> {

    private final CompatibilityRuleService compatibilityService;
    private final CategoryLimitService limitService;

    @Override
    public boolean isValid(PcBuild pcBuild, ConstraintValidatorContext constraintValidatorContext) {

        LinkedList<Product> list = pcBuild.get();
        Product last = list.getLast();
        if(moreThanPossible(list, last)){
            return false;
        }
        for(int i = 0; i < list.size() - 1; i ++){
            if(!compatible(last, list.get(i))){
                return false;
            }
        }

        return true;
    }

    private boolean moreThanPossible(LinkedList<Product> list, Product last) {
        int max = Integer.MAX_VALUE;
        int curCnt = 0;
        for (int i = 0; i < list.size(); i++) {
            max = Math.min(max, countPossible(list.get(i), last.getCategory(), max));
            if(Objects.equals(list.get(i).getCategory().getSlug(), last.getCategory().getSlug())){
                curCnt++;
            }
        }

        return max < curCnt;
    }

    private int countPossible(Product product, Category category, int max) {
        if(category.getSlug().equals("motherboards")){
            return 1;
        }
        if(product.getCategory().getSlug().equals(category.getSlug())){
            return max == Integer.MAX_VALUE ? 0 : max;
        }
        List<CategoryLimit> limits = limitService.findAllByCategoryAndProduct(category, product);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < limits.size(); i++) {
            if(limits.get(i).getSourceCategory().getSlug().equals(category.getSlug())){
                min = Math.min(min, limits.get(i).getMaxCount());
            }
        }

        return min;
    }

    private boolean compatible(Product p1, Product p2){
        List<CompatibilityRule> list = compatibilityService.findAllByCategories(p1.getCategory(), p2.getCategory());
        //TODO: обработать исключение
        for(int i = 0; i < list.size(); i++){
            int finalI = i;
            List<Specification> sourceSpec = p1.getSpecifications().stream()
                    .filter(spec -> list.get(finalI).getSourceSpecKey().equals(spec.getSpecKey()))
                    .toList();

            List<Specification> targetSpec = p2.getSpecifications().stream()
                    .filter(spec -> list.get(finalI).getSourceSpecKey().equals(spec.getSpecKey()))
                    .toList();

            if(sourceSpec.isEmpty() || targetSpec.isEmpty()) return false;

            switch (list.get(i).getOperator()){
                case EQUALS :
                    if(!sourceSpec.get(0).getSpecValue().equals(targetSpec.get(0).getSpecValue())){
                        return false;
                    }
                    break;
                case NOT_EQUALS :
                    if(sourceSpec.get(0).getSpecValue().equals(targetSpec.get(0).getSpecValue())){
                        return false;
                    }
                    break;
                case GREATER_THAN :
                    if(Long.parseLong(sourceSpec.get(0).getSpecValue()) <= Long.parseLong(targetSpec.get(0).getSpecValue())){
                        return false;
                    }
                    break;
                case LESS_THAN :
                    if(Long.parseLong(sourceSpec.get(0).getSpecValue()) >= Long.parseLong(targetSpec.get(0).getSpecValue())){
                        return false;
                    }
                    break;
                case GREATER_THAN_OR_EQUAL :
                    if(Long.parseLong(sourceSpec.get(0).getSpecValue()) < Long.parseLong(targetSpec.get(0).getSpecValue())){
                        return false;
                    }
                    break;
                case LESS_THAN_OR_EQUAL :
                    //TODO: добавить парсинг версий(попробовать добавить видюху -> посмотреть ошибку)
                    if(Long.parseLong(sourceSpec.get(0).getSpecValue()) > Long.parseLong(targetSpec.get(0).getSpecValue())){
                        return false;
                    }
                    break;
                case CONTAINS :
                    boolean contains = false;

                    for(int j = 0; j < sourceSpec.size(); j++){
                        List<String> sourceSpecs = Arrays.stream(sourceSpec.get(j).getSpecValue().split(", "))
                                .toList();
                        for(int k = 0; k < sourceSpecs.size(); k++) {
                            if (sourceSpecs.get(k).equals(targetSpec.get(0).getSpecValue())) {
                                contains = true;
                            }
                        }
                    }

                    if(!contains){
                        return  false;
                    }
                    break;
                case IN :
                    boolean in = false;
                    for(int j = 0; j < sourceSpec.size(); j++){
                        if(targetSpec.get(j).getSpecValue().equals(sourceSpec.get(0).getSpecValue())){
                            in = true;
                        }
                    }

                    if(!in){
                        return  false;
                    }
                    break;
            }
        }
        return true;
    }
}
