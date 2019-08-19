package com.amdocs;

public class MobileFactory {
	
	public static iMobile getMobile(String mobileName) {
		iMobile mobile = null;
		
		if( mobileName.equals("IPhone4") )
			mobile = new IPhone4();

		else if( mobileName.equals("IPhone5") )
			mobile = new IPhone5();

		else if( mobileName.equals("OnePlus5") )
			mobile = new OnePlus5();
		
		else
			mobile = new NullMobile();
			
		
		return mobile;
	}
	

}
