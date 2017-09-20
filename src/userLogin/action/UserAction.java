/* 
 * @(#)UserAction.java    Created on 2012-12-22
 * Copyright (c) 2005-2012 Shunwang. All rights reserved.
 * $Id$
 */
package userLogin.action;

import userLogin.bo.UserBo;
import userLogin.pojo.User;

/**
 * 跳转中转层 (暂时用不到)
 * 
 * @author xc.hu
 * @version $Revision: 1.0 $, $Date: 2012-12-22 下午06:40:02 $
 */
public class UserAction {

    /**
     * 用户登陆功能方法
     * 
     * @param username
     * @param password
     */
    public void userLogin(String username, String password) {
        User u = new User();
        // 检查用户输入是否合法
        if (username == null || "".equals(username)) {
            System.out.println("用户名不能为空!");
            return;
        }
        u.setUserName(username);
        if (password == null || "".equals(password)) {
            System.out.println("请输入用户密码!");
            return;
        }
        u.setPassWord(password);
        // 调用用户登陆业务类 验证结果
        UserBo bo = new UserBo();
        Boolean rs = bo.login(u);
        if (rs) {
            System.out.println("输入正确,登陆成功!");
        } else {
            System.out.println("请检查你的用户名和密码是否输入正确!");
        }
    }

}
