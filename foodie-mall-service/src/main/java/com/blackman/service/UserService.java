package com.blackman.service;


import com.blackman.pojo.Users;
import com.blackman.pojo.bo.UserBO;

public interface UserService {

    public boolean queryUsernameIsExists(String username);

    public Users createUser(UserBO userBO) throws Exception;
}
