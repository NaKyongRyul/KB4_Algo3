package Day6.P_크레인인형뽑기;

import java.util.Stack;

public class P_크레인인형뽑기_유유정 {

	public static void main(String[] args) {
		int [][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}}; // row 0이 제일 위 
		int [] moves = {1,5,3,5,1,2,1,4};
		int result = solution(board,moves);
		
	}
	public static int solution(int[][] board, int[] moves) {
		Stack<Integer> stack = new Stack<>();
		int answer =0;

		for(int i =0; i<moves.length;i++) {
			System.out.println("move: "+ (moves[i]-1));
			for(int j =0; j<board.length;j++) {
				
				if(board[j][moves[i]-1]==0) 
					continue;
				stack.add(board[j][moves[i]-1]);
//				System.out.println(stack.toString());
				if(stack.size()>1 && stack.peek()==stack.get(stack.size()-2)) {
					
					
					stack.pop();
					answer++;
					stack.pop();
					answer++;
//					System.out.println(" pop되었습니다.");

				}
				
				board[j][moves[i]-1]=0;
				break;
					
						
			}
			
			
		}
		System.out.println(answer);
		return answer;
	}

}
