/**
 * 
 */
package com.anyikang.model;

import java.io.Serializable;

/**
 * @author wangwei
 * @date 2017年3月2日
 */
public class ObjectReq implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1222443498948565003L;
	private int id;
	private String name;
	private int age;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "----SubscribeReq[id=" + id + ",name=" + name + ",age=" + age
				+ "]";
	}

}
