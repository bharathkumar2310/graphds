package com.example.graphds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class evaluateDivision {
	
	class Solution {
	    class Pair {
	        String second;
	        double value;

	        Pair(String second, double value) {
	            this.second = second;
	            this.value = value;
	        }

	    }

	    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

	        int n = equations.size();
	        double[] ans = new double[queries.size()];

	        Map<String, List<Pair>> map = new HashMap<>();

	        for (int i = 0; i < n; i++) {
	            String node1 = equations.get(i).get(0);
	            String node2 = equations.get(i).get(1);
	            double value = values[i];
	            map.putIfAbsent(node1, new ArrayList<>());
	            map.putIfAbsent(node2, new ArrayList<>());

	            map.get(node1).add(new Pair(node2, value));
	            map.get(node2).add(new Pair(node1, 1.0 / value));
	        }

	        int[] vis = new int[map.size()];

	        for (int i = 0; i < queries.size(); i++) {

	            String fnode = queries.get(i).get(0);
	            String snode = queries.get(i).get(1);

	            if (map.containsKey(fnode) == false || map.containsKey(snode) == false) {
	                ans[i] = -1.0;
	            } else {

	                ans[i] = dfs(fnode, snode, map, new HashSet<>());
	            }

	        }
	        return ans;

	    }

	    double dfs(String fnode, String snode, Map<String, List<Pair>> map, Set<String> visited) {

	        if (fnode.equals(snode)) {
	            return 1.0;
	        }

	        if (map.containsKey(fnode) == false) {
	            return -1.0;
	        }
	        visited.add(fnode);

	        for (Pair node : map.get(fnode)) {
	            String fir = node.second;
	            double val = node.value;

	            if (visited.contains(fir) == false) {
	                double weigth = dfs(fir, snode, map, visited);
	                if (weigth != -1.0) {
	                    return weigth * val;
	                }
	            }

	        }

	        return -1.0;

	    }
	}


}
