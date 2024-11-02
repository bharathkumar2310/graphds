package com.example.graphds;

import java.util.ArrayList;
import java.util.Stack;

//In a topological sort, for every directed edge u -> v, 
//u must come before v in the ordering.



public class topologicalsort {


//class Solution
//{
    //Function to return list containing vertices in Topological order. 
     int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int j=0;
        // add your code here
        int[] vis = new int[V];
        Stack<Integer>s = new Stack<>();
        for(int i=0 ; i< V; i++){
            if(vis[i]==0){
                dfs(i, s, adj, vis);
            }
        }
            int[] ans = new int[s.size()];

        while(!s.isEmpty()){
            ans[j++] = s.peek();
            s.pop();
        }
       
        return ans;
    }
    
    void dfs(int i , Stack<Integer> s,  ArrayList<ArrayList<Integer>> adj, int[] vis){
            vis[i]=1;

        for(Integer it: adj.get(i)){
            if(vis[it]==0){
                dfs(it, s, adj, vis);
                
            }
            
        }
        s.push(i);
    }
    
}

//}
