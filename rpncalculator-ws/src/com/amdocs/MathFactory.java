package com.amdocs;

import java.util.HashMap;

public class MathFactory {

	private static HashMap<String,String> classNameMap;
	
	static {
		
		classNameMap = new HashMap<String,String>();
		
		classNameMap.put("+", "com.amdocs.Addition");
		classNameMap.put("*", "com.amdocs.Multiplication");
		classNameMap.put("-", "com.amdocs.Subtraction");
		classNameMap.put("/", "com.amdocs.Division");

		
	/*	
		FileInputStream file;
		
		try {
		file = new FileInputStream("src/main/resources/config.property");
		
		Properties properties = new Properties();
		properties.load(file);
		
		properties.forEach((key,value)->{
			classNameMap.put((String)key, (String)value);
		});
		}     catch(Exception e) {
			e.printStackTrace();
		}
		*/
	} 
	
	public static IMathOperation getObject(String mathOperator) {
		
		IMathOperation mathOperation = null;
		
		String className;
		
		className = classNameMap.get(mathOperator);
		
		try {
			mathOperation = (IMathOperation) Class.forName(className).newInstance();
		}  catch (Exception e) {
			e.printStackTrace();
		}
		
		return mathOperation;
	}

}
