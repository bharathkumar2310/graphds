package com.example.graphds;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class cheapflightwithkstops {

	
//	class Solution {
	    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
	        
	        int[] dis = new int[n];
	        for(int i=0;i<n;i++){
	            dis[i]=(int)1e9;
	        }
	        ArrayList<ArrayList<Pair>>adj = new ArrayList<>();
	        Queue<Pair1>pq = new LinkedList<>();
	        for(int i=0 ;i<n; i++){
	                 adj.add(new ArrayList<Pair>());
	        }

	        for(int[] flight : flights){
	            int node1 = flight[0];
	            int node2 = flight[1];
	            int dist = flight[2];

	            adj.get(node1).add(new Pair(node2,dist));    

	        }
	    
	    dis[src] =0;

	    pq.add(new Pair1(src,0,dis[src]));

	    while(!pq.isEmpty()){
	        Pair1 Node = pq.poll();
	        int node = Node.node;
	        int step = Node.step;
	        int wt = Node.wt;

	        for(Pair node1: adj.get(node)){
	            int first = node1.first;
	            int dist = node1.dist;
	            System.out.println(step);
	            System.out.println(node);

	            System.out.println(first);


	            if(k>=step && dis[first]> wt+dist ){
	            System.out.println("hi");
	                dis[first] = wt+dist;
	                System.out.println(dis[first]);
	                pq.add(new Pair1(first,step+1,wt+dist));
	            }
	        }
	    }

	       if(dis[dst] == 1e9){
	        return -1;
	       }
	        return dis[dst];
	    }

//	}

	class Pair{
	    int first;
	    int dist;

	    Pair(int first, int dist){
	        this.first = first;
	        this.dist =dist;
	    }
	}

	class Pair1{
	    int node;
	    int step;
	    int wt;

	    Pair1(int node, int step, int wt){
	        this.node = node;
	        this.step =step;
	        this.wt = wt;
	    }
	}
}
