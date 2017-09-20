/* 
 * @(#)Test.java    Created on 2013-12-31
 * Copyright (c) 2005-2013 Shunwang. All rights reserved.
 * $Id$
 */
package projectTest.barPro.classChange;

import org.junit.Test;

/**
 * @author xc.hu
 * @version $Revision: 1.0 $, $Date: 2013-12-31 下午06:31:26 $
 */
public class TestChange {
    
    @Test
    public void test1(){
        
        B b = new B();
        A a = null;
        a = (A) b;
        System.out.println(a.getA());
    }
    
    @Test
    public void test2(){
        
        A a = new A();
        B b = null;
        b = (B)a;
        System.out.println(b.getA());
    }

}
