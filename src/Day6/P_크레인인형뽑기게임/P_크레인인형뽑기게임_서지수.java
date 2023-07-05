package Day6.P_크레인인형뽑기게임;

import java.util.Stack;

public class P_크레인인형뽑기게임_서지수 {
	public static void main(String[] args) {

		int[][] board = new int[][] { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
				{ 3, 5, 1, 3, 1 } };
		int[] moves = new int[] { 1, 5, 3, 5, 1, 2, 1, 4 };

		Stack<Integer> stack = new Stack<>();

		// i, j
		// i =0 ~ board.length
		// j = moves[k]-1

		int answer = 0;
		for (int j = 0; j < moves.length; j++) {
			for (int i = 0; i < board.length; i++) {
				if (board[i][moves[j] - 1] != 0) {
					stack.push(board[i][moves[j] - 1]);
				//	System.out.println(stack);
					board[i][moves[j] - 1] = 0;
					if (stack.size() >= 2) {
						int peek = stack.pop();
						int popp = stack.pop();
						if (peek == popp) {
							answer+=2;
						//	System.out.println("answer"+answer);
							
						} else {
							stack.push(popp);
							stack.push(peek);
						//	System.out.println(result);
						}
					}
					break;
				}
			}
		}


		System.out.println(answer);
	}
}