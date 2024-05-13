package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyReader {
	
	//Its is lightweight
	//It is used as Keyvalue pair
	
	public static String readDataFromPropertyFile(String fileName, String propertyKey) {
		
		File file = new File("./data/"+fileName+".properties");
		FileInputStream fis;
		String propertyValue = "";
		try {
			fis = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fis);
			propertyValue= properties.getProperty(propertyKey);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return propertyValue;
	}
		
	
	
//		try {
//			fis = new FileInputStream(file);
//			Properties properties = new Properties();
//			properties.load(fis);
//			propertyValue= properties.getProperty(propertyKey);
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return propertyValue;
	}
