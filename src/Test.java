import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.shunwang.common.util.date.DateUtil;

public class Test {

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");
        for (Iterator<String> it = list.iterator(); it.hasNext();) {
            it.next();
            System.out.println("ok ");
            if (true) {
                break;
            }
            it.remove();
            System.out.println("remove");
        }
        System.out.println(111);
    }
    
    @org.junit.Test
    public void test2(){
        Calendar cal = Calendar.getInstance();
//        cal.setTime(new Date());
//        DateUtil
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(f.format(cal.getTime()));
    }

}
