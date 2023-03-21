package cn.wangdpwin.validator.util;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import java.util.Set;

/**
 * @Author wangdongpeng
 * @Date 2023/3/13 18:50
 * @Version 1.0
 */
public class ValidateUtil {

    private static final Validator validator =
            Validation.buildDefaultValidatorFactory().getValidator();

    /**
     * 校验实体类
     */
    public static <T> void validate(T t) {
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(t);
        if (constraintViolations.size() > 0) {
            StringBuilder validateError = new StringBuilder();
            for (ConstraintViolation<T> constraintViolation : constraintViolations) {
                validateError.append(constraintViolation.getMessage()).append(";");
            }

            throw new ValidationException(validateError.toString());
        }
    }

    /**
     * 通过组来校验实体类
     */
    public static <T> void validate(T t, Class<?>... groups) {
        //判断bean对象的成员变量上有无注解，并且注解的校验类是否和groups匹配
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(t, groups);
        //校验不通过的拼接错误信息
        if (constraintViolations.size() > 0) {
            StringBuilder validateError = new StringBuilder();
            for (ConstraintViolation<T> constraintViolation : constraintViolations) {
                validateError.append(constraintViolation.getMessage()).append(";");
            }

            throw new ValidationException(validateError.toString());
        }
    }

}
