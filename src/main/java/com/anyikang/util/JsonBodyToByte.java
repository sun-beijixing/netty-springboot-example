package com.anyikang.util;

public class JsonBodyToByte {
	private byte beginCode;//起始位
	private String imeiCode;//IMEI号 
	private byte dataLength;//数据长度 
	private byte functionCode;//功能码 
	private byte dataNumber;//流水号
	private byte errCode;//错误标识
	private String errMsg;//错误信息
	private byte crc;//CRC8 
	private byte endCode;//结束符
	/**
	 * @return the beginCode
	 */
	public byte getBeginCode() {
		return beginCode;
	}
	/**
	 * @param beginCode the beginCode to set
	 */
	public void setBeginCode(byte beginCode) {
		this.beginCode = beginCode;
	}
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
	 * @return the dataNumber
	 */
	public byte getDataNumber() {
		return dataNumber;
	}
	/**
	 * @param dataNumber the dataNumber to set
	 */
	public void setDataNumber(byte dataNumber) {
		this.dataNumber = dataNumber;
	}
	/**
	 * @return the errCode
	 */
	public byte getErrCode() {
		return errCode;
	}
	/**
	 * @param errCode the errCode to set
	 */
	public void setErrCode(byte errCode) {
		this.errCode = errCode;
	}
	
	/**
	 * @return the errMsg
	 */
	public String getErrMsg() {
		return errMsg;
	}
	/**
	 * @param errMsg the errMsg to set
	 */
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
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
	/**
	 * @return the endCode
	 */
	public byte getEndCode() {
		return endCode;
	}
	/**
	 * @param endCode the endCode to set
	 */
	public void setEndCode(byte endCode) {
		this.endCode = endCode;
	}

	
}
