package com.example.graphds;

import java.util.List;

public class findsafewalkthroughdfs {

	class Solution {
	    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
	        int[][] vis = new int[grid.size()][grid.get(0).size()]; 
	        boolean result ;
	        if(grid.get(0).get(0) == 1){
	         result = dfs(0,0,grid, health-1, vis);
	        }
	        else{
	         result = dfs(0,0,grid, health, vis);
	        }
	        return result;

	    }
	    boolean dfs(int row, int col, List<List<Integer>>grid,int health, int[][] vis){

	        if(row == grid.size()-1 &&  col == grid.get(0).size()-1 &&  health>0){
	            return true;
	        }

	        if(health<0){
	            return false;
	        }


	        int[] irow ={-1,1,0,0};
	        int[] icol = {0,0,1,-1};
	        vis[row][col] =1;

	        for(int k=0; k<4; k++){
	            int nrow = row + irow[k];
	            int ncol = col + icol[k];
	            if(nrow>=0 && nrow<grid.size() && ncol>=0 && ncol<grid.get(0).size() && vis[nrow][ncol] == 0){

	                if(grid.get(nrow).get(ncol) == 1){
	                   if(dfs(nrow,ncol,grid, health-1, vis)){
	                    return true;
	                   }

	                }
	                else{
	                    if(dfs(nrow,ncol,grid, health, vis)){
	                    return true;
	                   }
	                }
	                
	            }
	        }
	                vis[row][col] = 0;

	        return false;

	    }
	}
}
