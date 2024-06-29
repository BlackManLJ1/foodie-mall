package com.blackman.controller;

import com.blackman.pojo.Stu;
import com.blackman.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stu")
public class StuController {

    @Autowired
    private StuService stuService;

   @GetMapping("/getStuInfo")
   public Stu getStuInfo(@RequestParam(name="id") Integer id) {
       return stuService.getStuInfo(id);
   }

}
