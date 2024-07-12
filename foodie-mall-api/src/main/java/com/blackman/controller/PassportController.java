package com.blackman.controller;

import com.blackman.pojo.bo.UserBO;
import com.blackman.service.UserService;
import com.blackman.utils.IMOOCJSONResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/passport")
public class PassportController {

    @Autowired
    private UserService userService;

    @GetMapping ("/usernameIsExists")
    public IMOOCJSONResult usernameIsExists(@RequestParam String username) {
        // 1.判断前端传过来的字符串是否为空
        if (StringUtils.isBlank(username)) {
            IMOOCJSONResult.errorMsg("用户名不能为空");
        }

        // 2.判断该用户是否存在
        boolean result = userService.queryUsernameIsExists(username);
        if (result) {
            return IMOOCJSONResult.errorMsg("该用户已经存在");
        }

        return IMOOCJSONResult.ok();
    }

    @PostMapping("/register")
    public IMOOCJSONResult register(@RequestBody UserBO userBO) {
       // 1.获取前端传过来的参数

    }

}
