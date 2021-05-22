package com.sist.vo;

public class Company {
	private int no;
	private String name;
	private String url;

	public Company(int no, String name, String url) {
		super();
		this.no = no;
		this.name = name;
		this.url = url;
	}

	public Company() {
		super();
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Company [no=" + no + ", name=" + name + ", url=" + url + "]";
	}

}
