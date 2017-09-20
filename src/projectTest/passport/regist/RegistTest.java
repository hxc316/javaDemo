/* 
 * @(#)RegistTest.java    Created on 2013-12-2
 * Copyright (c) 2005-2013 Shunwang. All rights reserved.
 * $Id$
 */
package projectTest.passport.regist;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.shunwang.common.util.cryptor.MD5Encrypt;
import com.shunwang.util.date.DateUtil;
import com.shunwang.util.encrypt.AesEncrypt;
import com.shunwang.util.encrypt.Md5Encrypt;
import com.shunwang.util.net.HttpUtil;

/**
 * @author xc.hu
 * @version $Revision: 1.0 $, $Date: 2013-12-2 上午11:15:33 $
 */
public class RegistTest {
    
    public String url = "http://interface.kedou.com/front/interface/outRegister.htm";
    
    String siteId = "star_sale";
    String regIP = "192.168.172.190";
    String userName = "reg002";
    String userType = "1";
    String password = "abc#123";
    
    private String kekou_aesKey = "6rV82fu_e3.tw5A8";
    private String kedou_key = "TYTEY!@#%$#>!@##$$OIUGVCX>!@#$";
    
    private String[] params = {"siteId","siteVersion","regEnvironment","regIP",
            "userName","userType","_password","email","mobile","protectQuestionId1",
            "protectQuestionId2","protectQuestionId3","protectAnswer1","protectAnswer2",
            "protectAnswer3","realName","identity","companyName","linkMan ","time"};
    
    
    @Test
    public void testRegist(){
        Map<String,String> data = new HashMap<String, String>();
        data.put("siteId", siteId);
        data.put("regIP", regIP);
        data.put("userName",userName);
        data.put("userType", userType);
        data.put("time", DateUtil.getCurrentDateStamp());
        try {
            data.put("password", AesEncrypt.Encrypt(Md5Encrypt.encrypt(password), kekou_aesKey));
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        data.put("sign",getSign(data));
        try {
            String xml = HttpUtil.doPost(url, data);
            System.out.println(xml);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    String getSign(Map<String, String> signData){
            StringBuffer sbffer = new StringBuffer();
            signData.put("_password", Md5Encrypt.encrypt(password));
            for(int i=0;i<params.length;i++){
                if(signData.get(params[i]) != null){
                    sbffer.append(signData.get(params[i]));
                }
                sbffer.append("|");
            }
            sbffer.append(kedou_key);
            System.out.println(sbffer.toString());
            try {
                return Md5Encrypt.encrypt(URLEncoder.encode(sbffer.toString(),"utf-8").toUpperCase()).toUpperCase();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            signData.remove(signData.get("_password"));// 就用一下参数的数据加密   
            return "";
        }
}
