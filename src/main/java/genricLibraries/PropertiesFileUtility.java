package genricLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileUtility {

	private Properties property = null;
/**
 * This method is used to initialize property file
 * @param filepath
 */
	public void propertyFileUtilization(String filepath) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		property = new Properties();

		
			try {
				property.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
/**
 * This method is used to read data from excel file
 * @param key
 * @return
 */
	public String fetchProperty(String key) {
		return property.getProperty(key);
	}
}
