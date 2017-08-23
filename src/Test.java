import java.util.HashMap;

public class Test {
	
	public static void main(String[] args) {
		HashMap<Integer,Integer> strs = new HashMap<>();
		int num = 1000;
		for(int i=0;i<num;++i){
			strs.put(i, 1);
		}
		
		new Thread(()->{
			strs.put(num-1, 2);
		}).start();
		
		for(int v : strs.values()){
			System.out.println(v);
		}
		

		
	}
	
}
