package com.blackman.controller;

import com.blackman.pojo.Stu;
import com.blackman.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stu")
public class StuController {

    @Autowired
    private StuService stuService;

   @GetMapping("/getStuInfo")
   public Stu getStuInfo(@RequestParam(name="id") Integer id) {
       return stuService.getStuInfo(id);
   }

   @PostMapping("/saveStu")
   public String saveStu(@RequestBody Stu stu) {
       return stuService.saveStu(stu);
   }

   @PutMapping("/updateStu")
   public String updateStu(@RequestBody Stu stu) {
       return stuService.updateStu(stu);
   }

   @DeleteMapping("/deleteStu")
   public String deleteStu(@RequestParam(name = "id") Integer id) {
       return stuService.deleteStu(id);
   }
}
