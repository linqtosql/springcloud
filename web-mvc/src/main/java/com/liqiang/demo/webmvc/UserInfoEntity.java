package com.liqiang.demo.webmvc;

import com.liqiang.demo.webmvc.desensitization.SensitiveField;
import com.liqiang.demo.webmvc.desensitization.SensitiveReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @title: MyEntity
 * @description: 测试实体
 * @Copyright: Copyright (c) 2018
 * @Company: lgxkdream.github.io
 * @author gang.li
 * @version 1.0.0
 * @since 2018年3月19日 上午11:21:04
 */
public class UserInfoEntity {

    /**
     * 证件号
     */
    @SensitiveField
    private String idNo;

    /**
     * 手机号
     */
    @SensitiveField(SensitiveField.SensitiveTypeEnum.MOBILE)
    private String mobile;

    /**
     * 姓名
     */
    private String name;

    /**
     * 邮箱
     */
    @SensitiveField(SensitiveField.SensitiveTypeEnum.EMAIL)
    private String email;

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return new SensitiveReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).toString();
    }

}

