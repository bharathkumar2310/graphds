package com.example.graphds;

public class floydwarshal {

	

class Solution
{
    public void shortest_distance(int[][] matrix)
    {
        int n = matrix.length;
        
        for(int i=0;i<n; i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == -1){
                    matrix[i][j] = (int)1e9;
                }
            }
        }
        // Code here 
        for(int k=0;k<matrix.length; k++){
        for(int i=0; i< matrix.length; i++){
            for(int j=0; j< matrix[0].length; j++){
                if(matrix[i][k] + matrix[k][j] <matrix[i][j]){
                    matrix[i][j] = matrix[i][k] + matrix[k][j];
                }
            }
        }
        }
        
          for(int i=0;i<n; i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == 1e9){
                    matrix[i][j] = -1;
                }
            }
        }
        
    }
}
}
