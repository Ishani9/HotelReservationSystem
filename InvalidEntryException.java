package com.bl.assignment;

@SuppressWarnings("serial")
public class InvalidEntryException extends Exception{
	
	public InvalidEntryException(String message){
		
		System.out.println("--------");
		System.out.println("Message for Exception is : " + message);
		System.out.println("--------\n");
	}

}
