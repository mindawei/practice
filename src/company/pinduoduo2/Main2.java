package company.pinduoduo2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main2 {
	   
    static class Node{
    	String k;
    	List<Node> childs = new ArrayList<Node>();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
     
        Node[] nodes = new Node[n];
        
        for(int i=0;i<n;++i){
        	nodes[i] = new Node();
        }
        
        Node root = null;
        for(int i=0;i<n;++i){
        	nodes[i].k = sc.next();
        	
        	int parent = sc.nextInt();
        	if(parent==-1){
        		root = nodes[i];
        	}else{
        		nodes[parent].childs.add(nodes[i]);
        	}
        }

        dfs(root,"");
       
    }

	private static void dfs(Node root, String prefix) {
				
		for (int i = 0; i < prefix.length(); ++i) {
			if (i < prefix.length() - 4) {
				if (prefix.charAt(i) == '|') {
					System.out.print('|');
				} else {
					System.out.print(' ');
				}
			} else {
				System.out.print(prefix.charAt(i));
			}
		}

		System.out.println(root.k);
		
		Collections.sort(root.childs,new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.k.compareTo(o2.k);
			}
		});
		
		int n = root.childs.size();
		for(int i=0;i<n;++i){
			if(i==n-1){
				dfs(root.childs.get(i), prefix+"`-- ");
			}else {
				dfs(root.childs.get(i), prefix+"|-- ");
			}
		}
		
	}
}
