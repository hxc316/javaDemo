/* 
 * @(#)AlwaysEvent.java    Created on 2013-6-20
 * Copyright (c) 2005-2013 Shunwang. All rights reserved.
 * $Id$
 */
package thread.base1;

/**
 * @author xc.hu
 * @version $Revision: 1.0 $, $Date: 2013-6-20 上午10:31:22 $
 */
public class AlwaysEvent {
    
    private int i;
    public void next(){
        i++;i++;
    }
    
    public int getValue(){
        return i;
    }
    
    public static void main(String[] args) {
        final AlwaysEvent ae = new AlwaysEvent();
        new Thread("watcher"){
            public void run() {
                while(true){
                    int val = ae.getValue(); 
                    if(val % 2 != 0){
                        System.out.println(val);//总能输出奇数，说明i的值是不稳定状态的
                        System.exit(0);
                    }
                }
            }
        }.start();
        
        while(true){
            ae.next();
        }
    }
    

}
