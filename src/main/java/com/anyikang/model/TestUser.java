package com.anyikang.model;

import java.io.Serializable;

/**
 * @author wangwei
 * @createDate 2016年12月28日
 */

public class TestUser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3695193213340692507L;

	public TestUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TestUser(long id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	private long id;
	private String name;
	private int age;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

}
