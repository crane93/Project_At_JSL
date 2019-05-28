package com.nagoya.VO;

import java.sql.Timestamp;

public class NoticeVO {
	private int nnum;
	private String nname;
	private String npass;
	private String ntitle;
	private String ncontent;
	private Timestamp nwritedate;
	private int preseq;
	private int afterseq;
	
	public int getPreseq() {
		return preseq;
	}
	public void setPreseq(int preseq) {
		this.preseq = preseq;
	}
	public int getAfterseq() {
		return afterseq;
	}
	public void setAfterseq(int afterseq) {
		this.afterseq = afterseq;
	}
	public int getNnum() {
		return nnum;
	}
	public void setNnum(int nnum) {
		this.nnum = nnum;
	}
	public String getNname() {
		return nname;
	}
	public void setNname(String nname) {
		this.nname = nname;
	}
	public String getNpass() {
		return npass;
	}
	public void setNpass(String npass) {
		this.npass = npass;
	}
	public String getNtitle() {
		return ntitle;
	}
	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}
	public String getNcontent() {
		return ncontent;
	}
	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}
	public Timestamp getNwritedate() {
		return nwritedate;
	}
	public void setNwritedate(Timestamp nwritedate) {
		this.nwritedate = nwritedate;
	}
}
