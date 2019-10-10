package io.github.xieyinglin.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class DateUtil {

    public static final String yyyyMMdd = "yyyyMMdd";

    public static final String yyyy_MM_dd = "yyyy-MM-dd";

    /**
     * parse dateStr with selected pattern
     * 
     * @param dateStr
     * @param pattern
     * @return
     * @throws ParseException
     */
    public static Date parseDate(String dateStr, String pattern) throws ParseException {

        DateFormat dateFormat = new SimpleDateFormat(pattern);
        
        return dateFormat.parse(dateStr);

    }

    /**
     * add days
     * @param date
     * @param addDays
     * @return
     */
    public static Date addDate(Date date, Integer addDays){

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.add(Calendar.DAY_OF_MONTH, addDays);

        return calendar.getTime();
    }

    /**
     * add days and return string
     * @param yyyyMMdd
     * @param pattern
     * @param addDays
     * @return
     * @throws ParseException
     */
    public static String addDate(String yyyyMMdd, String pattern, Integer addDays) throws ParseException {

        Date endDate = DateUtil.parseDate(yyyyMMdd, pattern);
        endDate = DateUtil.addDate(endDate, addDays);
        
        return DateUtil.format(endDate, pattern);

    }

    /**
     * format date 
     * @param date
     * @param pattern
     * @return
     */
    public static String format(Date date, String pattern){
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }


    /**
     * get days between startDate and endDate
     * @param startDateStr  inlcude
     * @param endDateStr    inlcude
     * @param paramPattern
     * @param destPattern
     * @return
     * @throws ParseException
     */
    public static List<String> getDateList(String startDateStr, String endDateStr, String paramPattern, String destPattern)
            throws ParseException {
        
        Date startDate = parseDate(startDateStr, paramPattern);
        Date endDate = parseDate(endDateStr, paramPattern);
        
        if(startDate.after(endDate)){
            return null;
        }

        long days = (endDate.getTime() - startDate.getTime()) / 24 / 3600 / 1000 ;

        List<String> resultList = new ArrayList<String>();
        resultList.add(format(startDate, destPattern));

        for(int i = 0; i < days; i++){
            startDate = addDate(startDate, 1);
            resultList.add(format(startDate, destPattern));
        }

        return resultList;
    }

    /**
     * get days between startDate and endDate， the destPattern same with paramPattern
     * @param startDateStr
     * @param endDateStr
     * @param paramPattern
     * @return
     * @throws ParseException
     */
    public static List<String> getDateList(String startDateStr, String endDateStr, String paramPattern)
            throws ParseException {
            return getDateList(startDateStr, endDateStr, paramPattern, paramPattern);
    }

    public static void main(String[] args) throws ParseException {
        String endYYYYMMDD = "20190930";
        Date endDate = DateUtil.parseDate(endYYYYMMDD, DateUtil.yyyyMMdd);
        endDate = DateUtil.addDate(endDate, 1);
        
        endYYYYMMDD = DateUtil.format(endDate, DateUtil.yyyyMMdd);

        log.info("endYYYYMMDD {}", endYYYYMMDD);

        log.info("day list {}", getDateList("20190901", "20190910", DateUtil.yyyyMMdd, DateUtil.yyyy_MM_dd));

    }



}