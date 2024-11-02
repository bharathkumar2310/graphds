package com.example.graphds;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;



 

//Example 1:
//
//Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
//Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
//Explanation: There are 2 shortest transformation sequences:
//"hit" -> "hot" -> "dot" -> "dog" -> "cog"
//"hit" -> "hot" -> "lot" -> "log" -> "cog"
//Example 2:
//
//Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
//Output: []
//Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 
public class wordladder2 {

	
//	class Solution {
	    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
	        ArrayList<String>updatedLevel = new ArrayList<>();
	        List<List<String>>ans = new ArrayList<>();
	        Queue<ArrayList<String>>q = new LinkedList<>();
	         Set<String> s = new HashSet<>();
	         for(String word : wordList){
	            s.add(word);
	         }
	         ArrayList<String>ls = new ArrayList<>();
	         ls.add(beginWord);
	         q.add(ls);
	         int level =0;

	         while(!q.isEmpty()){

	            ArrayList<String> node = q.poll();
	            String last = node.get(node.size()-1);
	            if(last.equals(endWord)){
	                if(ans.size() == 0 || ans.get(0).size() == node.size()){
	                    ans.add(node);
	                }
	            }
	            if(level<node.size()){
	                level++;
	                for(String it : updatedLevel){
	                    s.remove(it);
	                }
	            }
	            for(int i=0;i<beginWord.length();i++){

	                for(char c='a' ; c<='z'; c++){

	                    char[] charArray = last.toCharArray();
	                    charArray[i] = c;
	                    String word1 = new String(charArray);

	                    if(s.contains(word1)){
	                        node.add(word1);
	                   ArrayList < String > temp = new ArrayList < > (node);
	                       updatedLevel.add(word1);
	                        q.add(temp);
	                        node.remove(node.size()-1);
	                    }
	                }
	            }

	         }

	      return ans;
	    }
	}
//}
