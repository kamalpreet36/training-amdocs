package com.amdocs;

public class NullMobile implements iMobile {

	public void call() {
		System.out.println("Invalid mobile object");
		System.out.println("Perform error log and error handling here");
	}
	
}
