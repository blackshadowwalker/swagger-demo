package com.mljr.demo.service.impl;

import com.google.common.collect.Lists;
import com.mljr.demo.bean.User;
import com.mljr.demo.bean.em.UserStatus;
import com.mljr.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by ASUS on 2016/8/18.
 */
@Service
public class UserServiceImpl implements UserService{

    Map<Long, User> store = new ConcurrentHashMap<Long, User>();

    static AtomicLong id = new AtomicLong(0);

    public List<User> query() {
        return Lists.newArrayList(store.values().iterator());
    }

    @PostConstruct
    public void init(){
        User user = new User();
        user.setId(id.incrementAndGet());
        user.setName("用户姓名");
        user.setPassword("123456");
        user.setStatus(UserStatus.NORMAL);
        store.put(user.getId(), user);
    }

    public User get(Long userId) {
        return store.get(userId);
    }

    public User add(String name, String password) {
        User user = new User();
        user.setId(id.incrementAndGet());
        user.setName(name);
        user.setPassword(password);
        user.setStatus(UserStatus.NORMAL);
        store.put(user.getId(), user);
        return user;
    }

    public User update(Long userId, String password) {
        User user = store.get(userId);
        if (user != null) {
            user.setPassword(password);
        }
        return user;
    }

}
