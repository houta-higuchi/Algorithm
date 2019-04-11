package com.jp.study.algorithm.sort;

/**
 * 冒泡排序法
 * 空间复杂度为O(n)
 * 时间复杂度为O(n2)
 * 最优时间复杂度为O(n)
 * 稳定排序算法
 * @author Administrator
 *
 */

public class BubbleSort extends AbstractSort {
	
	public BubbleSort() {
		super();
		setSortName("冒泡排序");
	}
	
	public BubbleSort(int size, int max) {
		super(size, max);
		setSortName("冒泡排序");
	}
	
	@Override
	public void sort() {
		if (data == null) {
			setDataRandomly();
		}
		for (int i = 0; i < getSize()-1; i++) {
			int temp = 0;
			for (int j = 0; j < getSize() - 1 - i; j++) {
				if (data[j] > data[j+1]) {
					temp = data[j];
					data[j] = data[j+1];
					data[j+1] = temp;
				}
			}
		}
	}

}
