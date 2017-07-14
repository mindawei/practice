package string;

/**
 * Kmp��ϰ����Ҫ˼�룺�Ӵ��ڲ�֮�����Ϣ�������ã������ظ��Ƚ�
 *
 * @author mindw
 * @date 2017��7��3��
 */
public class Kmp {

//	[0, 0, 1]
//			find at position 6
//			dd
//			find at position 7
//			dd
//			find at position 13
//			dd

	public static void main(String[] args) {
		String original = "abcadbdddaacbddbdacbd";
		String find = "dd";
		
		//search(original, find, getNext(find));
		kmp(original, find);
	}

    private static void kmp(String original, String find) {
    	
    	int findLen = find.length();
    	int[] next = new int[findLen+1];
    	next[0] = next[1] = 0;
    	int i,j = 0;
    	char ch;
    	for(i=1;i<findLen;++i){
    		ch = find.charAt(i);
    		while(j!=0&&ch!=find.charAt(j)){
    			j = next[j];
    		}
    		
    		if(ch==find.charAt(j)){
    			++j;
    		}
    		
    		next[i+1] = j;
    	}
    	
    	j = 0;
    	int originalLen = original.length();
    	for(i=0;i<originalLen;++i){
    		ch = original.charAt(i);
    		while(j!=0&&ch!=find.charAt(j)){
    			j = next[j];
    		}
    		
    		if(ch==find.charAt(j)){
    			++j;
    		}
    		
    		if(j==findLen){
    			System.out.println("find at "+(i-j+1)+" "+original.substring((i-j+1),i+1));
    			
    			j = next[j];
    		}
    		
    	}
    	
    }

//	private static void kmp(String original, String find) {
//		int findLen = find.length();
//		int[] next = new int[findLen+1];
//		next[0] = next[1] = 0;
//		int i,j=0;
//		
//		char ch;
//		for(i=1;i<findLen;++i){
//			ch = find.charAt(i);
//			while(j!=0&&ch!=find.charAt(j)){
//				j = next[j];
//			}
//			
//			if(ch==find.charAt(j)){
//				++j;
//			}
//			
//			next[i+1] = j;
//		}
//		
//		
//		int originalLen = original.length();
//		j = 0;
//		for(i=0;i<originalLen;++i){
//			ch = original.charAt(i);
//			while(j!=0&&ch!=find.charAt(j)){
//				j = next[j];
//			}
//			
//			if(ch == find.charAt(j)){
//				++j;
//			}
//			
//			if(j==findLen){
//				
//				System.out.println("find at "+(i-j+1)+" "+original.substring((i-j+1),i+1));
//				
//				j = next[j];
//			}
//			
//		}
//		
//		
//	}

//	private static void kmp(String original, String find) {
//		
//		if(original==null||find==null){
//			return;
//		}
//		
//		int findLen = find.length();
//		
//		int[] next = new int[findLen+1];
//		next[0] = next[1] = 0;
//		int i,j=0;
//		char ch;
//		for(i=1;i<findLen;++i){
//			ch = find.charAt(i);
//			while(j!=0&&ch==find.charAt(j)){
//				j = next[j];
//			}
//			
//			if(ch == find.charAt(j)){
//				++j;
//			}
//			next[i+1] = j; 
//		}
//		
//		j = 0;
//		int originalLen = original.length();
//		for(i=0;i<originalLen;++i){
//			
//			ch = original.charAt(i);
//			
//			while(j!=0&&ch!=find.charAt(j)){
//				j = next[j];
//			}
//			
//			if(ch == find.charAt(j)){
//				++j;
//			}
//			
//			if(j==findLen){
//				System.out.println("find at "+(i-j+1)+" "+original.substring((i-j+1),i+1));
//				j = next[j];
//			}
//			
//		}
//		
//	}
	
	

//	/**
//	 * http://blog.csdn.net/yutianzuijin/article/details/11954939/
//	 * @param str
//	 * @param subStr
//	 */
//	private static void kmp(final String str,final String subStr) {
//		
//		if(str==null||subStr==null){
//			throw new IllegalArgumentException("��������Ϊnull");
//		}
//		
//		int subStrLen = subStr.length();
//		int[] next = new int[subStrLen+1];
//		next[0] = next[1] = 0;
//		int i,j=0;
//		
//		for(i=1;i<subStrLen;++i){
//			
//			while(j!=0&&subStr.charAt(i)!=subStr.charAt(j)){
//				j = next[j];
//			}
//			
//			if(subStr.charAt(i)==subStr.charAt(j)){
//				j++;
//			}
//			
//			next[i+1] = j;
//		}
//		
//		int strlen=str.length();
//		j = 0;
//		for(i=0;i<strlen;++i){
//			
//			while(j!=0&&str.charAt(i)!=subStr.charAt(j)){
//				j = next[j];
//			}
//			
//			if(str.charAt(i)==subStr.charAt(j)){
//				++j;
//			}
//			
//			if(j==subStrLen){
//				System.out.println("find at "+(i-j+1)+" "+str.substring(i-j+1, i+1));
//				j = next[j];
//			}
//			
//		}
//	}
	
//	public static int[] getNext(String b) {
//	int len = b.length();
//	int j = 0;
//
//	int next[] = new int[len + 1];// next��ʾ����Ϊi���ַ���ǰ׺�ͺ�׺����������֣���1��ʼ
//	next[0] = next[1] = 0;
//
//	for (int i = 1; i < len; i++)// i��ʾ�ַ������±꣬��0��ʼ
//	{
//		// j��ÿ��ѭ����ʼ����ʾnext[i]��ֵ��ͬʱҲ��ʾ��Ҫ�Ƚϵ���һ��λ��
//		while (j > 0 && b.charAt(i) != b.charAt(j))
//			j = next[j];
//		if (b.charAt(i) == b.charAt(j))
//			j++;
//		next[i + 1] = j;
//	}
//
//	System.out.println(Arrays.toString(next));
//	return next;
//}
//
//public static void search(final String original,final String find, int next[]) {  
//    int j = 0;  
//    for (int i = 0; i < original.length(); i++) {  
//        while (j > 0 && original.charAt(i) != find.charAt(j))  
//            j = next[j];  
//        if (original.charAt(i) == find.charAt(j))  
//            j++;  
//        if (j == find.length()) {  
//            System.out.println("find at position " + (i - j+1));  
//            System.out.println(original.subSequence(i - j + 1, i + 1));  
//            j = next[j];  
//        }  
//    }  
//}  
	
//	private static void kmp(final String original,final String find) {
//		
//		int findLen = find.length();
//		int[] next = new int[findLen+1];
//		next[0] = next[1] = 0;
//		int i,j=0;
//		// init next array
//		for(i=1;i<findLen;++i){
//			
//			while(j!=0 && find.charAt(i)!=find.charAt(j)){
//				j = next[j];
//			}
//			
//			if(find.charAt(i)==find.charAt(j)){
//				++j;
//			}
//		
//			next[i+1] = j;
//			
//		}
//		
//		// use next array to find the subStr idnex
//		int originalLen = original.length();
//		j = 0;
//		for(i=0;i<originalLen;++i){
//			
//			while(j!=0&&original.charAt(i)!=find.charAt(j)){
//				j = next[j];
//			}
//			
//			if(original.charAt(i)==find.charAt(j)){
//				++j;
//			}
//			
//			if(j==findLen){
//				System.out.println("final at "+(i-j+1));
//				System.out.println(original.substring(i-j+1,i+1));
//				j = next[j];
//			}
//			
//			
//		}
//		
//	}
	
	
//	private static void kmp(String str, String substr) {
//		
//		// init next array
//		int subLen = substr.length();
//		int[] next = new int[subLen + 1];
//		next[0] = next[1] = 0;
//		
//		int i,j = 0;
//		for(i=1;i<subLen;++i){
//			
//			while(j!=0 && substr.charAt(i)!= substr.charAt(j)){
//				j = next[j];
//			}
//			
//			if(substr.charAt(i) == substr.charAt(j)){
//				j++;
//			}
//			
//			next[i+1] = j;
//			
//		}
//		System.out.println(Arrays.toString(next));
//		
//		
//		// use next to find index
//		int strLen = str.length();
//		j=0;
//		for(i=0;i<strLen;++i){
//			
//			while(j > 0 && str.charAt(i)!=substr.charAt(j)){
//				j = next[j];
//			}
//			
//			if(str.charAt(i)==substr.charAt(j)){
//				j++;
//			}
//			
//			if(j==subLen){
//				System.out.println("find at "+(i-subLen+1));
//				System.out.println(str.substring(i-subLen+1, i+1));
//				j = next[j];
//			}
//			
//		}
//		
//		
//	}
	
}
