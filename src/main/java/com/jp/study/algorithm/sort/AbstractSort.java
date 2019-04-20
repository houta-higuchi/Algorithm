package com.jp.study.algorithm.sort;

import com.jp.study.algorithm.util.DataUtil;

public abstract class AbstractSort {
	
	public AbstractSort() {
		setDataRandomly();
	}
	public AbstractSort(int size, int max) {
		setMaxElement(max);
		setSize(size);
		setDataRandomly();
	}

	public AbstractSort(int[] data) {
		this.data = data;
		size = data.length;
		originalData = new int[size];
		System.arraycopy(data, 0, originalData, 0, size);
	}

	protected int[] data ;
	protected int[] originalData ;
	private int size = 1000;
	private int maxElement = 10000;
	private String sortName;
	
	public String getSortName() {
		return sortName;
	}
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	abstract public void sort();
	
	public void output(boolean isOriginal) {
		if (isOriginal) for (int i : data) System.out.print(i + " ");

		else for (int i : originalData) System.out.print(i + " ");

		System.out.println();
	}
	
	public void setDataRandomly(int size, int max) {
		this.size = size;
		maxElement = max;
		setDataRandomly();
	}
	
	
	public void setDataRandomly() {
		
		if (size == 0 || maxElement == 0) throw new RuntimeException("数组大小或者数组最大值不可以为0");

		data = DataUtil.getRamdomData(size, maxElement);
		originalData = new int[size];
		System.arraycopy(data, 0, originalData, 0, size);
	}
	
	public boolean isSortCorrect() {
		for (int i = 0; i < getSize()-1; i++) {
			if (data[i] > data[i+1]) {
				System.out.println("排序失败!");
				System.out.print("原始组：" );
				output(true);
				System.out.print("排序后数组：" );
				output(false);
				return false;
			}
		}
		return true;
	}
	
	public void test(int time) {
		long startTime;
		long endTime;
		long totalTime = 0;
		for (int i = 0; i < time; i++) {
			setDataRandomly();
			startTime = System.currentTimeMillis();
			sort();
			endTime = System.currentTimeMillis();
			totalTime += (endTime - startTime);
			if (!isSortCorrect()) {
				System.out.println("发生在第" + i + "次");
				return;
			}
			if (isChanged()) {
				System.out.println("测试失败，数据被串改");
				System.out.println("发生在第" + i + "次");
				return;
			}
		}
		
		System.out.println(sortName + ": 测试通过！");
		System.out.println("测试次数：" + time + ", 数组大小：" + size + ", 消耗时间：" + totalTime + "ms");
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getMaxElement() {
		return maxElement;
	}

	public void setMaxElement(int maxElement) {
		this.maxElement = maxElement;
	}
	
	public boolean isChanged() {
		int temp[] = new int[getSize()];
		temp = data;
		for (int i : originalData) {
			for (int j = 0; j < getSize(); j++) {
				if (i == temp[j]) {
					temp[j] = -1;
					break;
				}
				if (j == (getSize()-1)) return true;
			}
		}
		return false;
	}
	
	public int[] getData() {
		return data;
	}
	
}
