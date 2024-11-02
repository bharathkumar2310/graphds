package com.example.graphds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class reconstructItenary {

	
	class Solution {
	    public List<String> findItinerary(List<List<String>> tickets) {
	        int n= tickets.size();
	        Map<String, PriorityQueue<String>>map = new HashMap<>();

	        List<String> ans = new ArrayList<>();

	        for(int i=0; i<n; i++){
	            String first = tickets.get(i).get(0);
	            String second = tickets.get(i).get(1);
	            if(map.containsKey(first)){
	                PriorityQueue<String> temp = map.get(first);
	                temp.add(second); 
	                map.put(first, temp);
	            }
	            else{
	                PriorityQueue<String> temp = new PriorityQueue<String>();
	                temp.add(second);
	                map.put(first, temp);


	            }
	        }
	        
	        dfs("JFK", map, ans);
	        return ans;
	    }

	    void dfs(String src, Map<String, PriorityQueue<String>>map, List<String> ans){
	        PriorityQueue<String> temp = map.get(src);
	        while(temp!= null && !temp.isEmpty()){
	            String dest = temp.poll();
	            dfs(dest, map, ans);
	        }
	        ans.add(0,src);
	    }
	}
}
