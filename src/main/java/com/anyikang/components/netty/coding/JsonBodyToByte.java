package com.anyikang.components.netty.coding;

public class JsonBodyToByte {
	private int beginCode;//起始位
	private String imeiCode;//IMEI号 
	private int dataLength;//数据长度 
	private int functionCode;//功能码 
	private byte[] dataNumber;//流水号
	private byte errCode;//错误标识
	private byte errMsg;//错误信息
	private byte crc;//CRC8 
	private int endCode;//结束符
	private int serverType;//1报文 2配置 3查询 
	private int mark;//标志
	
	
	/**
	 * @return the beginCode
	 */
	public int getBeginCode() {
		return beginCode;
	}
	/**
	 * @param beginCode the beginCode to set
	 */
	public void setBeginCode(int beginCode) {
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
	
	
	
	
	public int getDataLength() {
		return dataLength;
	}
	public void setDataLength(int dataLength) {
		this.dataLength = dataLength;
	}
	/**
	 * @return the functionCode
	 */
	public int getFunctionCode() {
		return functionCode;
	}
	/**
	 * @param functionCode the functionCode to set
	 */
	public void setFunctionCode(int functionCode) {
		this.functionCode = functionCode;
	}

	public byte[] getDataNumber() {
		return dataNumber;
	}
	public void setDataNumber(byte[] dataNumber) {
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
	public byte getErrMsg() {
		return errMsg;
	}
	/**
	 * @param errMsg the errMsg to set
	 */
	public void setErrMsg(byte errMsg) {
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
	public int getEndCode() {
		return endCode;
	}
	/**
	 * @param endCode the endCode to set
	 */
	public void setEndCode(int endCode) {
		this.endCode = endCode;
	}
	public int getServerType() {
		return serverType;
	}
	public void setServerType(int serverType) {
		this.serverType = serverType;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	

	
}
