package com.jp.study.algorithm.sort;

public class MergeSort extends AbstractSort {

	public MergeSort() {
		super();
		setSortName("归并排序");
	}
	
	public MergeSort(int size, int max) {
		super(size, max);
		setSortName("归并排序");
	}
	@Override
	public void sort() {
		merge_sort(data, 0, getSize()-1);
	}
	
	
	/**
	 * 递归函数
	 * @param splited 需要排序的数组
	 * @param start 开始的索引
	 * @param end 结尾的索引
	 */
	private void merge_sort(int[] splited, int start, int end) {
		if (start >= end) return ;
		
		int min = (start + end) / 2;
		merge_sort(splited, start, min);
		merge_sort(splited, min+1, end);
		merge(splited, start, min, end);
	}

	/**
	 * 合并函数
	 * @param splited 
	 * @param start
	 * @param min 左边数组的最后一个索引
	 * @param end
	 */
	public void merge(int[] splited, int start, int min, int end) {
		int i = start;
		int j = min + 1;
		int k = 0;
		int temp[] = new int[end - start + 1];
		while (i < (min + 1) && j <= end) {
			if (data[i] < data[j]) {
				temp[k++] = data[i++];
			}
			else {
				temp[k++] = data[j++];
			}
		}
		// 左边已经全部搬到临时数组
		if (i == (min + 1)) {
			while(j <= end) {
				temp[k++] = data[j++];
			}
		}
		else {
			while (i < (min + 1)) {
				temp[k++] = data[i++];
			}
		}
		
		// 搬回去原来数组
		for (int l: temp) {
			data[start++] = l;
		}
	}

}
