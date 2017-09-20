/* 
 * @(#)UserLoginTest.java    Created on 2012-12-22
 * Copyright (c) 2005-2012 Shunwang. All rights reserved.
 * $Id$
 */
package userLogin.test;

import userLogin.action.UserAction;

/**
 * @author xc.hu
 * @version $Revision: 1.0 $, $Date: 2012-12-22 下午06:41:33 $
 */
public class UserLoginTest {

    /*
     * 步骤：
     * 1，调用跳转控制类 验证用户信息输入是否合法  
     *      如果合法： 调用业务控制类 进行验证 ，业务类调用数据访问类 获取系统数据 根据返回的数据进行对比 
     *      
     * 
     */
    public static void main(String[] args) {
        UserAction action = new UserAction();
        action.userLogin("", "123456");

    }

}
