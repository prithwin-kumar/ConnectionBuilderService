package com.sample.connectionbuilder.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class flight_schedule {

	@Id
	private long id;
	private String flight_no;
	private String dept_airport;
	private String arr_airport;
	private String dept_time;
	private String arr_time;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFlight_no() {
		return flight_no;
	}
	public void setFlight_no(String flight_no) {
		this.flight_no = flight_no;
	}
	public String getDept_airport() {
		return dept_airport;
	}
	public void setDept_airport(String dept_airport) {
		this.dept_airport = dept_airport;
	}
	public String getArr_airport() {
		return arr_airport;
	}
	public void setArr_airport(String arr_airport) {
		this.arr_airport = arr_airport;
	}
	public String getDept_time() {
		return dept_time;
	}
	public void setDept_time(String dept_time) {
		this.dept_time = dept_time;
	}
	public String getArr_time() {
		return arr_time;
	}
	public void setArr_time(String arr_time) {
		this.arr_time = arr_time;
	}
	
}
