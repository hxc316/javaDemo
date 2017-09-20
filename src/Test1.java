import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import org.junit.Test;

/* 
 * @(#)Test1.java    Created on 2013-6-18
 * Copyright (c) 2005-2013 Shunwang. All rights reserved.
 * $Id$
 */

/**
 * @author xc.hu
 * @version $Revision: 1.0 $, $Date: 2013-6-18 下午02:04:04 $
 */
public class Test1 {
    
    @Test
    public void test1(){
        Object rs[] = new Object[10];
//        Object[] s = new Object[10];
        rs[0] = new Integer(1);
        rs[1] = new Double(2);
        
        int[] a = {1,2,3};
        
        List<String> list = new ArrayList<String>();
        
//        it.next();
//        it.add("1");
//        it.remove();
//        System.out.println(it.next().toString());
        list.add("0");
        list.add(1,"1");
        list.remove(1);
        System.out.println(Arrays.asList(list.toArray()));
        
        ListIterator<String> it = list.listIterator();
        System.out.println(it.next());
        System.out.println(it.previous());
        
    }
    
    @Test
    public void testA(){
        System.out.println(A.a);
        A a = new A();
    }
}
class  A{
    
    public A(){
        System.out.println("A constract method");
    }
    
    static int a = 1;
    Bb b = new Bb();
    
    static{
        System.out.println("static java code block");
    }
    
    public void out(){
        System.out.println("out method");
    }
    
    public void out(int i){
        
    }
    
    {
        System.out.println("java code block");
    }
    protected void finalize(){
        System.out.println("finalize method");
    }
}

class Bb{
    
    Bb(){
        System.out.println("b constract method");
    }
    
}