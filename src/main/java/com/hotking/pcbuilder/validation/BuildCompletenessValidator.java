package com.hotking.pcbuilder.validation;

import com.hotking.pcbuilder.entity.PcBuild;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class BuildCompletenessValidator implements ConstraintValidator<Build, PcBuild> {
    @Override
    public boolean isValid(PcBuild pcBuild, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
