package com.xuan.swaggertest.controller;

import com.xuan.swaggertest.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
@Api(tags = "测试控制类")
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @PostMapping("/user")
    public User user(){
        return new User("xuan","1234");
    }

    @ApiOperation("查询用户")
    @PostMapping("/user2")
    public User user2(@ApiParam("用户名") String name){
        return new User(name,"1234");
    }
}
