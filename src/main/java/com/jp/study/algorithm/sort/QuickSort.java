package com.jp.study.algorithm.sort;

public class QuickSort extends AbstractSort {
	
	public QuickSort() {
		super();
		setSortName("快速排序");
	}
	
	public QuickSort(int size, int maxElement) {
		super(size, maxElement);
		setSortName("快速排序");
	}
	
	public QuickSort(int[] data) {
		super(data);
		setSortName("快速排序");
	}

	@Override
	public void sort() {
		quick_sort(0, getSize()-1);
	}
	
	/**
	 * a[start, q-1] 比a[q]小
	 * a[q+1, end] 比a[q]大
	 * @param start
	 * @param end
	 */
	private void quick_sort(int start, int end) {
		
		if (start >= end) return;
		
		int q = partition(start, end);
		quick_sort(start, q-1);
		quick_sort(q + 1, end);
	}

	/**
	 * 找最后的元素作为分区元素
	 * a[start, i-1]比value小（已排序区间）
	 * 开始用i,j指向start
	 * 遍历j，如果a[j]比value小，a[i]和a[j]交换，i++（意思是往已排序区间放元素）
	 * j遍历到end，直接a[j]和a[i]交换
	 * @param start
	 * @param end
	 * @return
	 */
	private int partition(int start, int end) {
		int i = start;
		int j = start;
		int value = data[end];
		for (j = start; j < end; j++) {
			if (data[j] < value) {
				int temp = data[i];
				data[i] = data[j];
				data[j] = temp;
				i++;
			}
		}
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
		
		return i;
	}

}
