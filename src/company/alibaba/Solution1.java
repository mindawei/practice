package company.alibaba;

import java.util.Arrays;
import java.util.Scanner;

public class Solution1 {
	/** 请完成下面这个process函数，实现题目要求的功能 **/
	/** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^ **/
	private static int process(BoxTemplate box, Model[] items, boolean[] isLoaded) {

		int[][][][][] f = new int[items.length + 1][box.price + 1][box.length + 1][box.height + 1][box.width + 1];

		f[0][0][0][0][0] = 1;

		// 多重背包
		for (int i = 1; i <= items.length; ++i) {
			if (isLoaded[i]) {
				continue;
			}
			Model item = items[i];
			for (int price = box.price; price >= item.price; --price) {
				for (int length = box.length; length >= item.length; --length) {
					for (int height = box.height; height >= item.height; --height) {
						for (int width = box.width; width >= item.width; --width) {
							f[i][price][length][height][width] = Math.max(f[i][price][length][height][width],
									f[i - 1][price - item.price][length - item.length][height - item.height][width
											- item.width] + 1);
						}
					}
				}
			}
		}

		// 确定是否装入
		int i = items.length - 1;
		int price = box.price;
		int length = box.length;
		int height = box.height;
		int width = box.width;

		while (i > 0) {

			Model item = items[i];

			if (f[i][price][length][height][width] == f[i - 1][price - item.price][length - item.length][height
					- item.height][width - item.width] + 1) {
				isLoaded[i] = true;
				price -= item.price;
				length -= item.length;
				height -= item.height;
				width -= item.width;
			}

			--i;
		}

		// 递归装箱
		boolean isAllFinished = true;
		for (boolean isLoad : isLoaded) {
			if (!isLoad) {
				isAllFinished = false;
				break;
			}
		}

		if (isAllFinished) {
			return 1;
		} else {
			return process(box, items, isLoaded) + 1;
		}
	}

	static class BoxTemplate {
		int price;
		int length;
		int width;
		int height;
	}

	static class Model {
		int price;
		int length;
		int width;
		int height;
	}

	private static final int CUSTOMS_LIMIT_MONEY_PER_BOX = 2000;

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		BoxTemplate boxTemplate = new BoxTemplate();
		boxTemplate.price = CUSTOMS_LIMIT_MONEY_PER_BOX;

		boxTemplate.length = scanner.nextInt();
		boxTemplate.width = scanner.nextInt();
		boxTemplate.height = scanner.nextInt();

		int itemNum = scanner.nextInt();
		Model[] items = new Model[itemNum];
		// 是否装载过
		boolean[] isLoaded = new boolean[itemNum];
		Arrays.fill(isLoaded, false);

		boolean isOk = true;

		for (int i = 0; i < itemNum; i++) {
			Model item = new Model();
			item.price = scanner.nextInt();
			item.length = scanner.nextInt();
			item.width = scanner.nextInt();
			item.height = scanner.nextInt();

			if (item.price > boxTemplate.price || item.length > boxTemplate.length || item.width > boxTemplate.width
					|| item.height > boxTemplate.height) {
				isOk = false;
				break;
			}
			items[i] = item;
		}

		if (isOk) {
			// 多重0，1背包问题
			System.out.println(process(boxTemplate, items, isLoaded));
		} else {
			System.out.println(-1);
		}
	}

}