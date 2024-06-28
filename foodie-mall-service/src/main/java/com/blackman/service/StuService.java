package com.blackman.service;

import com.blackman.pojo.Stu;
import org.springframework.stereotype.Service;

public interface StuService {

    /**
     * 通过id获取学习信息
     * @param id 学生学号
     * @return 学生信息
     */
    public Stu getStuInfo(Integer id);

    /**
     * 保存学生信息
     * @param stu 学生信息
     * @return 返回是否保存成功状态码
     */
    public String saveStu(Stu stu);

    /**
     * 修改学习信息
     * @param stu 学生信息
     * @return 返回是否成功状态码
     */
    public String updateStu(Stu stu);

    /**
     * 根据id删除学生信息
     * @param id 学生学号
     * @return 返回是否删除成功状态码
     */
    public String deleteStu(Integer id);
}
