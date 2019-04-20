package com.jp.study.algorithm.search;

import java.util.Random;

public abstract class AbstractSearch {

	protected int size;
	
	protected int maxElement;
	
	protected int[] data;
	
	protected int beFoundElement;
	
	//protected int foundIndex = -1;
	
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
	
	/**
	 * 查找相等的元素
	 * @return 返回查找位置，-1为找不到
	 */
	public abstract int search();
	
	/**
	 * 查找第一个相等的元素
	 * @return 返回查找位置，-1为找不到
	 */
	public abstract int searchTheFirstEqual();
	
	/**
	 * 查找最后一个相等的元素
	 * @return 返回查找位置，-1为找不到
	 */
	public abstract int searchTheLastEqual();
	
	/**
	 * 查找第一个大于的元素
	 * @return 返回查找位置
	 */
	public abstract int searchTheFirstGreatter();
	
	/**
	 * 查找第一个小于的元素
	 * @return 返回查找位置
	 */
	public abstract int searchTheFirstSmaller();
	
	public void test() {
		long startTime = System.currentTimeMillis();
		int foundIndex = search();
		long endTime = System.currentTimeMillis();
		System.out.println("查找结束！数组大小为: " + size + ", 耗时: " + (endTime-startTime) + "ms");
		System.out.println("原数组如下: ");
		for (int i :data) {
			System.out.print(" " + i);
		}
		System.out.println();
		System.out.print("查找结果: ");
		if (foundIndex == -1) System.out.println("元素" + data[foundIndex] + "存在于数组的第" + foundIndex + "位");
		else System.out.println("不存在");
	}
}
