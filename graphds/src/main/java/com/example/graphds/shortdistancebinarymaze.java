package com.example.graphds;

import java.util.PriorityQueue;

public class shortdistancebinarymaze {

	
//	class Solution {
	    public int shortestPathBinaryMatrix(int[][] grid) {
	        int n = grid.length;

	        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
	            return -1;
	        }

	        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.weight, p2.weight));

	        int[][] dis = new int[n][n];

	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++) {
	                dis[i][j] = (int) 1e9;
	            }
	        }
	        dis[0][0] = 1;
	        pq.add(new Pair(0, 0, 0));

	        while (!pq.isEmpty()) {
	            Pair node = pq.poll();
	            int row = node.row;
	            int col = node.col;
	            int weight = node.weight;

	            int[] irow = { -1, 1, 0, 0, -1, 1, 1, -1 };
	            int[] icol = { 0, 0, 1, -1, 1, -1, 1, -1 };

	            for (int i = 0; i < 8; i++) {
	                int row1 = row + irow[i];
	                int col1 = col + icol[i];

	                if (row1 >= 0 && row1 < n && col1 >= 0 && col1 < n && dis[row1][col1] > 1 + dis[row][col]
	                        && grid[row1][col1] == 0) {
	                    dis[row1][col1] = 1 + dis[row][col];
	                    pq.add(new Pair(row1, col1, dis[row1][col1]));
	                }
	            }

	        }
	        if (dis[n - 1][n - 1] == 1e9) {
	            return -1;
	        }
	        return dis[n - 1][n - 1];

	    }
//	}

	class Pair {
	    int row;
	    int col;
	    int weight;

	    Pair(int row, int col, int weight) {
	        this.row = row;
	        this.col = col;
	        this.weight = weight;
	    }
	}
}
