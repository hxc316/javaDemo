/* 
 * @(#)UserDao.java    Created on 2012-12-22
 * Copyright (c) 2005-2012 Shunwang. All rights reserved.
 * $Id$
 */
package userLogin.dao;

import java.util.ArrayList;
import java.util.List;

import userLogin.pojo.User;

/**
 * @author xc.hu
 * @version $Revision: 1.0 $, $Date: 2012-12-22 下午06:23:07 $
 */
public class UserDao {

    private final List<User> users;

    /**
     * 构造函数 初始一些数据
     */
    public UserDao() {
        users = new ArrayList<User>();
        User xiaohong = new User();
        xiaohong.setUserName("xiaohong");
        xiaohong.setPassWord("123456");
        users.add(xiaohong);

        User xiaoming = new User();
        xiaoming.setUserName("xiaoming");
        xiaoming.setPassWord("abc123");
        users.add(xiaoming);

    }

    /**
     * 根据用户名获取用户信息
     * 
     * @param userName
     * @return
     */

    public User getUser(String userName) {
        for (User user : users) {
            if (userName.equals(user.getUserName())) {
                return user;
            }
        }
        return null;
    }

}
