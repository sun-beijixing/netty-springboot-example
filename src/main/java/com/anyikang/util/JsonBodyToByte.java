package com.anyikang.util;

public class JsonBodyToByte {
	private byte frameType;
	private byte frameSeq;
	private short dataLength;
	private String jsonBody;

	public byte getFrameType() {
		return frameType;
	}

	public void setFrameType(byte frameType) {
		this.frameType = frameType;
	}

	public byte getFrameSeq() {
		return frameSeq;
	}

	public void setFrameSeq(byte frameSeq) {
		this.frameSeq = frameSeq;
	}

	public short getDataLength() {
		return dataLength;
	}

	public void setDataLength(short dataLength) {
		this.dataLength = dataLength;
	}

	public String getJsonBody() {
		return jsonBody;
	}

	public void setJsonBody(String jsonBody) {
		this.jsonBody = jsonBody;
	}

}
