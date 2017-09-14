package company.jd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
	   
    static class Node{
    	String k;
    	List<Node> childs = new ArrayList<Node>();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while(sc.hasNextLine()){
        	String line = sc.nextLine();
        	sovle(line);
 
        }      
    }
    
    
    private static void sovle(String line){
    	String strs[] = line.split(";");
    	int n = strs.length;
    	
    	if(n<3){
    		System.out.println("incorrect data");
    		return;
    	}
    	
    	 Node[] nodes = new Node[n];
         
         for(int i=0;i<n;++i){
         	nodes[i] = new Node();
         }
         
         Node root = null;
         for(int i=0;i<n;++i){
        	 
        	String[] parts = strs[i].split(",");
        	 
        	int idx = Integer.parseInt(parts[0]) - 1;
         	nodes[idx].k = parts[1];
         	
         	int parent = Integer.parseInt(parts[2]) - 1;
         	if(parent==-1){
         		root = nodes[idx];
         	}else{
         		nodes[parent].childs.add(nodes[idx]);
         	}
         }
         LinkedList<String> ans = new LinkedList<>();
         LinkedList<String> paths = new LinkedList<>();
         paths.add(root.k);
         dfs(root,paths,ans);
         
         for(int i=0;i<ans.size();++i){
        	 if(i>0){
        		 System.out.print(";");
        	 }
        	 System.out.print(ans.get(i));
         }
         System.out.println();
    }

	private static void dfs(Node root, LinkedList<String> paths,List<String> ans) {
		int n = root.childs.size();
		if(n==0){
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<paths.size();++i){
				if(i>0){
					sb.append('-');
				}
				sb.append(paths.get(i));
			}
			ans.add(sb.toString());
		}else{
			for(int i=0;i<n;++i){
				Node child = root.childs.get(i);
				paths.add(child.k);	
				dfs(child, paths,ans);
				paths.removeLast();
			}
		}
		
	}
}
