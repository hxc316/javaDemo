/* 
 * @(#)LoginTest.java    Created on 2013-11-29
 * Copyright (c) 2005-2013 Shunwang. All rights reserved.
 * $Id$
 */
package projectTest.passport.login;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.shunwang.common.util.cryptor.MD5Encrypt;
import com.shunwang.util.date.DateUtil;
import com.shunwang.util.encrypt.AesEncrypt;
import com.shunwang.util.encrypt.Md5Encrypt;
import com.shunwang.util.net.HttpUtil;



/**
 * @author xc.hu
 * @version $Revision: 1.0 $, $Date: 2013-11-29 下午01:05:48 $
 */
public class LoginTest{
    
    public static String url = "http://interface.kedou.com/front/interface/outLogin.htm";
    private String userName = "reg001";
    private String password = "abc#123";
    private String kekou_aesKey = "6rV82fu_e3.tw5A8";
    private String kedou_key = "TYTEY!@#%$#>!@##$$OIUGVCX>!@#$";
    private String siteId = "star_sale";
    
    private String[] params = {"siteId","userName","loginEnvironment","loginIp","siteVersion" };
    
    Logger looger = LoggerFactory.getLogger(LoginTest.class);
    
    @Test
    public void test1(){
        Map<String, String> params = new HashMap<String, String>();
        params.put("siteId", siteId);
        params.put("userName", userName);
        System.out.println(params.toString());
        
    }
    @Test
    public void loginInter() throws Exception{
        Map<String, String> params = new HashMap<String, String>();
        if(looger.isDebugEnabled()){
            System.out.println("debug 模式！");
        }
        params.put("siteId", siteId);
        params.put("userName", userName);
        params.put("password", AesEncrypt.Encrypt(MD5Encrypt.encode(password), kekou_aesKey));
        params.put("loginIp", "192.168.172.90");
        params.put("time", DateUtil.getCurrentDateStamp());
        params.put("sign", initInter(params));
        try {
            String xml = HttpUtil.doPost(url, params);
            System.out.println(xml);
        } catch (Exception e) {
            throw new RuntimeException("调用{0}接口错误",e);
        }
    }
    
    public String initInter(Map<String,String> signData){
        StringBuffer sbffer = new StringBuffer();
        for(int i=0;i<params.length;i++){
            if(signData.get(params[i]) != null){
                sbffer.append(signData.get(params[i]));
            }
            sbffer.append("|");
        }
        sbffer.append(MD5Encrypt.encode(password));
        sbffer.append("|");
        sbffer.append(DateUtil.getCurrentDateStamp());
        sbffer.append("|");
        sbffer.append("TYTEY!@#%$#>!@##$$OIUGVCX>!@#$");
        System.out.println("-----------sign签名结果："+sbffer.toString());
        try {
            return Md5Encrypt.encrypt(URLEncoder.encode(sbffer.toString(),"utf-8").toUpperCase()).toUpperCase();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

}
