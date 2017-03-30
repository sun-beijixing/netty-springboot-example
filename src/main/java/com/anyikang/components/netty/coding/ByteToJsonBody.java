package com.anyikang.components.netty.coding;

public class ByteToJsonBody {
	private String imeiCode;//IMEI号 
	private byte dataLength;//数据长度 
	private byte functionCode;//功能码 
	private byte[] dataBody;//业务数据
	private String time;//时间 
	private byte crc;//CRC8 
	
	/**
	 * @return the imeiCode
	 */
	public String getImeiCode() {
		return imeiCode;
	}
	/**
	 * @param imeiCode the imeiCode to set
	 */
	public void setImeiCode(String imeiCode) {
		this.imeiCode = imeiCode;
	}
	/**
	 * @return the dataLength
	 */
	public byte getDataLength() {
		return dataLength;
	}
	/**
	 * @param dataLength the dataLength to set
	 */
	public void setDataLength(byte dataLength) {
		this.dataLength = dataLength;
	}
	/**
	 * @return the functionCode
	 */
	public byte getFunctionCode() {
		return functionCode;
	}
	/**
	 * @param functionCode the functionCode to set
	 */
	public void setFunctionCode(byte functionCode) {
		this.functionCode = functionCode;
	}
	/**
	 * @return the dataBody
	 */
	public byte[] getDataBody() {
		return dataBody;
	}
	/**
	 * @param dataBody the dataBody to set
	 */
	public void setDataBody(byte[] dataBody) {
		this.dataBody = dataBody;
	}
	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}
	/**
	 * @return the crc
	 */
	public byte getCrc() {
		return crc;
	}
	/**
	 * @param crc the crc to set
	 */
	public void setCrc(byte crc) {
		this.crc = crc;
	}
	
	
	
}
