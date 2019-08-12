package com.tw.apistackbase;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Compare {
	//给每个牌做好数目标记
	public  int[] code(Integer[] number) {
		int[] mark = {1, 1, 1, 1, 1};
		int[] result = new int[9];
		int indexOne = 0;
		int indexTwo = 5;
		for (int i = 1; i < 5; i++) {
			if (number[i] == number[i - 1]) {
				int j = i - mark[i - 1];
				mark[j]++;
				mark[i] = mark[j];
			}
		}

	//9位数组，前五位储存数目为1，接着两位储存数目为2，接着一位储存数目为3，接着一位储存数目为3
		for (int i = 0; i < 5; ) {
			switch (mark[i]) {
				case 1:
					result[indexOne] = number[i];
					indexOne++;
					break;
				case 2:
					result[indexTwo] = number[i];
					indexTwo++;
					break;
				case 3:
					result[7] = number[i];
					break;
				case 4:
					result[8] = number[i];
					break;
			}
			i = i + mark[i];

		}
		return result;
	}

	public  boolean compareTwo(int[] first, int[] second, char[] firstPattern, char[] secondPattern) {
		//SamPattern储存是否是同个花色，straight储存是否是顺子
		boolean samePattern1 = true;
		boolean samePattern2 = true;
		boolean straight1 = true;
		boolean straight2 = true;
		//同花色检验
		for (int i = 1; i < 5; i++) {
			if (!(firstPattern[i] == firstPattern[i - 1])) {
				samePattern1 = false;
			}
			if (!(secondPattern[i] == secondPattern[i - 1])) {
				samePattern2 = false;
			}
		}
		//顺子检验
		for (int i = 1; i < 5; i++) {
			if (!(first[i] == first[i - 1] - 1))
				straight1 = false;
			if (!(second[i] == second[i - 1] - 1))
				straight2 = false;
		}
//同花顺最大
		if (straight1 == true && samePattern1 == true && !(straight2 == true && samePattern2 == true)) return true;
		if (!(straight1 == true && samePattern1 == true) && (straight2 == true && samePattern2 == true)) return false;
	//四位的炸弹第二大
		if (first[8] > second[8]) {
			return true;
		} else if (first[8] < second[8]) {
			return false;
		}
//接下来是有一对对子和三个相同牌最大
		if (first[7] > 0 && first[5] > 0 && !(second[7] > 0 && second[5] > 0)) {
			return true;
		} else if (second[7] > 0 && second[5] > 0 && !(first[7] > 0 && first[5] > 0)) {
			return false;
		} else {
			//接下来花色相同的最大
			if (samePattern1 && !samePattern2) return true;
			if (!samePattern1 && samePattern2) return false;
			//接下来顺子最大
			if (straight1 && !straight2) return true;
			if (!straight1 && straight2) return false;

//比较三牌哪个大
			if (first[7] > second[7]) {
				return true;
			} else if (first[7] < second[7]) {
				return false;
			}
		}
		//接下来两对对子比一对对子大
		if (first[5] > 0 && first[6] > 0 && !(second[5] > 0 && second[6] > 0)) {
			return true;
		} else if (second[5] > 0 && second[6] > 0 && !(first[5] > 0 && first[6] > 0)) {
			return false;
		} else {
//接下来只有对子输密码相同的情况下比较大小
			if (first[5] > second[5]) {
				return true;
			} else if (first[5] < second[5]) {
				return false;
			}
			if (first[6] > second[6]) {
				return true;
			} else if (first[6] < second[6]) {
				return false;
			}
		}
		//将剩下的单个数目的牌子用14进制表示，确保比较的是最大的牌子（相同的话依次往后推。）
		// 根据十三进制的原理，不怕比较错了。
		int sumFirst = 0;
		int sumSecond = 0;
		for (int i = 0; i < 5; i++) {
			sumFirst += first[i] * Math.pow(14,4-i);
			sumSecond += second[i] * Math.pow(14,4-i);
		}
		if (sumFirst > sumSecond) {
			return true;
		} else return false;
	}
//总函数
	public  String whoWin(List<Puke> first, List<Puke> second) {
		Integer[] firstNumber = new Integer[5];
		Integer[] secondNumber = new Integer[5];
		char[] firstPattern = new char[5];
		char[] secondPattern = new char[5];
		for (int i = 0; i < 5; i++) {
			firstNumber[i] = first.get(i).getNumber();
			firstPattern[i] = first.get(i).getPattern();
			secondNumber[i] = second.get(i).getNumber();
			secondPattern[i] = second.get(i).getPattern();
		}
		Comparator<Integer> cmp = new Comparator<Integer>() {
			public int compare(Integer i1, Integer i2) {
				return i2 - i1;
			}
		};
		Arrays.sort(firstNumber, cmp);
		Arrays.sort(secondNumber, cmp);

		int[] firstResult = code(firstNumber);

		int[] secondResult = code(secondNumber);

		if (!compareTwo(firstResult, secondResult, firstPattern, secondPattern))
			return "The second win!";
		else return "The first win!";

	}

}
//	public static void main(String arge[]){
//		Puke p1 = new Puke ("5H");
//		Puke p2 = new Puke ("6H");
//		Puke p3 = new Puke ("7H");
//		Puke p4 = new Puke ("8H");
//		Puke p5 = new Puke ("9H");
//
//		Puke q1 = new Puke ("2H");
//		Puke q2 = new Puke ("3H");
//		Puke q3 = new Puke ("4H");
//		Puke q4 = new Puke ("5H");
//		Puke q5 = new Puke ("6H");
//		List<Puke> first = new ArrayList<Puke>();
//		List<Puke>second = new ArrayList<Puke>();;
//		first.add(p1);
//		first.add(p2);
//		first.add(p3);
//		first.add(p4);
//		first.add(p5);
//		second.add(q1);
//		second.add(q2);
//		second.add(q3);
//		second.add(q4);
//		second.add(q5);
//		whoWin(first,second);
//	}
//
//
//
//}
