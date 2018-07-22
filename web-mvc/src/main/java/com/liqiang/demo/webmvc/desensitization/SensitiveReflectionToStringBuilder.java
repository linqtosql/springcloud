package com.liqiang.demo.webmvc.desensitization;

import java.lang.reflect.Field;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @title: SensitiveReflectionToStringBuilder
 * @description: 重写用于toString的ReflectionToStringBuilder
 * @Copyright: Copyright (c) 2018
 * @Company: lgxkdream.github.io
 * @author gang.li
 * @version 1.0.0
 * @since 2018年3月19日 上午11:06:20
 */
public class SensitiveReflectionToStringBuilder extends ReflectionToStringBuilder {

    public SensitiveReflectionToStringBuilder(Object object, ToStringStyle style) {
        super(object, style);
    }

    @Override
    protected Object getValue(Field field) throws IllegalArgumentException, IllegalAccessException {
        if (field.getType() == String.class && field.isAnnotationPresent(SensitiveField.class)) {
            String v = (String) field.get(this.getObject());
            switch (field.getAnnotation(SensitiveField.class).value()) {
                case IDCARD:
                    return MaskUtils.maskIDCardNo(v);
                case BANKCARD:
                    return MaskUtils.maskBankCardNo(v);
                case MOBILE:
                    return MaskUtils.maskCellphone(v);
                case EMAIL:
                    return MaskUtils.maskEmail(v);
                case CVV:
                    return v == null ? null : "***";
                default:
                    return v;
            }
        }
        return field.get(this.getObject());
    }

}

