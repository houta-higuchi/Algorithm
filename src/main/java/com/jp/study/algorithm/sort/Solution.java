package com.jp.study.algorithm.sort;

import com.jp.study.algorithm.LinkList.ListNode;

class Solution {
	
	
    
    public static void main(String args[]) {
    	System.out.println(mySqrt(2147395599));
    }
    
    public static int mySqrt(int x) {
        long low = 1;
        long high = x;
        long s = 0;
        while (low <= high) {
            long mid = (low + high) / 2;
            s = mid * mid;
            if (s > x) high = mid - 1;
            else if (s == x) return (int) mid;
            else low = mid + 1;
        }
        return (int) high;
    }
    
    
    
}
