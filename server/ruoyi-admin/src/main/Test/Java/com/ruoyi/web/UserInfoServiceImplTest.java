package com.ruoyi.color.service.impl;

import com.ruoyi.color.domain.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
// (classes = RouYiApplication.class)
//@ContextConfiguration
class UserInfoServiceImplTest {
    @Autowired
    private UserInfoServiceImpl userInfoService;

    @Test
    void TestUserInfoSever(){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(123456L);
        userInfo.setUserName("TestUser");
        userInfo.setPassword("123456.");
        userInfoService.insertUserInfo(userInfo);
//        return true;
    }


}