/* 
 * @(#)User.java    Created on 2012-12-22
 * Copyright (c) 2005-2012 Shunwang. All rights reserved.
 * $Id$
 */
package userLogin.pojo;

/**
 * @author xc.hu
 * @version $Revision: 1.0 $, $Date: 2012-12-22 下午06:15:05 $
 */
public class User {

    private String userName;
    private String passWord;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

}
