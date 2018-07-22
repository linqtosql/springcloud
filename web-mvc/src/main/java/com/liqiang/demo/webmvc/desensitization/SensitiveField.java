package com.liqiang.demo.webmvc.desensitization;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @title: SensitiveField
 * @description: 掩码注解
 * @Copyright: Copyright (c) 2018
 * @Company: lgxkdream.github.io
 * @author gang.li
 * @version 1.0.0
 * @since 2018年3月19日 上午11:01:45
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotationsInside
@JsonSerialize(using = SensitiveInfoSerialize.class)
@Documented
public @interface SensitiveField {

    SensitiveTypeEnum value() default SensitiveTypeEnum.IDCARD;

    enum SensitiveTypeEnum {
        IDCARD,
        BANKCARD,
        MOBILE,
        EMAIL,
        CVV;
    }

}
