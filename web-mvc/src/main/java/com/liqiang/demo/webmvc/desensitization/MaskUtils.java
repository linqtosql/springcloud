package com.liqiang.demo.webmvc.desensitization;

import org.apache.commons.lang3.StringUtils;

/**
 * @title: MaskUtils
 * @description: 掩码工具类
 * @Copyright: Copyright (c) 2018
 * @Company: lgxkdream.github.io
 * @author gang.li
 * @version 1.0.0
 * @since 2018年3月19日 上午10:59:57
 */
public class MaskUtils {
    public static String maskCellphone(String cellphoneNo) {
        if ((cellphoneNo == null) || (cellphoneNo.trim().length() != 11)) {
            return cellphoneNo;
        }
        return cellphoneNo.substring(0, 3) + "****" + cellphoneNo.substring(cellphoneNo.length() - 4);
    }

    public static String maskEmail(String email) {
        if (StringUtils.isBlank(email)) {
            return "";
        }
        int index = StringUtils.indexOf(email, "@");
        if (index <= 1)
            return email;
        else
            return StringUtils.rightPad(StringUtils.left(email, 1), index, "*")
                    .concat(StringUtils.mid(email, index, StringUtils.length(email)));
    }

    private static String maskCardNo(String cardNo) {
        if ((cardNo == null) || (cardNo.trim().length() <= 8)) {
            return cardNo;
        }
        cardNo = cardNo.trim();
        int length = cardNo.length();
        String firstFourNo = cardNo.substring(0, 4);
        String lastFourNo = cardNo.substring(length - 4);
        String mask = "";
        for (int i = 0; i < length - 8; i++) {
            mask = mask + "*";
        }
        return firstFourNo + mask + lastFourNo;
    }

    public static String maskIDCardNo(String idCardNo) {
        return maskCardNo(idCardNo);
    }

    public static String maskBankCardNo(String bankCardNo) {
        return maskCardNo(bankCardNo);
    }

}
