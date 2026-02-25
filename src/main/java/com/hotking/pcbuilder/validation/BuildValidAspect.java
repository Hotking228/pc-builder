package com.hotking.pcbuilder.validation;

import jakarta.validation.ConstraintViolation;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import jakarta.validation.Validator;
import org.springframework.validation.annotation.Validated;

import java.util.Set;

@Aspect
@Component
@RequiredArgsConstructor
public class BuildValidAspect {

    private final Validator validator;

    @Pointcut("execution(* com.hotking.pcbuilder.validation.PcBuild.addComponent(*))")
    public void addComponentCheck(){

    }

    @After(value = "addComponentCheck()")
    public void validationAfterAddComponent(JoinPoint joinPoint){
        PcBuild build = (PcBuild) joinPoint.getTarget();

        Set<ConstraintViolation<PcBuild>> violations = validator.validate(build);

        if(!violations.isEmpty()) {
            build.removeLastComponent();
        }
    }
}
