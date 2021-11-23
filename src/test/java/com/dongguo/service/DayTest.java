package com.dongguo.service;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author dongguo
 * @date 2021/11/18
 */
public class DayTest {
    @Test
    public void getHourMin(){
        String s = formatDuring(950399000l);
        System.out.println(s);
    }

    public static String formatDuring(long mss) {
        if(mss == 0){
            return "0分";
        }
        long hours = mss / (1000 * 60 * 60);
        long minutes = (mss % (1000 * 60 * 60)) / (1000 * 60);
        if (hours == 0){
            return minutes+"分";
        }
        return hours + "时" + minutes + "分";
    }

    @Test
    public void doubleTo() {
        double result_value = 0.1;
        String format = String.format("%.2f", result_value);
        System.out.println(format);

        Double handler = handler(result_value);
        System.out.println(handler);
    }
    private static final int DECIMAL_DIGIT = 2;

    public static Double handler(Double amount) {
        return roundHalfUp(amount);
    }

    /**
     * 四舍五入.
     * @param amount 金额
     * @return 金额
     */
    private static Double roundHalfUp(Double amount) {
        BigDecimal bigDecimal = new BigDecimal(amount);
        return bigDecimal.setScale(DECIMAL_DIGIT, BigDecimal.ROUND_HALF_UP).doubleValue();
//        return bigDecimal.doubleValue();
    }



    //日期转时间戳
    @Test
    public void getMins() {
        String startTime = "2020-11-19 00:00:00";
        String endTime = "2021-11-19 23:59:59";


        Date startDate = convertToDate(startTime, "yyyy-MM-dd HH:mm:ss");
        Date endDate = convertToDate(endTime, "yyyy-MM-dd HH:mm:ss");
        System.out.println(startDate.getTime());
        System.out.println(endDate.getTime());
    }
    //时间戳转日期
    @Test
    public void gettime() {
       Long time =  1629701365000L;
        String s = timeStamp2Date(time.toString(), null);
        System.out.println(s);
    }


    public static String timeStamp2Date(String time,String format) {

        if(format == null || format.isEmpty()){
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(Long.valueOf(time)));
    }

    @Test
    public void getDays(){
        Calendar calendar1 = Calendar.getInstance();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
        calendar1.add(Calendar.DATE, -365);
        String three_days_ago = sdf1.format(calendar1.getTime());
        System.out.println(three_days_ago);
    }
    public static Date convertToDate(String source, String pattern) {
        Date date = null;

        try {
            DateFormat dateFormat = new SimpleDateFormat(pattern);
            date = dateFormat.parse(source);
        } catch (ParseException var4) {
            var4.printStackTrace();
        }

        return date;
    }
}
