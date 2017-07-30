package code_offer;

/**
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 * https://www.nowcoder.com/practice/1c82e8cf713b4bbeb2a5b31cf5b0417c?tpId=13&tqId=11187&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 
 * @author 闵大为
 * @data 2017年7月30日
 * @Description
 */
public class FirstNotRepeatingChar {
	public static void main(String[] args) {
		System.out.println((char)new FirstNotRepeatingChar().FirstNotRepeatingChar("google"));
		
	}
	public int FirstNotRepeatingChar(String str) {

		if (str == null) {
			return -1;
		}

		int[] table = new int[256];
		char[] chs = str.toCharArray();
		for (char ch : chs) {
			++table[ch];
		}

		for (int i=0;i<chs.length;++i) {
			if (table[chs[i]] == 1) {
				return i;
			}
		}

		return -1;
	}
}
