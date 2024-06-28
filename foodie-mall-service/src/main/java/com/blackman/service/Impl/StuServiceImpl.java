package com.blackman.service.Impl;

import com.blackman.mapper.StuMapper;
import com.blackman.pojo.Stu;
import com.blackman.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StuServiceImpl implements StuService {

    @Autowired
    private StuMapper stuMapper;

    @Override
    public Stu getStuInfo(Integer id) {
        return stuMapper.selectByPrimaryKey(id);
    }

    @Override
    public String saveStu(Stu stu) {
        return stuMapper.insert(stu) + "";
    }

    @Override
    public String updateStu(Stu stu) {
        return stuMapper.updateByPrimaryKey(stu) + "";
    }

    @Override
    public String deleteStu(Integer id) {
        return stuMapper.deleteByPrimaryKey(id) + "";
    }
}
