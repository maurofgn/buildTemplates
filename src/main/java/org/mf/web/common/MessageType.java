/*
 * Created on 21 lug 2016 ( Time 13:30:52 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package org.mf.web.common;

public enum MessageType {
	
	SUCCESS,
	INFO,
	WARNING,
	DANGER;
	
	public String getCss() {
		return name().toLowerCase();
	}
	
}
