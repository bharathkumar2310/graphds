package com.example.graphds;

public class disjointsetnoofopnetworkconnected {

	class Solution {
	    public int makeConnected(int n, int[][] connections) {

	        int[] parent = new int[n];
	        int[] range = new int[n];
	        int count = 0;
	        int count1 = 0;
	        for (int i = 0; i < n; i++) {
	            parent[i] = i;
	            range[i] = 0;
	        }

	        for (int[] it : connections) {
	            int first = it[0];
	            int second = it[1];
	            int first_parent = findp(parent, first);
	            int second_parent = findp(parent, second);

	            if (first_parent == second_parent) {
	                count++;
	            }

	            else if (range[first_parent] < range[second_parent]) {
	                parent[first_parent] = second_parent;
	            }

	            else if (range[first_parent] > range[second_parent]) {
	                parent[second_parent] = first_parent;

	            }

	            else {
	                parent[second_parent] = first_parent;
	                range[first_parent]++;

	            }

	        }
	        for (int i = 0; i < n; i++) {
	            if (parent[i] == i) {
	                count1++;
	            }
	        }
	        if (count1 - 1 > count) {
	            return -1;
	        }

	        return count1 - 1;
	    }

	    int findp(int[] parent, int node) {
	        if (parent[node] == node) {
	            return node;
	        }

	        int u_parent = findp(parent, parent[node]);
	        parent[node] = u_parent;
	        return u_parent;
	    }

	}

}
