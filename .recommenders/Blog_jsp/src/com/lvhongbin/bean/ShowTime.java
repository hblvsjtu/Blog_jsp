package com.lvhongbin.bean;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ShowTime {
	
	
	Date date=Calendar.getInstance().getTime();
	SimpleDateFormat df=new SimpleDateFormat("yyyy-mm-dd HH:MM:ss");
	private String realTime =df.format(date);
	public String getRealTime() {
		return realTime;
	}
	public void setRealTime(String realTime) {
		this.realTime = realTime;
	}
}
