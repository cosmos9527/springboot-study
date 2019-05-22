package com.samuel.web;

import com.alibaba.fastjson.JSON;
import com.samuel.model.User;
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

    @PostMapping("/save")
    @ResponseBody
    public String save(User user){
        logger.info("添加用户信息!入参:{}", JSON.toJSONString(user));

        int result = userService.save(user);

        if(result > 0){
            return "添加成功!";
        }

        return "添加失败!";
    }

    @PostMapping("/update")
    @ResponseBody
    public String update(User user){
        logger.info("修改用户信息!入参:{}",JSON.toJSONString(user));
        try {
            int result = userService.update(user);

            if(result > 0){
                return "更新成功!";
            }else {
                return "更新失败!";
            }
        }catch (Exception e){
            e.printStackTrace();
            return "更新数据时发生异常" + e.getMessage();
        }

    }

    @GetMapping("/find/{id}")
    @ResponseBody
    public User find(@PathVariable("id") Long id){
        logger.info("查询单个用户信息!入参:{}",id);

        return userService.find(id);
    }

    @GetMapping("/remove/{id}")
    @ResponseBody
    public String remove(@PathVariable("id") Long id){
        logger.info("删除单个用户信息!入参:{}",id);

        int result = userService.delete(id);
        if(result > 0){
            return "删除成功!";
        }

        return "删除失败!";
    }

    @GetMapping("/findAll")
    @ResponseBody
    public List<User> find(){
        logger.info("查询用户列表!");

        return userService.findAll();
    }

}
