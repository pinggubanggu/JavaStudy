package JavaStudy06;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Example {

    public static void main(String[] args) {

        // 1. Calendar를 Date로 변환
        Calendar cal = Calendar.getInstance();
        Date d = new Date(cal.getTimeInMillis()); // Date(long date)

        // 2. Date를 Calendar로 변환
        Date d1 = new Date();
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(d1);



    }


}
