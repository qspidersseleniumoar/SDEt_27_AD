package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertiesFile {

	public static void main(String[] args) throws Throwable {
		
		//step 1 : get the java representation object of the Physical File
		FileInputStream fis = new FileInputStream("./data/commonData.properties");
		
       //step 2 : create an Object the Propertries class to load all the Key& vaules
		Properties pObj = new Properties();
		           pObj.load(fis);
		           
		//step 3 : read the value using getProperty("key")
		           System.out.println(pObj.getProperty("username"));
	}

}
