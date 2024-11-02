package com.example.graphds;

import java.util.List;
import java.util.PriorityQueue;

public class minspantrreprimsalgo {
	class Pair {
	    int first;
	    int wt;
	    Pair(int first, int wt) {
	        this.first = first;
	        this.wt = wt;
	    }
	}

	
	class Solution {
	     int spanningTree(int V, int E, List < List < int[] >> adj) {

	        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((p1, p2) -> Integer.compare(p1.wt, p2.wt));
	        int[] vis = new int[V];
	        int sum = 0;
	        pq.add(new Pair(0,0));
	        while (!pq.isEmpty()) {
	            Pair node = pq.poll();
	            int first = node.first;
	            int wt = node.wt;
	            if (vis[first] != 1) {
	                vis[first] = 1;
	                sum = sum + wt;

	                for (int[] it: adj.get(first)) {

	                    int first1 = it[0];
	                    int wt1 = it[1];

	                    if (vis[first1] != 1) {
	                        pq.add(new Pair(first1, wt1));
	                    }
	                }

	            }

	        }

	        return sum;

	    }
	}

	

}

