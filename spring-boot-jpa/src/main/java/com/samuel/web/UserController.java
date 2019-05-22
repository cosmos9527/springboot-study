package com.samuel.web;

import com.samuel.entity.User;
import com.samuel.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/getUser/{id}")
    @ResponseBody
    public User getUser(@PathVariable("id") Long id){
        logger.info("根据id查询用户信息!入参:id = {}",id);
        User user = userService.getUserById(id);
        return user;
    }

    @PostMapping("/save")
    @ResponseBody
    public String saveUser(User user){
        logger.info("添加新用户!入参:id = {}",user);
        String retMsg = "";
        try{
            userService.saveUser(user);
            retMsg = "新增用户成功！";
        }catch (Exception e){
            retMsg = "新增用户失败！";
            e.printStackTrace();
        }
        return retMsg;
    }

    @PostMapping("/update")
    @ResponseBody
    public String updateUser(User user){
        logger.info("更新用户信息!入参:id = {}",user);
        String retMsg = "";
        try{
            userService.updateUser(user);
            retMsg = "更新用户信息成功！";
        }catch (Exception e){
            retMsg = "更新用户信息失败！";
            e.printStackTrace();
        }
        return retMsg;
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public String deleteUser(@PathVariable("id") Long id){
        logger.info("根据id删除用户信息!入参:id = {}",id);
        String retMsg = "";
        try{
            userService.removeUser(id);
            retMsg = "更新用户信息成功！";
        }catch (Exception e){
            retMsg = "更新用户信息失败！";
            e.printStackTrace();
        }
        return retMsg;
    }

    @GetMapping("/getUserList")
    @ResponseBody
    public List<User> getUserList(){
        logger.info("用户信息列表!");
        List<User> users = userService.getUserList();
        return users;
    }
}
