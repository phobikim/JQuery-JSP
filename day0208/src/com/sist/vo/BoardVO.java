package com.sist.vo;

import java.sql.Timestamp;

public class BoardVO {

	private int no;
	private String writer;
	private String pwd;
	private String title;
	private String content;
	private String ip;
	private Timestamp regdate;
	private int hit;

	public BoardVO(int no, String writer, String pwd, String title, String content, String ip, Timestamp regdate,
			int hit) {
		super();
		this.no = no;
		this.writer = writer;
		this.pwd = pwd;
		this.title = title;
		this.content = content;
		this.ip = ip;
		this.regdate = regdate;
		this.hit = hit;
	}

	public BoardVO() {
		super();
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	@Override
	public String toString() {
		return "boardVO [no=" + no + ", writer=" + writer + ", pwd=" + pwd + ", title=" + title + ", content=" + content
				+ ", ip=" + ip + ", regdate=" + regdate + ", hit=" + hit + "]";
	}

}
