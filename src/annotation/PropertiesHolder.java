package annotation;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取配置文件工具类
 * 
 * @Author mindw
 * @Since 2016年8月5日
 * @Version 0.0.1
 */
public final class PropertiesHolder {
	
	private static Properties properties;
	
	private PropertiesHolder() {}
	
	public static void load(String propertiesFileName){
		try {
			InputStream inputStream = PropertiesHolder.class.getResourceAsStream(propertiesFileName);
			properties = new Properties();
			properties.load(inputStream);
//			Enumeration<?> en = pps.propertyNames(); 
//			while (en.hasMoreElements()) {
//				String key = (String) en.nextElement();
//				String value = pps.getProperty(key);
//				System.out.println(key + "=" + value);
//			}
			System.out.println("初始化Properties成功："+propertiesFileName);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("读取Properties文件失败："+propertiesFileName);
		}
	}
	
	public static String getValue(String valueName){
		
		if(properties.containsKey(valueName)){
			return properties.getProperty(valueName);
		}else{
			return "";
		}
	}

}
