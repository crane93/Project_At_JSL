package com.nagoya.VO;

import java.sql.Timestamp;

public class GurumeVO {
	private int gnum;
	private String gname;
	private String gpass;
	private String gtitle;
	private String gcontent;
	private String gimgurl;
	private int greadcount;
	private Timestamp gwritedate;
	
	public int getGnum() {
		return gnum;
	}
	public void setGnum(int gnum) {
		this.gnum = gnum;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getGpass() {
		return gpass;
	}
	public void setGpass(String gpass) {
		this.gpass = gpass;
	}
	public String getGtitle() {
		return gtitle;
	}
	public void setGtitle(String gtitle) {
		this.gtitle = gtitle;
	}
	public String getGcontent() {
		return gcontent;
	}
	public void setGcontent(String gcontent) {
		this.gcontent = gcontent;
	}
	public String getGimgurl() {
		return gimgurl;
	}
	public void setGimgurl(String gimgurl) {
		this.gimgurl = gimgurl;
	}
	public int getGreadcount() {
		return greadcount;
	}
	public void setGreadcount(int greadcount) {
		this.greadcount = greadcount;
	}
	public Timestamp getGwritedate() {
		return gwritedate;
	}
	public void setGwritedate(Timestamp gwritedate) {
		this.gwritedate = gwritedate;
	}
}
