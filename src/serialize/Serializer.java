package serialize;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;

public class Serializer {
	
	static class SerializeObject implements Serializable{
		int vInt;
		double vDouble;
		
		@Override
		public String toString() {
			return "SerializeObject [vInt=" + vInt + ", vDouble=" + vDouble + "]";
		}
	}
	
	static Random random = new Random();
	
	static SerializeObject createObject(){
		SerializeObject serializeObject = new SerializeObject();
		serializeObject.vInt = random.nextInt(100);
		serializeObject.vDouble = random.nextDouble();
		return serializeObject;
	}
	
	public static void main(String[] args) {
		
		String filePath = "data//";
		File file = new File(filePath);
		if(file.exists()){
			file.delete();
		}
		file.mkdirs();
		filePath = "data//out";
		
		int num = 1;
		for(int i=0;i<num;++i){
			SerializeObject object = createObject();
			System.out.println("write:"+object);
			writeObjectToFile(filePath, object);
		}
		
		
		for(int i=0;i<num;++i){
			SerializeObject object = readObjectFromFile(filePath);
			System.out.println("read:"+object);
		}
		
	}

	/**
	 * 将可序列化对象写到文件中
	 * @param filePath 输出文件路径
	 * @param object  需要输出的对象
	 */
	public static void writeObjectToFile(String filePath, Object object) {
		
		
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(filePath));
			oos.writeObject(object);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(oos!=null){
				try {
					oos.close();
				} catch (IOException e) {
					// ignore
				}
			}
		}
	}

	/**
	 * 从文件中读取对象
	 * @param filePath 读入文件路径
	 */
	@SuppressWarnings("unchecked")
	public static <T> T readObjectFromFile(String filePath) {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(new File(filePath)));
			T object = (T) ois.readObject();
			return object;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(ois!=null){
				try {
					ois.close();
				} catch (IOException e) {
					// ignore
				}
			}
		}
		return null;
	}
}
