package com.example.graphds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//A node is a terminal node if there are no outgoing edges.
//A node is a safe node if every possible path starting from that node leads to a terminal node (or another safe node).
//Return an array containing all the safe nodes of the graph. 
//The answer should be sorted in ascending order.

 

public class eventualstate {

//	class Solution {
	    public List<Integer> eventualSafeNodes(int[][] graph) {

	        int n = graph.length;

	        
	        Queue<Integer> q = new LinkedList<>();
	        List<Integer> ans = new ArrayList<>();
	        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(n);
	        int[] indegree = new int[n];
	        for (int i = 0; i < n; i++) {
	            adj.add(new ArrayList<Integer>());
	        }
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < graph[i].length; j++) {
	                adj.get(graph[i][j]).add(i);
	                indegree[i]++;

	            }

	        }
	        for(int i=0;i<adj.size();i++){
	        for(Integer it: adj.get(i)){
	        System.out.println(it);
	        }
	        System.out.println("hi");
	        }
	        for (int i = 0; i < n; i++) {
	            if (indegree[i] == 0) {
	                q.add(i);
	            }
	        }
	        while (!q.isEmpty()) {
	            int node = q.poll();
	            ans.add(node);
	            for (Integer it : adj.get(node)) {
	                indegree[it]--;
	                if (indegree[it] == 0) {
	                    q.add(it);
	                }
	            }
	        }
	        Collections.sort(ans);

	        return ans;

	    }
	}
//}
