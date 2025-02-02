package com.example.graphds;

import java.util.ArrayList;
import java.util.PriorityQueue;

// find shortest distance


public class dijiktrasalgo {


//class Solution
//{
    
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        int dis[] = new int[adj.size()];
        
        for(int i=0; i< adj.size(); i++){
            dis[i] =(int)1e9;
        }
        
        dis[S] =0;
        
       PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.weight, p2.weight));
        pq.add(new Pair(S, 0));
        while(!pq.isEmpty()){
            
            Pair node = pq.poll();
            
            
            
            int first = node.first;
            int weight = node.weight;
            
            for(ArrayList<Integer>it : adj.get(first)){
                
                   int node1 = it.get(0);
                   int wt = it.get(1);
                   if(dis[node1]> wt + dis[first] ){
                       dis[node1] = wt+ dis[first];
                       pq.add(new Pair(node1, dis[node1]));
                   }
               }
                
            }
                
            

        
        for(int i=0;i<adj.size(); i++){
            if(dis[i] == 1e9){
                dis[i] = -1;
            }
        }
        
        return dis;
    }
}


class Pair{
    int first;
    int weight;
    Pair(int first, int weight){
        this.first = first;
        this.weight =weight;
    }
}
//}
