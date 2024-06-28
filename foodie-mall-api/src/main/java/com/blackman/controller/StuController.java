package com.blackman.controller;

import com.blackman.pojo.Stu;
import com.blackman.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/stu")
public class StuController {

    @Autowired
    private StuService stuService;

    @GetMapping("/getStuInfo")
    public Stu getStuInfo(Integer id) {
       return stuService.getStuInfo(id);
    }
}
