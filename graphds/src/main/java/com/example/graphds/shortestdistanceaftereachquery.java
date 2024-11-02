package com.example.graphds;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class shortestdistanceaftereachquery {

	class Solution {
	    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {

	        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
	        for(int i=0; i<n; i++){
	            
	            adj.add(new ArrayList<>());
	        }
	        int[] ans1 = new int[queries.length];
	        for(int i=0; i<n-1; i++){
	            adj.get(i).add(i+1);
	        }
	        ArrayList<Integer> ans = new ArrayList<>();

	        for(int i=0; i<queries.length; i++){
	            adj.get(queries[i][0]).add(queries[i][1]);
	            ans1[i] = find(ans, queries, adj, n);
	        }

	        
	        return ans1;

	    }

	    int find(ArrayList<Integer> ans, int[][] queries, ArrayList<ArrayList<Integer>>adj, int n){
	        Queue<int[]> pq = new LinkedList<>();
	        boolean[] vis = new boolean[n];
	        pq.add(new int[]{0,0});
	        vis[0] =true;
	        while(!pq.isEmpty()){
	            int[] pair = pq.poll();
	            int node = pair[0];
	            int count = pair[1];
	            

	            for(Integer it: adj.get(node)){

	                if(it == n-1){
	                    return count+1;
	                }
	                
	                if(vis[it] ==false){
	                pq.add(new int[]{it, count +1});
	                vis[it] =true;
	                }
	            }
	        }
	        return -1;
	    }

	   
	   
	}
}
