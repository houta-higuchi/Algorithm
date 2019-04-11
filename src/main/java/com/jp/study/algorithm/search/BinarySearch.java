package com.jp.study.algorithm.search;

import javax.naming.ldap.SortControl;

import com.jp.study.algorithm.sort.AbstractSort;
import com.jp.study.algorithm.sort.QuickSort;

/**
 * 二分查找
 * @author Administrator
 *
 */

public class BinarySearch extends AbstractSearch {
	
	private AbstractSort sort;

	public BinarySearch() {
		super();
		sort();
	}
	
	public BinarySearch(int size, int maxElement, boolean canBeFound) {
		super(size, maxElement, canBeFound);
		sort();
	}
	
	public void sort() {
		sort = new QuickSort(data);
		sort.sort();
		data = sort.getData();
	}
	
	@Override
	public boolean search() {
		int low = 0;
		int high = size - 1;
		while (low != high) {
			int mid = (high + low) / 2;
			if (data[mid] == beFoundElement) {
				foundIndex = mid;
				return true;
			}
			else if (data[mid] > beFoundElement) high = mid - 1;
			else low = mid + 1;
		}
		return false;
	}

}
