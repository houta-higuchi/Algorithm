package com.jp.study.algorithm.util;

import java.util.Random;

public class DataUtil {

	public static int[] getRamdomData(int size, int maxElement) {
		int[] data = new int[size];
		Random rand = new Random();
		for (int i = 0; i < size; i++) data[i] = rand.nextInt(maxElement);
		return data;
	}
	
	public static void main(String args[]) {
		
	}
}
