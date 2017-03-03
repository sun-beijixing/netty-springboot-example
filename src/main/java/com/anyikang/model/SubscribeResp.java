/**
 * 
 */
package com.anyikang.model;

import java.io.Serializable;

/**
 * @author wangwei
 * @date 2017年3月3日
 */
public class SubscribeResp implements Serializable{  
      
     /**
	 * 
	 */
	private static final long serialVersionUID = -8487611296598323242L;

	private int nSubReqID;  
  
        private int nRespCode;  
  
        private String strDesc;  
  
        public final int getnSubReqID() {  
        return nSubReqID;  
        }  
  
        public final void setnSubReqID(int nSubReqID) {  
        this.nSubReqID = nSubReqID;  
        }  
  
        public final int getnRespCode() {  
        return nRespCode;  
        }  
  
        public final void setRespCode(int nRespCode) {  
        this.nRespCode = nRespCode;  
        }  
  
        public final String getstrDesc() {  
        return strDesc;  
        }  
  
        public final void setDesc(String strDesc) {  
        this.strDesc = strDesc;  
        }  
  
        @Override  
        public String toString() {  
        return "SubscribeResp [nSubReqID=" + nSubReqID + ", nRespCode=" + nRespCode  
            + ", strDesc=" + strDesc + "]";  
        }  
}  