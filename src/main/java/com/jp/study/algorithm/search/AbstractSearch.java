package com.jp.study.algorithm.search;

import java.util.Random;

public abstract class AbstractSearch {

	protected int size;
	
	protected int maxElement;
	
	protected int[] data;
	
	protected int beFoundElement;
	
	protected int foundIndex = -1;
	
	public AbstractSearch() {
		size = 100;
		maxElement = 100;
		setDataRandomly();
		beFoundElement = getBeFountElementRandomly(true);
	}
	
	public AbstractSearch(int size, int maxElement, boolean canBeFound) {
		this.size = size;
		this.maxElement = maxElement;
		setDataRandomly();
		beFoundElement = getBeFountElementRandomly(canBeFound);
	}
	
	public void setDataRandomly() {
		data = new int[size];
		Random rand = new Random();
		for (int i = 0; i < size; i++) data[i] = rand.nextInt(maxElement);
	}
	
	public int getBeFountElementRandomly(boolean canBeFound) {
		if (canBeFound) {
			Random random = new Random();
			return data[random.nextInt(size)];
		}
		else {
			return maxElement + 1;
		}
	}
	
	public abstract boolean search();
	
	public void test() {
		long startTime = System.currentTimeMillis();
		boolean isFound = search();
		long endTime = System.currentTimeMillis();
		System.out.println("查找结束！数组大小为: " + size + ", 耗时: " + (endTime-startTime) + "ms");
		System.out.println("原数组如下: ");
		for (int i :data) {
			System.out.print(" " + i);
		}
		System.out.println();
		System.out.print("查找结果: ");
		if (isFound) System.out.println("元素" + beFoundElement + "存在于数组的第" + foundIndex + "位");
		else System.out.println("不存在");
	}
}
