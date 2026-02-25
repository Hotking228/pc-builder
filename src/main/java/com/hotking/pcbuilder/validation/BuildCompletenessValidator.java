package com.hotking.pcbuilder.validation;

import com.hotking.pcbuilder.entity.*;
import com.hotking.pcbuilder.service.CategoryLimitService;
import com.hotking.pcbuilder.service.CompatibilityRuleService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Transactional(readOnly = true)
@Component
@RequiredArgsConstructor
public class BuildCompletenessValidator implements ConstraintValidator<Build, PcBuild> {

    private final CompatibilityRuleService compatibilityService;
    private final CategoryLimitService limitService;

    public boolean isValid(PcBuild pcBuild, Product product){
        if(validParameters(pcBuild, product)){
            return true;
        }

        return false;
    }



    @Override
    public boolean isValid(PcBuild pcBuild, ConstraintValidatorContext constraintValidatorContext) {
        return true;
    }


    private boolean validParameters(PcBuild pcBuild, Product product) {
        LinkedList<Product> products = pcBuild.get();
        for (int i = 0; i < products.size() - 1; i++) {
            List<CompatibilityRule>rules =  compatibilityService.findAllByCategories(products.get(i).getCategory(), product.getCategory());
            for (int j = 0; j < rules.size(); j++) {
                switch (rules.get(j).getOperator()){
                    case IN :

                        break;
                    case EQUALS:
                        if(!product.getSpecifications().get(rules.get(j).getSourceSpecKey()).getSpecValue().equals(products.get(i).getSpecifications().get(rules.get(j).getTargetSpecKey()).getSpecValue())){
                            return false;
                        }
                        break;
                    case CONTAINS:
                        break;
                    case LESS_THAN:
                        break;
                    case NOT_EQUALS:
                        if(product.getSpecifications().get(rules.get(j).getSourceSpecKey()).getSpecValue().equals(products.get(i).getSpecifications().get(rules.get(j).getTargetSpecKey()).getSpecValue())){
                            return false;
                        }
                        break;
                    case GREATER_THAN:
                        break;
                    case LESS_THAN_OR_EQUAL:
                        break;
                    case GREATER_THAN_OR_EQUAL:
                        break;
                }
            }
        }

        return true;
    }



}