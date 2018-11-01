package com.ultrapower.sbdemo.common;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 
 * @ClassName:     DateTimeUtil
 * @Description:   日期时间帮助类 
 * 
 * @company        Ultrapower
 * @author         caijinpeng
 * @email          jamey_cai@163.com
 * @version        V1.0
 * @Date           2017年12月20日 下午12:54:59 
 *
 */
public class DateTimeUtil {

	//定义类的输出
	private static final Logger logger = LoggerFactory.getLogger(DateTimeUtil.class);
			


	/**
	 * 将毫秒数转换为yyyy-MM-dd HH:mm:ss格式的时间串
	 * @param millis
	 * @return
	 */
	public static String Millis2StrLong(long millis){
		if (millis <= 0){
			return "";
		}
		
		try{
			DateTimeFormatter df= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			Instant instant = Instant.ofEpochMilli(millis);
			LocalDateTime localDeteTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
			String s = df.format(localDeteTime);
			return s;
		}catch(Exception ex){
			logger.error("Millis2StrLong error! request millis:"+millis, ex);
		}
		return "";
	}
	
	/**
	 * 将yyyy-MM-dd HH:mm:ss类型的字符串转换为毫秒数
	 * @param dateStr
	 * @return
	 */
	public static long StrLong2Millis(String dateStr){
		if (dateStr == null || "".equals(dateStr.trim())) {
			return 0;
		}
		
		try{
			DateTimeFormatter df= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime localDateTime = LocalDateTime.parse(dateStr, df); 
			Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
			long lTime = instant.toEpochMilli();
			return lTime;
		}catch(Exception ex){
			logger.error("StrLong2Millis error! request dateStr:"+dateStr, ex);
		}
		return 0;
	}
	
	
	
	/**
	 * 将毫秒数转换为yyyy-MM-dd格式的时间串
	 * @param millis
	 * @return
	 */
	public static String Millis2Str(long millis){
		if (millis <= 0){
			return "";
		}
		
		try{
			DateTimeFormatter df= DateTimeFormatter.ofPattern("yyyy-MM-dd");
			Instant instant = Instant.ofEpochMilli(millis);
			LocalDateTime localDeteTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
			String s = df.format(localDeteTime);
			return s;
		}catch(Exception ex){
			logger.error("Millis2Str error! request millis:"+millis, ex);
		}
		return "";
	}
	
	
	/**
	 * 将yyyy-MM-dd类型的字符串转换为毫秒数
	 * @param date
	 * @return
	 */
	public static long Str2Millis(String dateStr){
		if (dateStr == null || "".equals(dateStr.trim())) {
			return 0;
		}
		
		try{
			DateTimeFormatter df= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime localDateTime = LocalDateTime.parse(dateStr, df); 
			Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
			long lTime = instant.toEpochMilli();
			return lTime;
		}catch(Exception ex){
			logger.error("Str2Millis error! request dateStr:"+dateStr, ex);
		}
		return 0;
	}
	
	
	
	

    /**
     * 将给定类型的时间字符串转换为毫秒数
     * @param dateStr
     * @param _dtFormat
     *     日期格式1  yyyy-MM-dd HH:mm:ss
     *     日期格式2  yyyy-MM-dd
     *     日期格式3  yyyyMMddHH
     * @return
     */ 
    public static long StrFormat2Millis(String dateStr, String _dtFormat){
    	if (dateStr == null || "".equals(dateStr.trim())) {
			return 0;
		}
		
		try{
			DateTimeFormatter df= DateTimeFormatter.ofPattern(_dtFormat);
			LocalDateTime localDateTime = LocalDateTime.parse(dateStr, df); 
			Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
			long lTime = instant.toEpochMilli();
			return lTime;
		}catch(Exception ex){
			logger.error("StrFormat2Millis error! request dateStr:"+dateStr+", _dtFormat:"+_dtFormat, ex);
		}
		return 0;      
    }
    
    
    
    
    /**
     * 将给定类型的时间字符串转换为时间
     * @param dateStr
     * @param _dtFormat
     *     日期格式1  yyyy-MM-dd HH:mm:ss
     *     日期格式2  yyyy-MM-dd
     *     日期格式3  yyyyMMddHH
     * @return
     */ 
    public static Date StrFormat2Date(String dateStr, String _dtFormat){
		try{
			DateTimeFormatter df = DateTimeFormatter.ofPattern(_dtFormat);
			LocalDateTime ldt = LocalDateTime.parse(dateStr, df);
			
			ZoneId zoneId = ZoneId.systemDefault();
			ZonedDateTime zdt = ldt.atZone(zoneId);
	        Date date = Date.from(zdt.toInstant());
			return date;
		}catch(Exception ex){
			logger.error("StrFormat2Date error! request dateStr:"+dateStr+", _dtFormat:"+_dtFormat, ex);
		}
		return null;
    }
    
    
    
    /**
     * 将13位时间毫秒数转换为 指定格式的时间字符串串
     * @param millis
     * @param _dtFormat
     *     日期格式1  yyyy-MM-dd HH:mm:ss
     *     日期格式2  yyyyMMdd
     *     日期格式3  yyyyMMddHH
     *     日期格式4  MM-dd HH:mm:ss
     * @return
     */
    public static String Millis2FormatStr(long millis, String _dtFormat){
        if (millis <= 0){
			return "";
		}
		
		try{
			DateTimeFormatter df= DateTimeFormatter.ofPattern(_dtFormat);
			Instant instant = Instant.ofEpochMilli(millis);
			LocalDateTime localDeteTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
			String s = df.format(localDeteTime);
			return s;
		}catch(Exception ex){
			logger.error("Millis2FormatStr error! request millis:"+millis+", _dtFormat:"+_dtFormat, ex);
		}
		return "";
    }
	
    
    
    
    /**
     * 将毫秒转换为时间Day 
     * @param millis
     * @return
     */
    public static String Mills2TimeDay(long millis){
    	if (millis <= 0){
            return "0"; 
    	}
    	Integer ss = 1000;  
        Integer mi = ss * 60;  
        Integer hh = mi * 60;  
        Integer dd = hh * 24;  
      
        Long day = millis / dd;  
        //Long hour = (millis - day * dd) / hh;  
        //Long minute = (millis - day * dd - hour * hh) / mi;  
        //Long second = (millis - day * dd - hour * hh - minute * mi) / ss;  
        //Long milliSecond = millis - day * dd - hour * hh - minute * mi - second * ss; 

        if(day > 0) {  
        	return day+"";
        } else  {
        	return "0";
        }
    }
	
    
    
    /**
 	 * 获得当前时间， 并且指定时间字符串格式 _dtFormat
 	 * 
 	 * @param _dtFormat
 	 *     日期格式1  yyyy-MM-dd HH:mm:ss
 	 *     日期格式2  yyyy-MM-dd
 	 * @return 给定日期格式的字符串
 	 * @author caijinpeng 
 	 */
 	public static String getNowDateTime(String _dtFormat) {
 		String currentDateTimeStr = "";
 		try {
 			LocalDateTime date = LocalDateTime.now();
 			DateTimeFormatter f = DateTimeFormatter.ofPattern(_dtFormat);
 			currentDateTimeStr = date.format(f); 
 		} catch (Exception ex) {
 			logger.error("getNowDateTime error! request _dtFormat:"+_dtFormat, ex);
 		}
 		return currentDateTimeStr;
 	}

 	
 	/**
 	 * 获取当前时间，时间格式 yyyy-MM-dd HH:mm:ss
 	 * 
 	 * @param
 	 * @return 当前日期时间格式的字符串 yyyy-MM-dd HH:mm:ss
 	 * @author caijinpeng 
 	 */
 	public static String getNowDateTime() {
 		return getNowDateTime("yyyy-MM-dd HH:mm:ss");
 	}

 	
 	/**
 	 * 获取当前日期时间，时间格式 yyyy-MM-dd
 	 * 
 	 * @param
 	 * @return 当前日期时间格式的字符串 yyyy-MM-dd
 	 * @author caijinpeng 
 	 */
 	public static String getNowData(){
 		return getNowDateTime("yyyy-MM-dd");
 	}
 	

	/**
	 * 比较两个日期大小，指定日期格式传递
	 * 
	 * @param startTime
	 * @param endTime
	 * @param _dtFormat 日期格式
	 * @return
	 */
	public static boolean timeStrCompare(String startTime, String endTime, String _dtFormat) {
		boolean t = false;
		
		try {
			DateTimeFormatter df= DateTimeFormatter.ofPattern(_dtFormat);
			
			LocalDateTime localDateTime1 = LocalDateTime.parse(startTime, df); 
			LocalDateTime localDateTime2 = LocalDateTime.parse(endTime, df); 
			
			Duration duration = Duration.between(localDateTime1, localDateTime2);
			long diff = duration.toMillis();
			if (diff > 0){
				t = true;
			}
		} catch (Exception ex) {
			logger.error("timeCompare error! request _dtFormat:"+_dtFormat, ex);
		}
		return t;
	}

	
	/**
	 * 比较日期字符串，  返回相差的天数
	 * @param startTime yyyy-MM-dd
	 * @param endTime yyyy-MM-dd
	 * @return  天数
	 */
	public static int timeStrDiffToDay(String startTime, String endTime) {
		int distanceDay = 0;
		try {
			DateTimeFormatter df= DateTimeFormatter.ofPattern("yyyy-MM-dd");
			
			LocalDateTime localDateTime1 = LocalDateTime.parse(startTime, df); 
			LocalDate localDete1 = LocalDate.of(localDateTime1.getYear(), localDateTime1.getMonth(), localDateTime1.getDayOfMonth());
			LocalDateTime localDateTime2 = LocalDateTime.parse(endTime, df); 
			LocalDate localDete2 = LocalDate.of(localDateTime2.getYear(), localDateTime2.getMonth(), localDateTime2.getDayOfMonth());

			Period duration = Period.between(localDete1, localDete2);
			distanceDay = duration.getDays();
		} catch (Exception ex) {
			logger.error("timeStrDiffToDay error! request startTime:"+startTime+", endTime:"+endTime, ex);
		}
		return distanceDay;
	}
	
	
	/**
	 * 比较时间字符串，  返回相差的小时
	 * 
	 * @param startTime
	 * @param endTime
	 * @return 小时
	 */
	public static long timeStrDiffToHours(String startTime, String endTime) {
		long distanceTime = 0;
		try {
			DateTimeFormatter df= DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
			
			LocalDateTime localDateTime1 = LocalDateTime.parse(startTime, df); 
			LocalDateTime localDateTime2 = LocalDateTime.parse(endTime, df); 
			
			Duration duration = Duration.between(localDateTime1, localDateTime2);
			distanceTime = duration.toHours();
		} catch (Exception ex) {
			logger.error("timeStrDiffToHours error! request startTime:"+startTime+", endTime:"+endTime, ex);
		}
		return distanceTime;
	}
	
	/**
	 * 两个毫秒时间，相差多少月
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static int millisDiffToMonth(long startTime, long endTime) {
		int distanceDay = 0;
		try {
			DateTimeFormatter df= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			Instant instant1 = Instant.ofEpochMilli(startTime);
			LocalDateTime localDeteTime1 = LocalDateTime.ofInstant(instant1, ZoneId.systemDefault());
			LocalDate localDete1 = LocalDate.of(localDeteTime1.getYear(), localDeteTime1.getMonth(), localDeteTime1.getDayOfMonth());
			
			Instant instant2 = Instant.ofEpochMilli(endTime);
			LocalDateTime localDeteTime2 = LocalDateTime.ofInstant(instant2, ZoneId.systemDefault());
			LocalDate localDete2 = LocalDate.of(localDeteTime2.getYear(), localDeteTime2.getMonth(), localDeteTime2.getDayOfMonth());
			
			Period duration = Period.between(localDete1, localDete2);
			distanceDay = duration.getMonths();
		}catch(Exception ex) {
			logger.error("millisDiffToMonth error! request startTime:"+startTime+", endTime:"+endTime, ex);
		}
		return distanceDay;
	}
	
	
	
	/**
	 * 两个毫秒时间，相差多少天
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static int millisDiffToDay(long startTime, long endTime) {
		int distanceDay = 0;
		try {
			DateTimeFormatter df= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			Instant instant1 = Instant.ofEpochMilli(startTime);
			LocalDateTime localDeteTime1 = LocalDateTime.ofInstant(instant1, ZoneId.systemDefault());
			LocalDate localDete1 = LocalDate.of(localDeteTime1.getYear(), localDeteTime1.getMonth(), localDeteTime1.getDayOfMonth());
			
			Instant instant2 = Instant.ofEpochMilli(endTime);
			LocalDateTime localDeteTime2 = LocalDateTime.ofInstant(instant2, ZoneId.systemDefault());
			LocalDate localDete2 = LocalDate.of(localDeteTime2.getYear(), localDeteTime2.getMonth(), localDeteTime2.getDayOfMonth());
			
			Period duration = Period.between(localDete1, localDete2);
			distanceDay = duration.getDays();
		}catch(Exception ex) {
			logger.error("millisDiffToDay error! request startTime:"+startTime+", endTime:"+endTime, ex);
		}
		return distanceDay;
	}
	
	
	/**
	 * 两个毫秒时间，相差多少小时
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static long millisDiffToHours(long startTime, long endTime) {
		long distanceDay = 0;
		try {
			DateTimeFormatter df= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			Instant instant1 = Instant.ofEpochMilli(startTime);
			LocalDateTime localDeteTime1 = LocalDateTime.ofInstant(instant1, ZoneId.systemDefault());
			Instant instant2 = Instant.ofEpochMilli(endTime);
			LocalDateTime localDeteTime2 = LocalDateTime.ofInstant(instant2, ZoneId.systemDefault());
			
			Duration duration = Duration.between(localDeteTime1, localDeteTime2);
			distanceDay = duration.toHours();
		}catch(Exception ex) {
			logger.error("millisDiffToHours error! request startTime:"+startTime+", endTime:"+endTime, ex);
		}
		return distanceDay;
	}
	
	

	
	
	 /***
	  * 将指定时间字符串和时间格式，延后或前移几分钟的时间
	  * @param dateStr   时间字符串
	  * @param _dtFormat 时间格式  yyyy-MM-dd
	  *                        yyyy-MM-dd HH:mm:ss
	  * @param mins      分钟
	  * @return
	  */
	 public static String getDataTimeNextTime(String dateStr, String _dtFormat, int mins) {
		 String plusDateTimeStr = ""; 
		 try{
			  DateTimeFormatter df = DateTimeFormatter.ofPattern(_dtFormat);
			  LocalDateTime ldt = LocalDateTime.parse(dateStr, df);
			  LocalDateTime date = ldt.minusMinutes(mins);
			  plusDateTimeStr = date.format(df); 
		 }catch(Exception e){
			  return plusDateTimeStr;
		 }
		 return plusDateTimeStr;
	 }
	 
	 /***
	  * 将指定时间字符串和时间格式，延后或前移几天的时间
	  * @param dateStr   时间字符串
	  * @param _dtFormat 时间格式  yyyy-MM-dd
	  *                        yyyy-MM-dd HH:mm:ss
	  * @param days      天数
	  * @return
	  */
	 public static String getDataNextDay(String dateStr, String _dtFormat, int days) {
		 String plusDateTimeStr = ""; 
		 try{
			  DateTimeFormatter df = DateTimeFormatter.ofPattern(_dtFormat);
			  LocalDateTime ldt = LocalDateTime.parse(dateStr, df);
			  LocalDateTime date = ldt.plusDays(days);
			  plusDateTimeStr = date.format(df); 
		 }catch(Exception e){
			  return plusDateTimeStr;
		 }
		 return plusDateTimeStr;
	 }
	
	 
	 
	 /**
	  * 获取当前时间，延后或前移几小时的时间
	  * @param delay 天数
	  * @return
	  */
	 public static String getNowDataTimeNextHour(int hours) {
		 String plusDateTimeStr = "";
		 try {
			LocalDateTime date = LocalDateTime.now().plusHours(hours);
			DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			plusDateTimeStr = date.format(f); 
		 } catch (Exception ex) {
			logger.error("getNowDataTimeNextHour error! request hours:"+hours, ex);
		 }
		 return plusDateTimeStr;
	 }
	 
	 
	 
	 /**
	  * 获取当前时间，延后或前移几天的时间
	  * @param days 天数
	  * @return
	  */
	 public static String getNowDataTimeNextDay(int days) {
		 String plusDateTimeStr = "";
		 try {
			LocalDateTime date = LocalDateTime.now().plusDays(days);
			DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			plusDateTimeStr = date.format(f); 
		 } catch (Exception ex) {
			logger.error("getNowDataTimeNextDay error! request days:"+days, ex);
		 }
		 return plusDateTimeStr;
	 }
	 
	 /**
	  * 获取当前时间，延后或前移几个月时间
	  * @param month 月
	  * @return
	  */
	 public static String getNowDataTimeNextMonth(int month) {
		 String plusDateTimeStr = "";
		 try {
			LocalDateTime date = LocalDateTime.now().plusMonths(month);
			DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			plusDateTimeStr = date.format(f); 
		 } catch (Exception ex) {
			logger.error("getNowDataTimeNextMonth error! request month:"+month, ex);
		 }
		 return plusDateTimeStr;
	 }
	 
	 
	 /**
	  * 获取当前时间，延后或前移几个年时间
	  * @param month 年
	  * @return
	  */
	 public static String getNowDataTimeNextYears(int years) {
		 String plusDateTimeStr = "";
		 try {
			LocalDateTime date = LocalDateTime.now().plusYears(years);
			DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			plusDateTimeStr = date.format(f); 
		 } catch (Exception ex) {
			logger.error("getNowDataTimeNextYears error! request years:"+years, ex);
		 }
		 return plusDateTimeStr;
	 }
	 
	 
	 /**
	  * 将时间字符串yyyy-MM-dd HH:mm:ss, 转换为yyyy-MM-dd HH:mm:00
	  * @param datastr
	  * @return
	  */
	 public static String DateTimeStr2YMDHM0(String datastr){
		 if(null==datastr || datastr.trim().length()==0){
			 return datastr;
		 }
		 
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 String mydate1 = "";
		 try {
			   Date date1 = format.parse(datastr);

			   SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			   mydate1 = datetimeFormat.format(date1);
			   mydate1 +=":00";
		 } catch (Exception e) {
		 }
		 return mydate1;
	 }
	 
	 
	 /**
	  * 将短时间格式字符串转换为时间 yyyy-MM-dd
	  *
	  * @param strDate
	  * @return
	  */
	 public static Date strToDate(String strDate) {
		 try {
			 DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			 LocalDateTime ldt = LocalDateTime.parse(strDate, df);
			
			 ZoneId zoneId = ZoneId.systemDefault();
			 ZonedDateTime zdt = ldt.atZone(zoneId);
			 Date date = Date.from(zdt.toInstant());
			 return date;
		 }catch(Exception ex) {
			 ex.printStackTrace();
		 }
		 return null;
	 }
	 
	 
	 /**
	  * 将短时间格式时间转换为字符串 yyyy-MM-dd
	  *
	  * @param dateDate
	  * @param k
	  * @return
	  */
	 public static String dateToStr(java.util.Date dateDate) {
		  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		  String dateString = formatter.format(dateDate);
		  return dateString;
	 }
	 
	 
	 /**
	  * 将长时间格式字符串转换为时间 yyyy-MM-dd HH:mm:ss
	  *
	  * @param strDate
	  * @return
	  */
	 public static Date strToDateLong(String strDate) {
		 try {
			 DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			 LocalDateTime ldt = LocalDateTime.parse(strDate, df);
			
			 ZoneId zoneId = ZoneId.systemDefault();
			 ZonedDateTime zdt = ldt.atZone(zoneId);
			 Date date = Date.from(zdt.toInstant());
			 return date;
		 }catch(Exception ex) {
			 ex.printStackTrace();
		 }
		 return null;
	 }
	 
	 
	 /**
	  * 将长时间格式时间转换为字符串 yyyy-MM-dd HH:mm:ss
	  *
	  * @param dateDate
	  * @return
	  */
	 public static String dateToStrLong(java.util.Date dateDate) {
		  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  String dateString = formatter.format(dateDate);
		  return dateString;
	 }
	
	
	/**
	 * 前一个小时
	 */
	public static long previousHour(){
		String dateStr = getNowDataTimeNextHour(-1);
		return StrLong2Millis(dateStr);
	}
	
	/**
	 * 前N个小时
	 */
	public static long previousHour(int hour){
		String dateStr = getNowDataTimeNextHour(-hour);
		return StrLong2Millis(dateStr);
	}
	
	/**
	 * 最近12小时
	 *
	 */
    public static long prevHalfOfDay(){
		String dateStr = getNowDataTimeNextHour(-12);
		return StrLong2Millis(dateStr);
    }
    
    
    
	/**
	 * 最近N天
	 *
	 */
    public static long prevDay(int day){
		String dateStr = getNowDataTimeNextDay(-day);
		return StrLong2Millis(dateStr);
    }
    
    
    
	/**
	 * 最近一天
	 *
	 */
    public static long prevDay(){
		String dateStr = getNowDataTimeNextDay(-1);
		return StrLong2Millis(dateStr);
    }
    
	/**
	 * 最近三天
	 *
	 */
    public static long prevThreeDay(){
		String dateStr = getNowDataTimeNextDay(-3);
		return StrLong2Millis(dateStr);
    }
    
    
	/**
	 * 最近一周
	 *
	 */
    public static long prevWeek(){
		String dateStr = getNowDataTimeNextDay(-7);
		return StrLong2Millis(dateStr);
    }
    
    
	/**
	 * 最近一月
	 *
	 */
    public static long prevMonth(){
		String dateStr = getNowDataTimeNextMonth(-1);
		return StrLong2Millis(dateStr);
    }
    
    
	/**
	 * 获取今天的开始时间
	 * @param today
	 * @return 格式:YYYY-MM-DD HH:MM:SS
	 * @throws Exception
	 */
	public static String getTodayFromTime(Calendar today) throws Exception{		
		SimpleDateFormat simpleDateFormatDate = new SimpleDateFormat("yyyy-MM-dd");
		return simpleDateFormatDate.format(today.getTime())+" 00:00:00";
	}
	
	
	
	/**
	 * 获取今天的结束时间
	 * @param today
	 * @return 格式:YYYY-MM-DD HH:MM:SS
	 * @throws Exception
	 */
	public static String getTodayToTime(Calendar today) throws Exception{
		SimpleDateFormat simpleDateFormatDate = new SimpleDateFormat("yyyy-MM-dd");
		return simpleDateFormatDate.format(today.getTime())+" 23:59:59";
	}
	
	
	
}
