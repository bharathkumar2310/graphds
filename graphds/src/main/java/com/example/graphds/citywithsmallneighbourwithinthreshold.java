package com.example.graphds;

public class citywithsmallneighbourwithinthreshold {
 
	class Solution {
	    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
	        int[][] matrix = new int[n][n];
	        int mincity =0;
	        int mincount1 =(int)1e9;
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++) {
	                if (i == j) {
	                    matrix[i][j] = 0;
	                    
	                } else {
	                    matrix[i][j] = (int) 1e9;
	                }
	            }
	        }

	        for (int[] edge : edges) {
	            int first = edge[0];
	            int second = edge[1];
	            int wt = edge[2];
	            matrix[first][second] = wt;
	            matrix[second][first] = wt;
	        }

	        for(int k=0;k<n;k++){
	            for(int i=0; i<n; i++){
	                for(int j=0; j< n ;j++){
	                    if(matrix[i][k] + matrix[k][j]<= matrix[i][j]){
	                        matrix[i][j] = matrix[i][k] + matrix[k][j];
	                    }
	                }
	            }
	        }

	        for(int i=0;i<n; i++){
	            int mincount =0;

	            for(int j=0;j<n;j++){
	                if(matrix[i][j] <= distanceThreshold){
	                    
	                     mincount ++;
	                }

	            }

	            if(mincount<=mincount1){
	                mincount1 = mincount;
	                mincity = i;
	            }
	        }
	       return mincity;
	    }
	}
}
