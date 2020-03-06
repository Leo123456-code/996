package com.imooc.coupon.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ClassName: PhoneValidator
 * Description: 自定义手机号约束注解关联验证器
 * Author: Leo
 * Date: 2020/3/5-16:12
 * email 1437665365@qq.com
 */
public class PhoneValidator implements ConstraintValidator<Phone,String> {
    /**
     * 自定义效验逻辑方法
     * @param value
     * @param context
     * @return
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        //手机号验证规则
        String check = "^(\\d{3,4}-)?\\d{7,8}$|(1[3|5|7|8]\\d{9})";
        Pattern regex = Pattern.compile(check);
        //空值处理
        String phone = Optional.ofNullable(value).orElse("");
        Matcher matcher = regex.matcher(phone);

        return matcher.matches();
    }


}
