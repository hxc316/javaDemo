/* 
 * @(#)UserBo.java    Created on 2012-12-22
 * Copyright (c) 2005-2012 Shunwang. All rights reserved.
 * $Id$
 */
package userLogin.bo;

import userLogin.dao.UserDao;
import userLogin.pojo.User;

/**
 * @author xc.hu
 * @version $Revision: 1.0 $, $Date: 2012-12-22 下午06:16:22 $
 */
public class UserBo {
    /**
     * 用户登陆 判断
     * 
     * @param user
     * @return
     */
    public Boolean login(User user) {
        // 检查 数据是否合法
        if (user == null || user.getUserName() == null || user.getPassWord() == null) {
            return false;
        }
        // 调用数据访问类 获取系统数据
        UserDao dao = new UserDao();
        User userdb = dao.getUser(user.getUserName());
        // 用户不存在
        if (userdb == null) {
            return false;
        }
        // 用户密码错误
        if (userdb.getPassWord().equals(user.getPassWord())) {
            return true;
        }
        return false;
    }
}
