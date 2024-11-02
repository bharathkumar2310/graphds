package com.example.graphds;

import java.util.List;
import java.util.PriorityQueue;

public class findsafewalkthrough {
	
	class Solution {
	    class Pair {
	        int row;
	        int col;
	        int cost;

	        Pair(int row, int col, int cost) {
	            this.row = row;
	            this.col = col;
	            this.cost = cost;
	        }
	    }

	    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

	        int[][] vis = new int[grid.size()][grid.get(0).size()];
	        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((p1, p2) -> Integer.compare(p1.cost, p2.cost));
	        if (grid.get(0).get(0) == 1) {
	            pq.add(new Pair(0, 0, 1));
	        } else {
	            pq.add(new Pair(0, 0, 0));
	        }
	        vis[0][0] = 1;
	        while (!pq.isEmpty()) {
	            Pair node = pq.poll();
	            int row = node.row;
	            int col = node.col;
	            int cost = node.cost;

	            if (row == grid.size() - 1 && col == grid.get(0).size() - 1 && cost < health) {
	                return true;
	            }

	            int[] irow = { -1, 1, 0, 0 };
	            int[] icol = { 0, 0, 1, -1 };
	            for (int k = 0; k < 4; k++) {
	                int nrow = irow[k] + row;
	                int ncol = icol[k] + col;
	                if (nrow >= 0 && nrow < grid.size() && ncol >= 0 && ncol < grid.get(0).size() && cost < health
	                        && vis[nrow][ncol] == 0) {
	                    vis[nrow][ncol] = 1;

	                    if (grid.get(nrow).get(ncol) == 1) {
	                        pq.add(new Pair(nrow, ncol, cost + 1));

	                    } else {
	                        pq.add(new Pair(nrow, ncol, cost));

	                    }
	                }
	            }

	        }
	        return false;
	    }
	}

}
