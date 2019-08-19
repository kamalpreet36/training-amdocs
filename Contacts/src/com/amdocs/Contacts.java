package com.amdocs;

import java.util.HashMap;

public class Contacts {

	private HashMap<String, String> contacts;
	
	public Contacts() {
		this.contacts = new HashMap<String, String>();
	}
	
	public void addContacts(String name, String mobileNo) {
		contacts.put(mobileNo, name);
	}
	
	public String findContactsByMobileNo(String mobileNo) {
		String name = contacts.get(mobileNo);
		
		if(name == null)
			return mobileNo;
		else
		    return name;
	}
	
	public static void main(String[] args) {
		Contacts contacts = new Contacts();
		contacts.addContacts("758437", "kamal");
		contacts.addContacts("Rishi", "445435");
		
		String name = contacts.findContactsByMobileNo("445435");
		System.out.println(name);
		
		name = contacts.findContactsByMobileNo("44543");
		System.out.println(name);
		
	}
	
}
