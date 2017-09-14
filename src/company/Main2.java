package company;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		int n = Integer.parseInt(sc.nextLine());
		Map<String,Integer> map = new HashMap<>();
		for(int i=0;i<n;++i) {
			String line = sc.nextLine();
			if(line.charAt(0)=='?') {
				String key = line.substring(2);
				System.out.println(map.get(key));
			}else {
				String[] parts = line.split(" = ");
				String key = parts[0];
				String value = parts[1];
				
				if(Character.isDigit(value.charAt(0))) {
					map.put(key, Integer.parseInt(value));
				}else {
					map.put(key, map.get(value));
				}
			}
		}
	}
	
}
