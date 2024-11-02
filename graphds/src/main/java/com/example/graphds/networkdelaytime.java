package com.example.graphds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class networkdelaytime {

	class Solution {
	    public int networkDelayTime(int[][] times, int n, int k) {
	        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
	        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.wt, p2.wt));
	        int[] dis = new int[n + 1];
	        for (int i = 0; i <= n; i++) {
	            adj.add(new ArrayList<Pair>());
	            dis[i] = (int) 1e9;
	        }

	        for (int[] arr : times) {
	            int first = arr[0];
	            int second = arr[1];
	            int third = arr[2];
	            adj.get(first).add(new Pair(second, third));
	        }

	        dis[k] = 0;
	        pq.add(new Pair(k, dis[k]));
	        while (!pq.isEmpty()) {
	            Pair node = pq.poll();
	            int first = node.first;
	            int wt = node.wt;
	            for (Pair node1 : adj.get(first)) {
	                int first1 = node1.first;
	                int wt1 = node1.wt;
	                if (dis[first1] > wt + wt1) {

	                    dis[first1] = wt + wt1;
	                    pq.add(new Pair(first1, dis[first1]));
	                }
	            }
	        }
	        dis[0] = 0;
	        for (int i = 0; i <= n; i++) {
	            if (dis[i] == 1e9) {

	                return -1;
	            }
	        }
	        int max = Arrays.stream(dis).max().orElseThrow();

	        return max;

	    }
	}

	class Pair {
	    int first;
	    int wt;

	    Pair(int first, int wt) {
	        this.first = first;
	        this.wt = wt;
	    }
	}
}
