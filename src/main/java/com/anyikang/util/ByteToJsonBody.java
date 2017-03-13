package com.anyikang.util;

public class ByteToJsonBody {
	private byte frameType;
	private byte frameSeq;
	private String jsonBody;
	public byte getFrameType() {
		return frameType;
	}
	public void setFrameType(byte frameType) {
		this.frameType = frameType;
	}
	public String getJsonBody() {
		return jsonBody;
	}
	public void setJsonBody(String jsonBody) {
		this.jsonBody = jsonBody;
	}
	public byte getFrameSeq() {
		return frameSeq;
	}
	public void setFrameSeq(byte frameSeq) {
		this.frameSeq = frameSeq;
	}
	
	
}
