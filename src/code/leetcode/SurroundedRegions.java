package code.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a 2D board containing'X'and'O', capture all regions surrounded by'X'.
 * A region is captured by flipping all'O's into'X's in that surrounded region .
 * 
 * https://www.nowcoder.com/practice/c159db5028034aa595043a1a220a62dd?tpId=46&tqId=29050&rp=1&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 *
 * @author mindw
 * @date 2017年8月7日
 */
public class SurroundedRegions {
	
	class Node{
		int x;
		int y;
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	/**
	 * 以下不是较好的解
	 * 较好的解法：从周围搜索，把O设置为一个中间状态，然后遍历整个，O->X,中间状态->O
	 */
    public void solve(char[][] board) {
    	
    	if(board==null||board.length==0||board[0].length==0){
    		return;
    	}
    	
    	int r = board.length;
    	int c = board[0].length;
        boolean[][] vis =  new boolean[r][c];
       
        Queue<Node> repo = new LinkedList<Node>();
        Queue<Node> que = new LinkedList<Node>();
       
        int[][] dirs = {
        		{-1,0},
        		{1,0},
        		{0,1},
        		{0,-1}
        };
        
        for(int i=0;i<r;++i){
        	for(int j=0;j<c;++j){
        		
        		if(vis[i][j]){
        			continue;
        		}
        		
        		vis[i][j] = true;
        		if(board[i][j]=='X'){
        			continue;
        		}
        		
        		Node node = new Node(i, j);
        		boolean isOK = true;
        		que.add(node);
        		repo.add(node);
        		
        		while(!que.isEmpty()){
        			node = que.poll();
        			int x = node.x;
        			int y = node.y;
        			for(int[] dir : dirs){
        				int nx = x+dir[0];
        				int ny = y+dir[1];
        				if(nx>=0&&nx<r&&ny>=0&&ny<c){
        					if(board[nx][ny]=='O'&&!vis[nx][ny]){
        						vis[nx][ny] = true;
        						node = new Node(nx, ny);
        						que.add(node);
        						repo.add(node);
        					}
        				}else{
        					isOK = false;
        				}
        			}
        		}
        		
        		while(!repo.isEmpty()){
        			node = repo.poll();
        			if(isOK){
        				board[node.x][node.y]='X';
        			}
        		}
        	}
        }
        
    }

	
    
}
