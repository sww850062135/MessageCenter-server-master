package com.sww.message.controller;

import com.alibaba.fastjson.JSONObject;
import com.sww.message.entity.JsonResult;
import com.sww.message.entity.User1;
import com.sww.message.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/v1/users")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    //登录
    @CrossOrigin(origins = "*")  // 允许跨域请求
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseEntity<JsonResult> login(@RequestBody Map<String, String> map){
        String username = map.get("username");
        String password = map.get("password");
        logger.info("登录请求...username="+username+"  pwd="+password);
        JsonResult result = new JsonResult();
        if ("admin".equals(username) && "admin".equals(password)){
            User1 user1 = userService.getUserByUsername(username);
            result.setStatus("success");
            result.setMsg("登录成功");
            result.setResult(user1);
            logger.info("用户:"+ user1 + "成功登录!");
        }else {
            result.setStatus("error");
            result.setMsg("账号或密码错误，登录失败!");
        }
        return ResponseEntity.ok(result);
    }

    //修改个人信息
    @CrossOrigin(origins = "*") //允许跨域请求
    @RequestMapping(value = "/changeProfile", method = RequestMethod.POST)
    public ResponseEntity<JsonResult> changeProfile(@RequestBody JSONObject jsonObject){
        logger.info("修改用户信息...");
        int id = jsonObject.getInteger("id");
        String phone = jsonObject.getString("phone");
        String email = jsonObject.getString("email");
        User1 user = userService.getUserById(id);
        //User1 user = new User1();
        user.setPhone(phone);
        user.setEmail(email);
        System.out.println(user);
        JsonResult result = new JsonResult();
        int code = userService.update(user);
        if (code==1){
            result.setStatus("success");
            result.setMsg("个人信息修改成功!");
            result.setResult(user);
        }else{
            result.setStatus("error");
            result.setMsg("用户不存在，修改失败!");
        }
        return ResponseEntity.ok(result);

    }

    //登出
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(){
        logger.info("退出登录!");
        return "/login";
    }



}
