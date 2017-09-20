/* 
 * @(#)DoubleDataFormat.java    Created on 2013-9-11
 * Copyright (c) 2005-2013 Shunwang. All rights reserved.
 * $Id$
 */
package test.dataFromat;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Calendar;

import org.junit.Test;

import freemarker.template.SimpleDate;

/**
 * @author xc.hu
 * @version $Revision: 1.0 $, $Date: 2013-9-11 下午01:17:50 $
 */
public class DoubleDataFormat{
    
    @Test
    public void testDoubleDataFromat(){
        NumberFormat format = NumberFormat.getInstance();
        format.setMaximumFractionDigits(2);// 保留最大的小数位数 会进行四舍五入的
        String rs = format.format(2.99690009);
        System.out.println(rs);
    }
    @Test
    public void getLastMonth(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH)-1);
//        DateFormat format = new SimpleDate(date)
        System.out.println(calendar.getTimeZone());
        
    }

}
