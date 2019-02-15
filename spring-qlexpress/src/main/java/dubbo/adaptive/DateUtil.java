package dubbo.adaptive;

import org.apache.commons.lang.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 处理时间的工具类
 *
 * @author:wb-lc 2018/4/21 16:48.
 */
public class DateUtil {

    public static final String FMT_Y_M_D_H_M_S  = "yyyy-MM-dd HH:mm:ss";

    /**
     * 年 - 月 - 日
     */
    public static final String YYYY_MM_DD       = "yyyy-MM-dd HH:mm:ss";

    /**
     * 年 - 月 - 日 - 时
     */
    public static final String YYYY_MM_DD_HH    = "yyyy年MM月dd日 HH:mm时";

    /**
     * 年 - 月 - 日
     */
    public static final String YYYY_MM_DD_CH    = "yyyy年MM月dd日";

    /**
     * 年 - 月 - 日 - 时 - 分
     */
    public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";

    /**
     * 拿到今天的日期+时间的字符显示。
     *
     * @return
     */
    public static String getTodayDateTime() {
        return convertTimeToSpecifiedFormat(new Date(), FMT_Y_M_D_H_M_S);
    }

    /**
     * 对页面传来的结束时间做处理
     * 
     * @param date
     * @return
     */
    public static Date getEndTime(Date date) {
        return DateUtils.addSeconds(DateUtils.addDays(DateUtils.truncate(date, Calendar.DATE), 1), -1);
    }

    /**
     * 计算两个时间点的天数(不足一天 按一天算),负数按0算
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static Long getDaysBetweenTwoTime(Date startDate, Date endDate) {
        if (startDate == null || endDate == null) {
            return null;
        }
        Calendar fromCalendar = Calendar.getInstance();
        fromCalendar.setTime(startDate);
        Calendar toCalendar = Calendar.getInstance();
        toCalendar.setTime(endDate);
        long time = toCalendar.getTime().getTime() - fromCalendar.getTime().getTime();
        if (time < 0) {
            return 0L;
        }
        // 一天的毫秒数
        int day = 1000 * 60 * 60 * 24;
        return time % day == 0 ? time / day : time / day + 1;
    }

    /**
     * 计算两个时间点的天数(不足一天 按一天算)
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static Long getExactDaysBetweenTwoTime(Date startDate, Date endDate) {
        if (startDate == null || endDate == null) {
            return null;
        }
        Calendar fromCalendar = Calendar.getInstance();
        fromCalendar.setTime(startDate);
        Calendar toCalendar = Calendar.getInstance();
        toCalendar.setTime(endDate);
        long time = toCalendar.getTime().getTime() - fromCalendar.getTime().getTime();
        // 一天的毫秒数
        int day = 1000 * 60 * 60 * 24;
        Long days = null;
        if (time < 0) {
            days = (time % day == 0 ? time / day : time / day - 1);
        } else {
            days = (time % day == 0 ? time / day : time / day + 1);
        }
        return days;
    }

    /**
     * 返回指定日期加XX天
     * 
     * @param date
     * @param days
     * @return
     */
    public static Date addDayFroDate(Date date, int days) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, days);
        return c.getTime();
    }

    /**
     * 返回指定日期减XX天
     * 
     * @param date
     * @param days
     * @return
     */
    public static Date minusDayForDate(Date date, int days) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, -days);
        return c.getTime();
    }

    /**
     * 获取当前时间之前或之后几小时 hour
     * 
     * @param hour
     * @return
     */
    public static Date getTimeByHour(int hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) + hour);
        return calendar.getTime();
    }

    /**
     * 将时间转成指定的格式
     *
     * @param date：要转换的时间
     * @param format：要转成的格式
     * @return
     */
    public static String convertTimeToSpecifiedFormat(Date date, String format) {

        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 将时间字符串转换成相应date对象
     *
     * @param date ：要转换的时间
     * @param format ：要转成的格式
     * @return
     */
    public static Date convertTimeToSpecifiedFormat(String date, String format) throws ParseException {

        return new SimpleDateFormat(format).parse(date);
    }

    /**
     * 获取时间的那一天的开始时间
     *
     * @param date
     * @return
     */
    public static Date getStartTime(Date date) {
        String time = new SimpleDateFormat("yyyy-MM-dd").format(date);
        String startTime = time + " 00:00:00";
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(startTime);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取时间的那一天的结束时间
     *
     * @param date
     * @return
     */
    public static Date getEndTimeByDate(Date date) throws ParseException {
        String time = new SimpleDateFormat("yyyy-MM-dd").format(date);
        String endTime = time + " 23:59:59";
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(endTime);
    }

    /**
     * 获取某年第一天日期
     * 
     * @param year 年份
     * @return Date
     */
    public static Date getYearFirst(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        Date currYearFirst = calendar.getTime();
        return currYearFirst;
    }

    /**
     * 获取某年最后一天日期
     * 
     * @param year 年份
     * @return Date
     */
    public static Date getYearLast(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        Date currYearLast = calendar.getTime();

        return currYearLast;
    }

    /**
     * 返回指定日期加xx年
     * 
     * @param date
     * @param year
     * @return
     */
    public static Date addYearFroDate(Date date, int year) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.YEAR, year);
        return c.getTime();
    }

    /**
     * 返回指定日期减XX月
     * 
     * @param date
     * @param month
     * @return
     */
    public static Date minusMonthForDate(Date date, int month) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, -month);
        return c.getTime();
    }

    /**
     * 返回指定日期加xx月
     * 
     * @param date
     * @param month
     * @return
     */
    public static Date addMonthFroDate(Date date, int month) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, month);
        return c.getTime();
    }

    /**
     * 返回指定日期减XX年
     * 
     * @param date
     * @param year
     * @return
     */
    public static Date minusYearForDate(Date date, int year) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.YEAR, -year);
        return c.getTime();
    }

    /**
     * 获取本周的第一天零点零时零分零秒
     * 
     * @return
     */
    public static Date getWeekStartDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }

    /**
     * 获取本周的最后一天23分59 ：59
     * 
     * @return
     */
    public static Date getWeekEndDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal.getTime();
    }

    // 获取当前月第一天：
    public static Date getMonthStartDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }

    // 获取当前月最后一天
    public static Date getMonthEndDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal.getTime();

    }

    /**
     * 是今年第几周
     */
    public static String getWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.setTime(date);
        int week = cal.get(Calendar.WEEK_OF_YEAR);
        int year = cal.get(Calendar.YEAR);
        return year + "-" + week;
    }

    /**
     * 年-月
     */
    public static String getMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH) + 1;
        String monthStr = String.format("%02d", month);
        int year = cal.get(Calendar.YEAR);
        return year + "-" + monthStr;
    }

    /**
     * 返回获取年
     */
    public static String getYearFromDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        return String.valueOf(year);
    }

    /**
     * 返回月份
     */
    public static String getMonthFromDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH) + 1;
        return String.format("%02d", month);
    }

    public static void main(String[] args) {

    }
}
