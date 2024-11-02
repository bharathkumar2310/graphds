package com.example.graphds;

import java.util.PriorityQueue;

import com.example.graphds.networkdelaytime.Pair;

public class minimummultiplytoreachend {

	
	class Solution {
	    int minimumMultiplications(int[] arr, int start, int end) {

	        // Your code here

	        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.step, p2.step));

	        int[] steps = new int[100000];
	        for (int i = 0; i < 100000; i++) {
	            steps[i] = (int) 1e9;
	        }

	        int mod = 100000;
	        pq.add(new Pair(start, 0));
	        steps[start] = 0;
	        while (!pq.isEmpty()) {

	            Pair node = pq.poll();
	            int first = node.first;
	            int step = node.step;
	            for (int i = 0; i < arr.length; i++) {
	                int val = (first * arr[i]) % mod;

	                if (steps[val] > step + 1) {
	                    if (val == end) {
	                        return step + 1;
	                    }
	                    steps[val] = step + 1;
	                    pq.add(new Pair(val, steps[val]));
	                }

	            }
	        }
	        if (start == end) {
	            return 0;
	        }
	        return -1;

	    }
	}


	class Pair {
	    int first;
	    int step;
	    Pair(int first, int step) {
	        this.first = first;
	        this.step = step;
	    }
	}
}
