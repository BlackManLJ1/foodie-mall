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
        int resultForInsert = stuMapper.insert(stu);
        return resultForInsert == 1? "保存成功": "保存失败";
    }

    @Override
    public String updateStu(Stu stu) {
        int resultForUpdate = stuMapper.updateByPrimaryKey(stu);
        return resultForUpdate == 1? "更新成功": "更新失败";
    }

    @Override
    public String deleteStu(Integer id) {
        int resultForDel = stuMapper.deleteByPrimaryKey(id);
        return resultForDel == 1 ? "删除成功": "删除失败";
    }
}
