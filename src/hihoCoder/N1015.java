package hihoCoder;

import java.util.Scanner;

public class N1015 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str, substr;
		int num = in.nextInt();
		for(int i=0;i<num;++i){
			substr = in.next();
			str = in.next();
			System.out.println(findByKmp(str, substr));
		}
		in.close();
	}

	private static int findByKmp(String original, String find) {

		int findLen = find.length();
		int originalLen = original.length();

		if (findLen == 0 || findLen > originalLen) {
			return 0;
		}

		int[] next = new int[findLen + 1];
		next[0] = next[1] = 0;
		int i, j = 0;
		char ch;
		for (i = 1; i < findLen; ++i) {
			ch = find.charAt(i);
			while (j != 0 && ch != find.charAt(j)) {
				j = next[j];
			}

			if (ch == find.charAt(j)) {
				++j;
			}

			next[i + 1] = j;
		}

		j = 0;

		int num = 0;
		for (i = 0; i < originalLen; ++i) {
			ch = original.charAt(i);
			while (j != 0 && ch != find.charAt(j)) {
				j = next[j];
			}

			if (ch == find.charAt(j)) {
				++j;
			}

			if (j == findLen) {
				num++;
				j = next[j];
			}

		}

		return num;

	}

}
