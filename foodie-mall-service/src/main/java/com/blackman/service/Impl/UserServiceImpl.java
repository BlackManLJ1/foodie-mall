package com.blackman.service.Impl;

import com.blackman.enums.Sex;
import com.blackman.mapper.UsersMapper;
import com.blackman.pojo.Users;
import com.blackman.pojo.bo.UserBO;
import com.blackman.service.UserService;
import com.blackman.utils.DateUtil;
import com.blackman.utils.MD5Utils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private Sid sid;

    private static final String USER_FACE = "http://122.152.205.72:88/group1/M00/00/05/CpoxxFw_8_qAIlFXAAAcIhVPdSg994.png";


    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public boolean queryUsernameIsExists(String username) {
        Example userExample = new Example(Users.class);
        Example.Criteria userCriteria = userExample.createCriteria();
        userCriteria.andEqualTo("username", username);
        Users users = usersMapper.selectOneByExample(userExample);
        return users == null ? false : true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Users createUser(UserBO userBO) {
        // 0.创建新用户
        Users user = new Users();

        // 1.使用工具类生成随机的用户id
        String id = sid.nextShort();
        user.setId(id);
        String username = userBO.getUsername();
        // 2.设置用户名
        user.setUsername(username);
        try {
            user.setPassword(MD5Utils.getMD5Str(userBO.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 3.设置用户昵称
        user.setNickname(username);
        // 4.设置用户图像
        user.setFace(USER_FACE);
        // 5.设置用户邮箱（使用了默认）
        user.setEmail("123@gmail.com");
        // 6.设置新用户性别（默认为秘密）
        user.setSex(Sex.SECRET.type);
        // 7.新用户生日为默认的2000-01-01
        user.setBirthday(DateUtil.stringToDate("2000-01-01"));
        // 8，创建新用户时间
        user.setCreatedTime(new Date());
        // 9.更新用户时间
        user.setUpdatedTime(new Date());
        // 10.将新用户插入到数据库
        usersMapper.insert(user);
        return user;
    }
}
