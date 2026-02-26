package com.hotking.pcbuilder.pcbuild;

import com.hotking.pcbuilder.convertors.VersionConvertor;
import com.hotking.pcbuilder.entity.*;
import com.hotking.pcbuilder.service.CategoryLimitService;
import com.hotking.pcbuilder.service.CompatibilityRuleService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
@Component
@RequiredArgsConstructor
public class BuildCompletenessValidator implements ConstraintValidator<Build, PcBuild> {

    private final CompatibilityRuleService compatibilityService;
    private final CategoryLimitService limitService;
    private final VersionConvertor convertor;

    public boolean isValid(PcBuild pcBuild, Product product){
        if(validParameters(pcBuild, product)){
            return true;
        }

        return false;
    }



    @Override
    // Если у пользователя как то получилось добавить невалидный объект, мы его удалим через аспект
    public boolean isValid(PcBuild pcBuild, ConstraintValidatorContext constraintValidatorContext) {
        //TODO: добавить исключение
        return validParameters(pcBuild, pcBuild.get().stream()
                .filter(component -> component.getId() == pcBuild.getLastAdded())
                .findFirst()
                .orElseThrow());
    }


    private boolean validParameters(PcBuild pcBuild, Product product) {
        LinkedList<Product> products = pcBuild.get();
        for (int i = 0; i < products.size(); i++) {
            if(product.getCategory().getSlug().equals(products.get(i).getCategory().getSlug())) continue;
            List<CompatibilityRule>rules =  compatibilityService.findAllByCategories(products.get(i).getCategory(), product.getCategory());
            rules.addAll(compatibilityService.findAllByCategories(product.getCategory(), products.get(i).getCategory()));
            for (int j = 0; j < rules.size(); j++) {
                switch (rules.get(j).getOperator()){
                    case IN :
                    case CONTAINS:
                        if(rules.get(j).getSourceCategory().getSlug().equals(product.getCategory().getSlug())) {
                            Set<String> p1Characteristics = Arrays.stream(product.getSpecifications().get(rules.get(j).getSourceSpecKey()).getSpecValue().split(", ")).collect(Collectors.toSet());
                            List<String> p2Characteristics = Arrays.stream(products.get(i).getSpecifications().get(rules.get(j).getTargetSpecKey()).getSpecValue().split(", ")).toList();
                            boolean contains = false;
                            for (int k = 0; k < p2Characteristics.size(); k++) {
                                if (p1Characteristics.contains(p2Characteristics.get(k))) {
                                    contains = true;
                                }
                            }
                            if (contains) break;
                        } else {
                            Set<String> p1Characteristics = Arrays.stream(product.getSpecifications().get(rules.get(j).getTargetSpecKey()).getSpecValue().split(", ")).collect(Collectors.toSet());
                            List<String> p2Characteristics = Arrays.stream(products.get(i).getSpecifications().get(rules.get(j).getSourceSpecKey()).getSpecValue().split(", ")).toList();
                            boolean contains = false;
                            for (int k = 0; k < p2Characteristics.size(); k++) {
                                if (p1Characteristics.contains(p2Characteristics.get(k))) {
                                    contains = true;
                                }
                            }
                            if (contains) break;
                        }
                        return false;

                    case EQUALS:
                        if(!product.getSpecifications().get(rules.get(j).getSourceSpecKey()).getSpecValue().equals(products.get(i).getSpecifications().get(rules.get(j).getTargetSpecKey()).getSpecValue())){
                            return false;
                        }
                        break;
                    case LESS_THAN:
                        //прямое условие
                        if(rules.get(j).getSourceCategory().getSlug().equals(product.getCategory().getSlug())){
                            try{

                                if(Integer.parseInt(product.getSpecifications().get(rules.get(j).getSourceSpecKey()).getSpecValue()) >=
                                        Integer.parseInt(products.get(i).getSpecifications().get(rules.get(j).getTargetSpecKey()).getSpecValue())){
                                    return false;
                                }
                            } catch (NumberFormatException e){
                                if(Integer.parseInt(convertor.convert(product.getSpecifications().get(rules.get(j).getSourceSpecKey()).getSpecValue())) >=
                                        Integer.parseInt(convertor.convert(products.get(i).getSpecifications().get(rules.get(j).getTargetSpecKey()).getSpecValue()))){
                                    return false;
                                }
                            }
                        } else { // обратное условие
                            try{
                                if(Integer.parseInt(products.get(i).getSpecifications().get(rules.get(j).getSourceSpecKey()).getSpecValue()) >=
                                        Integer.parseInt(product.getSpecifications().get(rules.get(j).getTargetSpecKey()).getSpecValue())){
                                    return false;
                                }
                            } catch (NumberFormatException e){
                                if(Integer.parseInt(convertor.convert(products.get(i).getSpecifications().get(rules.get(j).getSourceSpecKey()).getSpecValue()))>=
                                        Integer.parseInt(convertor.convert(product.getSpecifications().get(rules.get(j).getTargetSpecKey()).getSpecValue()))){
                                    return false;
                                }
                            }
                        }
                        break;

                    case NOT_EQUALS:
                        if(product.getSpecifications().get(rules.get(j).getSourceSpecKey()).getSpecValue().equals(products.get(i).getSpecifications().get(rules.get(j).getTargetSpecKey()).getSpecValue())){
                            return false;
                        }
                        break;

                    case GREATER_THAN:
                        //прямое условие
                        if(rules.get(j).getSourceCategory().getSlug().equals(product.getCategory().getSlug())){
                            try{
                                if(Integer.parseInt(product.getSpecifications().get(rules.get(j).getSourceSpecKey()).getSpecValue()) <=
                                        Integer.parseInt(products.get(i).getSpecifications().get(rules.get(j).getTargetSpecKey()).getSpecValue())){
                                    return false;
                                }
                            } catch (NumberFormatException e){
                                if(Integer.parseInt(convertor.convert(product.getSpecifications().get(rules.get(j).getSourceSpecKey()).getSpecValue())) <=
                                        Integer.parseInt(convertor.convert(products.get(i).getSpecifications().get(rules.get(j).getTargetSpecKey()).getSpecValue()))){
                                    return false;
                                }
                            }
                        } else { // обратное условие
                            try{
                                if(Integer.parseInt(products.get(i).getSpecifications().get(rules.get(j).getSourceSpecKey()).getSpecValue()) <=
                                        Integer.parseInt(product.getSpecifications().get(rules.get(j).getTargetSpecKey()).getSpecValue())){
                                    return false;
                                }
                            } catch (NumberFormatException e){
                                if(Integer.parseInt(convertor.convert(products.get(i).getSpecifications().get(rules.get(j).getSourceSpecKey()).getSpecValue()))<=
                                        Integer.parseInt(convertor.convert(product.getSpecifications().get(rules.get(j).getTargetSpecKey()).getSpecValue()))){
                                    return false;
                                }
                            }
                        }
                        break;

                    case LESS_THAN_OR_EQUAL:
                        if(rules.get(j).getSourceCategory().getSlug().equals(product.getCategory().getSlug())){
                            try{
                                if(Integer.parseInt(product.getSpecifications().get(rules.get(j).getSourceSpecKey()).getSpecValue()) >
                                        Integer.parseInt(products.get(i).getSpecifications().get(rules.get(j).getTargetSpecKey()).getSpecValue())){
                                    return false;
                                }
                            } catch (NumberFormatException e){
                                if(Integer.parseInt(convertor.convert(product.getSpecifications().get(rules.get(j).getSourceSpecKey()).getSpecValue())) >
                                        Integer.parseInt(convertor.convert(products.get(i).getSpecifications().get(rules.get(j).getTargetSpecKey()).getSpecValue()))){
                                    return false;
                                }
                            }
                        } else { // обратное условие
                            try{
                                if(Integer.parseInt(products.get(i).getSpecifications().get(rules.get(j).getSourceSpecKey()).getSpecValue()) >
                                        Integer.parseInt(product.getSpecifications().get(rules.get(j).getTargetSpecKey()).getSpecValue())){
                                    return false;
                                }
                            } catch (NumberFormatException e){
                                if(Integer.parseInt(convertor.convert(products.get(i).getSpecifications().get(rules.get(j).getSourceSpecKey()).getSpecValue()))>
                                        Integer.parseInt(convertor.convert(product.getSpecifications().get(rules.get(j).getTargetSpecKey()).getSpecValue()))){
                                    return false;
                                }
                            }
                        }
                        break;

                    case GREATER_THAN_OR_EQUAL:
                        //прямое условие
                        if(rules.get(j).getSourceCategory().getSlug().equals(product.getCategory().getSlug())){
                            try{
                                if(Integer.parseInt(product.getSpecifications().get(rules.get(j).getSourceSpecKey()).getSpecValue()) <
                                        Integer.parseInt(products.get(i).getSpecifications().get(rules.get(j).getTargetSpecKey()).getSpecValue())){
                                    return false;
                                }
                            } catch (NumberFormatException e){
                                if(Integer.parseInt(convertor.convert(product.getSpecifications().get(rules.get(j).getSourceSpecKey()).getSpecValue())) <
                                        Integer.parseInt(convertor.convert(products.get(i).getSpecifications().get(rules.get(j).getTargetSpecKey()).getSpecValue()))){
                                    return false;
                                }
                            }
                        } else { // обратное условие
                            try{
                                if(Integer.parseInt(products.get(i).getSpecifications().get(rules.get(j).getSourceSpecKey()).getSpecValue()) <
                                        Integer.parseInt(product.getSpecifications().get(rules.get(j).getTargetSpecKey()).getSpecValue())){
                                    return false;
                                }
                            } catch (NumberFormatException e){
                                if(Integer.parseInt(convertor.convert(products.get(i).getSpecifications().get(rules.get(j).getSourceSpecKey()).getSpecValue()))<
                                        Integer.parseInt(convertor.convert(product.getSpecifications().get(rules.get(j).getTargetSpecKey()).getSpecValue()))){
                                    return false;
                                }
                            }
                        }
                        break;
                }
            }
        }

        return true;
    }



}