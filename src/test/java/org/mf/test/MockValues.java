/*
 * Created on 22 lug 2016 ( Date ISO 2016-07-22 - Time 17:15:34 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package org.mf.test;

import java.math.BigDecimal;

/**
 * Basic tool providing mock values for mock objects creation
 * 
 */
public class MockValues {

	private final static int MAX_STRING_LENGTH = 50 ;

	private char  currentChar      = 'z' ; // next is 'A'
	
	private byte  byteValue        = 0 ;
	private short shortValue       = 0 ;
	private int   intValue         = 0 ;
	private int   longValue        = 0 ;
	
	private float  floatValue      = 0.0f ;
	private double doubleValue     = 0.0 ;
	
	private long  bigDecimalValue  = 0 ;

	private boolean booleanValue = false;

	// private static final byte[] VOID_BYTES_ARRAY = new byte[0] ;
		
	public MockValues() {
		super();
	}

	public Boolean nextBoolean() {
		return booleanValue = !booleanValue;
	}

	public String nextString(int length) {
		
		if ( length > MAX_STRING_LENGTH ) {
			length = MAX_STRING_LENGTH ;
		}
		
		if ( currentChar < 'Z' ) {
			currentChar++ ;
		}
		else {
			currentChar = 'A';
		}
		char[] chars = new char [length]  ;
		for ( int i = 0 ; i < length ; i++ ) {
			chars[i] = currentChar ;
		}
		return new String ( chars );
	}
	
	public byte nextByte() {
		if ( byteValue >= 99 ) {
			byteValue = 0 ;
		}
		return ++byteValue;
	}

	public short nextShort() {
		if ( shortValue >= 999 ) {
			shortValue = 0 ;
		}
		return ++shortValue;
	}

	public int nextInteger() {
		if ( intValue >= 999999 ) {
			intValue = 0 ;
		}
		return ++intValue;
	}
	
	public long nextLong() {
		if ( longValue >= 999999 ) {
			longValue = 0 ;
		}
		return ++longValue;
	}
	
	public float nextFloat() {
		if ( floatValue >= 999999.00f ) {
			floatValue = 0.0f ;
		}
		return ++floatValue;
	}
	
	public double nextDouble() {
		if ( doubleValue >= 999999.00 ) {
			doubleValue = 0.0 ;
		}
		return ++doubleValue;
	}
	
	public BigDecimal nextBigDecimal() {
		if ( bigDecimalValue == Long.MAX_VALUE ) {
			bigDecimalValue = 0 ;
		}
		return new BigDecimal ( ++bigDecimalValue ) ;
	}
	
	public java.util.Date nextDate() {
		return new java.util.Date();
	}
	
	public java.sql.Date nextSqlDate() {
		return new java.sql.Date( (new java.util.Date()).getTime() );
	}
	
	public java.sql.Time nextSqlTime() {
		return new java.sql.Time( (new java.util.Date()).getTime() );
	}
	
	public java.sql.Timestamp nextSqlTimestamp() {
		return new java.sql.Timestamp( (new java.util.Date()).getTime() );
	}
	

}
