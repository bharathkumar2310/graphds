package com.example.graphds;

import java.util.ArrayList;

public class bellmanford {

	class Solution {
	    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
	        // Write your code here
	        int dis[] = new int[V];
	        for(int i=0; i< V; i++){
	            dis[i] = (int)1e8;
	        }
	        dis[S] =0;

	        for(int i=0; i< V; i++){
	            
	            for(ArrayList<Integer> it : edges){
	                int first = it.get(0);
	                int second = it.get(1);
	                int wt = it.get(2);
	                
	                if( dis[first] != 1e8 && dis[first] + wt< dis[second]){
	                    dis[second] = (dis[first] + wt);
	                }
	            }
	           
	            
	        }
	        
	          
	            for(ArrayList<Integer> it : edges){
	                int first = it.get(0);
	                int second = it.get(1);
	                int wt = it.get(2);
	                
	                if(dis[first] != 1e8 && dis[first] + wt< dis[second]){
	                    int [] temp = new int[1];
	                    temp[0] = -1;
	                    return temp;
	                }
	            }
	        return dis;
	    }
	}

}
