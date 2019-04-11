package com.jp.study.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String args[]) {
		testAllSort();
		//AbstractSort sort = new InsertSort();
		//sort.test(100000);
	}
	
	public static void testAllSort() {
		int testTime = 1000;
		List<AbstractSort> list = new ArrayList<AbstractSort>();
		list.add(new BubbleSort());
		list.add(new InsertSort());
		list.add(new SelectSort());
		list.add(new MergeSort());
		list.add(new QuickSort());
		
		for (int i = 0; i < 50; i ++ ) {
			for(AbstractSort a: list) {
				a.test(testTime);
			}
			System.out.println();
		}
	}
}
