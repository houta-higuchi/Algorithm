package com.jp.study.algorithm.search;

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
	public int search() {
		int low = 0;
		int high = size - 1;
		while (low <= high) {
			int mid = (high + low) / 2;
			if (data[mid] == beFoundElement) return mid;
			else if (data[mid] > beFoundElement) high = mid - 1;
			else low = mid + 1;
		}
		return -1;
	}

	@Override
	public int searchTheFirstEqual() {
		int low = 0;
		int high = size - 1;
		while (low <= high) {
			int mid = (high + low) / 2;
			if (data[mid] == beFoundElement) {
				if (mid == 0 || data[mid-1] != beFoundElement) return mid;
				else high = mid - 1;
			}
			else if (data[mid] > beFoundElement) high = mid - 1;
			else low = mid + 1;
		}
		return -1;
	}

	@Override
	public int searchTheLastEqual() {
		int low = 0;
		int high = size - 1;
		while (low <= high) {
			int mid = (high + low) / 2;
			if (data[mid] == beFoundElement) {
				if (mid == 0 || data[mid+1] != beFoundElement) return mid; 
				else low = mid + 1; 
			}
			else if (data[mid] > beFoundElement) high = mid - 1;
			else low = mid + 1;
		}
		return -1;
	}

	@Override
	public int searchTheFirstGreatter() {
		int low = 0;
		int high = size - 1;
		while (low <= high) {
			int mid = (high + low) / 2;
			if (data[mid] > beFoundElement) {
				if (mid == 0 || data[mid-1] <= beFoundElement) return mid;
				else high = mid - 1;
			}
			else if (data[mid] == beFoundElement) low = mid + 1;
			else low = mid + 1;
		}
		return 0;
	}

	@Override
	public int searchTheFirstSmaller() {
		int low = 0;
		int high = size - 1;
		while (low <= high) {
			int mid = (high + low) / 2;
			if (data[mid] < beFoundElement) {
				if (mid == 0 || data[mid+1] >= beFoundElement) return mid;
				else low = mid + 1;
			}
			else if (data[mid] == beFoundElement) high = low - 1;
			else low = mid + 1;
		}
		return -1;
	}

}
