package com.jp.study.algorithm.sort;

/**
 * 选择排序
 * 思路:
 * 数组分已排序区间A和未排序区间B
 * i指向B的首元素
 * 找出a[i+1]
 * @author Administrator
 *
 */

public class SelectSort extends AbstractSort {

	public SelectSort() {
		super();
		setSortName("选择排序");
	}
	
	public SelectSort(int size, int max) {
		super(size, max);
		setSortName("选择排序");
	}
	
	@Override
	public void sort() {
		for (int i = 0; i < getSize()-1; i++) {
			int minIndex = findMostMin(i);
			int temp = data[i];
			data[i] = data[minIndex];
			data[minIndex] = temp;
		}

	}
	
	public int findMostMin(int start) {
		int minIndex = start;
		int min = data[start];
		for ( ; start < getSize(); start ++) {
			if (min > data[start]) {
				min = data[start];
				minIndex = start;
			}
		}
		return minIndex;
	}

}
