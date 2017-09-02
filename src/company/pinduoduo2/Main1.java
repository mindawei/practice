package company.pinduoduo2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        boolean[] isEat = new boolean[m];
        int[] a = new int[m];
        for(int i=0;i<m;++i){
        	a[i] = sc.nextInt();
        }
        
        // small big
        Arrays.sort(a);
    
        class Node{
        	int k;
        	int v;
        }
        
        Node[] nodes = new Node[n];
        for(int i=0;i<n;++i){
        	nodes[i] = new Node();
        	nodes[i].k = sc.nextInt();
        	nodes[i].v = sc.nextInt();
        }
        
        Arrays.sort(nodes,new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o2.k - o1.k;
			}
		});
        
        
        for(Node node : nodes){
        	int v = node.v;
        	for(int i=a.length-1;i>=0;--i){
        		if(!isEat[i] && a[i]<=v){
        			v-=a[i];
        			isEat[i] = true;
        			if(v==0){
        				break;
        			}
        		}
        	}
        	System.out.println(v);
        }
        
    }

}
