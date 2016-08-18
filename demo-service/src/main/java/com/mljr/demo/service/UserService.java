package com.mljr.demo.service;

import com.mljr.demo.bean.User;

import java.util.List;

/**
 * Created by ASUS on 2016/8/18.
 */
public interface UserService {

    List<User> query();

    User get(Long userId);

    User add(String name, String password);

    User update(Long userId, String password);

}
