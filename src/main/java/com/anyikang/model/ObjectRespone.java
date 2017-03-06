/**
 * 
 */
package com.anyikang.model;

import java.io.Serializable;

/**
 * @author wangwei
 * @date 2017年3月3日
 */
public class ObjectRespone implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8487611296598323242L;

	private int id;

	private int code;

	private String desc;

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
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc
	 *            the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "ObjectResp [id=" + id + ", code="
				+ code + ", desc=" + desc + "]";
	}
}