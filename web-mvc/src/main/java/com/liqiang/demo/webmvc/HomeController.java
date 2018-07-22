package com.liqiang.demo.webmvc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping("")
    public UserInfoEntity Home(){
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        userInfoEntity.setEmail("liqiang@qq.com");
        userInfoEntity.setMobile("15168438278");
        userInfoEntity.setIdNo("421086523987452011");
        return userInfoEntity;
    }
}
