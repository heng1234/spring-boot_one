package com.yh.entity;

public class User {
	/**
	 * name
	 */
	private String name;
	/**
	 * age
	 */
	private int age;
	
	/**
	 * url
	 */
	private String url;
	
	/**
	 * 信息
	 */
	private String desc;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", url=" + url + ", desc=" + desc + "]";
	}
	
	
	
	
}
