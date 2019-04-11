package com.jp.study.algorithm.sort;

/**
 * 插入排序
 * 思路：
 * 数组分已排序区间A和未排序区间B，i指向A的末元素，j指向B的首元素，
 * 首先记下j指向元素的值value，从i开始遍历已排序区间来和value比较，
 * 若大于value，将a[i]往后移，然后i--，若小于value，i位置正是value要插入的位置
 * 
 * @author Administrator
 *
 */

public class InsertSort extends AbstractSort {

	public InsertSort() {
		super();
		setSortName("插入排序");
	}
	
	public InsertSort(int size, int max) {
		super(size, max);
		setSortName("插入排序");
		
	}
	
	@Override
	public void sort() {
		for (int j = 1; j < getSize(); j++) {
			int value = data[j];
			int k = j;
			for (; k > 0; k--) {
				if (data[k-1] > value) {
					data[k] = data[k-1]; //已排序元素往后移，给需要插入的元素腾出位置
				}
				else {
					break;
				}
			}
			data[k] = value;
			
//			int k = j-1;
//			for (; k >= 0; k--) {
//				if (data[k] > value) {
//					data[k+1] = data[k]; //已排序元素往后移，给需要插入的元素腾出位置
//				}
//				else {
//					break;
//				}
//			}
//			data[++k] = value;
		}

	}

}
