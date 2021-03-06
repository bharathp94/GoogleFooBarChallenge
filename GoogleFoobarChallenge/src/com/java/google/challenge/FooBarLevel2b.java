package com.java.google.challenge;

import java.util.ArrayList;
import java.util.List;

/*
 * Ion Flux Relabeling
===================

Oh no! Commander Lambda's latest experiment to improve the efficiency of the LAMBCHOP doomsday device has backfired spectacularly. The Commander had been improving the structure of the ion flux converter tree, but something went terribly wrong and the flux chains exploded. Some of the ion flux converters survived the explosion intact, but others had their position labels blasted off. Commander Lambda is having her henchmen rebuild the ion flux converter tree by hand, but you think you can do it much more quickly -- quickly enough, perhaps, to earn a promotion!

Flux chains require perfect binary trees, so Lambda's design arranged the ion flux converters to form one. To label them, Lambda performed a post-order traversal of the tree of converters and labeled each converter with the order of that converter in the traversal, starting at 1. For example, a tree of 7 converters would look like the following:

   7
 3   6
1 2 4 5

Write a function solution(h, q) - where h is the height of the perfect tree of converters and q is a list of positive integers representing different flux converters - which returns a list of integers p where each element in p is the label of the converter that sits on top of the respective converter in q, or -1 if there is no such converter.  For example, solution(3, [1, 4, 7]) would return the converters above the converters at indexes 1, 4, and 7 in a perfect binary tree of height 3, which is [3, 6, -1].

The domain of the integer h is 1 <= h <= 30, where h = 1 represents a perfect binary tree containing only the root, h = 2 represents a perfect binary tree with the root and two leaf nodes, h = 3 represents a perfect binary tree with the root, two internal nodes and four leaf nodes (like the example above), and so forth.  The lists q and p contain at least one but no more than 10000 distinct integers, all of which will be between 1 and 2^h-1, inclusive.
 * 
 * 
 */
public class FooBarLevel2b {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 2, 3, 4, 5, 6};
		int[] result = answer(5, nums);
		for(int i : result)
			System.out.println(i);
	}

	public static int[] answer(int h, int[] q) {

		int head = (int)Math.pow(2,h) - 1;
		int[] result = new int[q.length];

		for (int i = 0 ; i < q.length ; i++) {
			if (q[i] < head && q[i] >=1)
				result[i] = locate(head,q[i],head-1);
			else 
				result[i] = -1;
		}

		return result;
	}
	
	public static int locate(int head, int target, int under) {

		under /= 2;
		int right = head - 1;			// right = head - 1
		int left = head - 1 - under--; // left = head - 1 - under/2

		if (right == target || left == target)
			return head;
		else {
			if (target <= left)
				return locate(left,target,under);
			else
				return locate(right,target,under);
		}
	}

}
