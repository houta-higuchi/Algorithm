package com.jp.study.algorithm.Heap;

import com.jp.study.algorithm.util.DataUtil;

/**
 * 1.建堆：可以分为从上往下建堆和从下往上建堆。从上往下建堆需要执行[n/2, 1]的节点的从上往下调堆操作，从下往上建堆需要执行[2, n]的节点的从下往上调堆操作
 * 1.1 从上往下调堆
 * 	对于节点i，假如子节点比它大，交换子节点与节点i，然后i指向子节点。递归以上操作，假如没有大于节点i的子节点，结束递归。适合删除元素（一般删除头元素）。
 * 	1.2 从下往上调堆
 * 	对于节点i，假如父节点比它小，交换父节点与节点i，然后i指向父节点。递归以上操作，假如没有小于节点i的父节点，结束递归。适合插入元素。
 * 	2.排序
 * 	取出顶元素，然后把最后的元素放到顶部，接着从上往下调堆。递归以上操作。
 * @author Administrator
 *
 */

public class Heap {
	private int size = 20;  // 堆大小
	private int maxElement = 100;
	private int[] data; // length = size + 1;
	
	private long costTime;
	
	public long getCostTime() {
		return costTime;
	}


	public int getSize() {
		return size;
	}

	public Heap() {
		data = DataUtil.getRamdomData(size + 1, maxElement);  // 堆的数组模型首元素为空
		data[0] = 0;
		output();
	}
	
	public Heap(int size, int maxElement) {
		this.size = size;
		this.maxElement = maxElement;
		data = DataUtil.getRamdomData(size + 1, maxElement);
		data[0] = 0;
		output();
	}
	
	public Heap(int[] data) {
		this.data = new int[data.length];
		System.arraycopy(data, 0, this.data, 0, data.length);
		size = data.length - 1;
	}
	
	/**
	 * 由上往下堆化
	 * 递减遍历[n/2, 1], 对每个点进行堆化
	 * currentSiez 当前堆的大小
	 * 
	 * 比由下往上堆化更快
	 */
	public void heapify(int currentSize) {
		long start = System.currentTimeMillis();
		for (int i = currentSize / 2; i >= 1; i--) {
			heapify3(i, currentSize);
		}
		long end = System.currentTimeMillis();
		costTime = end - start;
		//System.out.println("从上往下堆化，花费: " + costTime + "ms");
	}
	
	/**
	 * 从叶子节点开始，不停向上遍历父节点，若叶子节点更大，交换
	 */
	public void heapify2(int currentSize) {
		long start = System.currentTimeMillis();
		for (int i = 2; i <= currentSize; i++) {
			heapify4(i, currentSize);
		}
		long end = System.currentTimeMillis();
		costTime = end - start;
		//System.out.println("从下往上堆化，花费: " + costTime + "ms");
	}
	
	/**
	 * 对当前点使用从上往下调堆
	 * @param currentPos
	 * @param currentSize
	 */
	public void heapify3(int currentPos, int currentSize) {
		int maxPos = currentPos;
		while (true) {
			if (currentPos * 2 <= currentSize && data[currentPos * 2] > data[currentPos]) maxPos = currentPos * 2;
			if (currentPos * 2 + 1 <= currentSize && data[maxPos] < data[currentPos * 2 + 1]) maxPos = currentPos * 2 + 1;
			if (maxPos == currentPos) break;
			int temp = data[maxPos];
			data[maxPos] = data[currentPos];
			data[currentPos] = temp;
			
			currentPos = maxPos;
		}
	}
	
	/**
	 * 对当前点使用从下往上调堆
	 */
	public void heapify4(int currentPos, int currentSize) {
		int minPos = currentPos;
		while (true) {
			if (currentPos / 2 >= 1 && data[currentPos / 2] < data[currentPos]) minPos = currentPos / 2;
			if (minPos == currentPos) break;
			
			int temp = data[minPos];
			data[minPos] = data[currentPos];
			data[currentPos] = temp;
			
			currentPos = minPos;
		}
	}
	
	/**
	 * 
	 * @param currentSize
	 */
	public void sort(int currentSize) { 
		if (currentSize == 0) return;

		int temp = data[1];
		data[1] = data[currentSize];
		data[currentSize] = temp;
		
		heapify3(1, --currentSize);
		
		sort(currentSize);
	}
	
	public void output() {
		for (int i: data) System.out.print(i + " ");
		System.out.println();
	}
	
	public static void test() {
		int[] data = DataUtil.getRamdomData(100000000, 1000000000);
		Heap heap;
		
		long heapcost1 = 0;
		
		for (int i=0; i < 20; i++) {
			heap = new Heap(data);
			heap.heapify(heap.getSize());
			heapcost1 += heap.getCostTime();
		}
		
		heapcost1 /= 20;
		
		long heapcost2 = 0;
		 for (int i = 0; i < 20; i++) {
			 heap = new Heap(data);
				heap.heapify2(heap.getSize());
				heapcost2 += heap.getCostTime();
		}
		 
		 heapcost2 /= 20 ;
		 
		 
		 System.out.println("从上往下堆化，平均花费花费: " + heapcost1 + "ms");
		 System.out.println("从下往上堆化，平均花费花费: " + heapcost2 + "ms");
	}
	public static void main(String args[]) {
		//test();
		Heap heap = new Heap();
		heap.heapify(heap.getSize());
		heap.sort(heap.getSize());
		heap.output();
		
	}
}
