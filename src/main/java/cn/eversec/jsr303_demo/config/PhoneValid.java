package cn.eversec.jsr303_demo.config;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValid implements ConstraintValidator<Phone,String> {
    @Override
    public void initialize(Phone phone) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        String reg = "1\\d{10}";
        Pattern pattern = Pattern.compile(reg);

        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }
}
