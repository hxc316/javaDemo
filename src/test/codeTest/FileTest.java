/* 
 * @(#)FileTest.java    Created on 2010-9-6
 * Copyright (c) 2005-2010 Shunwang. All rights reserved.
 * $Id$
 */
package test.codeTest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

/**
 * @author xc.hu
 * @version $Revision: 1.0 $, $Date: 2010-9-6 下午03:53:17 $
 */
public class FileTest extends TestCase {

    public void estFile() {
        try {
            File.createTempFile("aa33s", "txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testStringcache() {
        System.out.println(System.getProperty("tomcat.util.buf.StringCache.cacheSize", "300"));
    }

    public void testFor() {
        // for (int i = 0; i < 2; i++) {
        // System.out.println(i);
        // }
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            list.remove(0);
        }

    }
}
