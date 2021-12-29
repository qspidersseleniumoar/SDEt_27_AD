package com.crm.autodesk.genericutiltiy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * 
 * @author Deepak
 *
 */
public class FileUtiity {
	
	/**
	 * used to get the property value based on key argumnet
	 * @param key
	 * @return  always return string data
	 * @throws Throwable
	 */
	public String getProPertyKeyValue(String key) throws Throwable {
		FileInputStream fis = new FileInputStream("./data/commonData.properties");
		Properties pObj = new Properties();
		 pObj.load(fis);
		return pObj.getProperty(key);
		
	}

}
