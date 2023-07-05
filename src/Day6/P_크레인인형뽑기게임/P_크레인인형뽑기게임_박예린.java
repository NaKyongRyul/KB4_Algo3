package Day6.P_크레인인형뽑기게임;

import java.util.Stack;

public class P_크레인인형뽑기게임_박예린 {
	public static void main(String[] args) {
		int [][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int [] moves = {1,5,3,5,1,2,1,4};
		
		int bLen = board.length;
		int mLen = moves.length;
		
		Stack<Integer> stack = new Stack<>();
		
		int doll = 0;
		int count = 0;
		
		for(int i = 0; i < mLen; i++) {
			for(int j = 0; j < bLen; j++) {
				doll = board[j][moves[i]-1];
				if(doll != 0) {
					if(!stack.isEmpty() && stack.peek() == doll) {
						stack.pop();
						count += 2;
					} else stack.add(doll);
					board[j][moves[i]-1] = 0;
					break;
				} else doll = 0;
			}
		}
		System.out.println(count);
	}
}