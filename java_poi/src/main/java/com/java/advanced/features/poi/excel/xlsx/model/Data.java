package com.java.advanced.features.poi.excel.xlsx.model;

/**
 * Data Model
 *
 * @author 	Lian
 * @time	2016年8月11日
 */
public class Data {

	private String name;
	private int age;
	private String mail;
	private String address;

	/**
	 * Constructor with all attribute
	 *
	 * @param name
	 * @param age
	 * @param mail
	 * @param address
	 */
	public Data(String name, int age, String mail, String address) {
		super();
		this.name = name;
		this.age = age;
		this.mail = mail;
		this.address = address;
	}

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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
