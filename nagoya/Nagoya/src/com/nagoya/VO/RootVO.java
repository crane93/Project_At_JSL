package com.nagoya.VO;

import java.sql.Timestamp;

public class RootVO {
	private int rnum;
	private String rname;
	private String rpass;
	private String rtitle;
	private String rcontent;
	private String rimgurl;
	private int rreadcount;
	private Timestamp rwritedate;
	
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getRpass() {
		return rpass;
	}
	public void setRpass(String rpass) {
		this.rpass = rpass;
	}
	public String getRtitle() {
		return rtitle;
	}
	public void setRtitle(String rtitle) {
		this.rtitle = rtitle;
	}
	public String getRcontent() {
		return rcontent;
	}
	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}
	public String getRimgurl() {
		return rimgurl;
	}
	public void setRimgurl(String rimgurl) {
		this.rimgurl = rimgurl;
	}
	public int getRreadcount() {
		return rreadcount;
	}
	public void setRreadcount(int rreadcount) {
		this.rreadcount = rreadcount;
	}
	public Timestamp getRwritedate() {
		return rwritedate;
	}
	public void setRwritedate(Timestamp rwritedate) {
		this.rwritedate = rwritedate;
	}
}
