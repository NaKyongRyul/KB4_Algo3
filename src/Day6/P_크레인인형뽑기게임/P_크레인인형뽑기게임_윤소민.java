package Day6.P_크레인인형뽑기게임;

import java.util.*;


public class P_크레인인형뽑기게임_윤소민 {

	public int solution(int[][] board, int[] moves) {
		// int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1}, {4,2,4,4,2},{3,5,1,3,1}};
		// int [] moves = {1,5,3,5,1,2,1,4};//stack[i] -1
	    int N = board.length; 
	    int M = N;
	    
	    int cnt=0;
	    
        Stack<Integer>[] stack = new Stack[N];
        Stack<Integer> basket = new Stack<Integer>();
        
        for (int i = 0; i < N; i++) {
        	stack[i] = new Stack<>();
	        
	      }
        for (int i = 0; i < N*N; i++) {
        	basket = new Stack<>();
	        
	      }
       
        
        for(int i=N-1;i>=0;i--){
            for(int j=M-1;j>=0;j--){
            	if(board[j][i]!=0)
            		stack[i].push(board[j][i]);
                
            }

        }

        
        basket.push(0);
        
        for(int m :moves) {
        	if(!stack[m-1].isEmpty()) {
        		int popN = stack[m-1].pop();

        		if(basket.peek() == popN) {
        			basket.pop();
        			cnt +=2;
        		}
        		else
        			basket.push(popN);
        	}
        }
        return cnt;
    }

}
