package Day6.P_크레인인형뽑기게임;

import java.util.Stack;

public class P_크레인인형뽑기게임_곽승규 {

	public static void main(String[] args) {
		int [][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int [] moves = {1,5,3,5,1,2,1,4};
		
		int answer = 0;
        int moveCount = moves.length; // 움직이는 횟수
        Stack <Integer> stack = new Stack<Integer>(); // 바구니
        
        for (int m : moves) {
            // 해당 타겟이 있는 컬럼에 가서 순차적 탐색
            for (int j = 0; j < board.length; j++) {
                int current = board[j][m-1];
                if (current != 0) {
                    if (!stack.isEmpty() && stack.peek() == current) {
                        answer += 2;
                        stack.pop();
                    }
                    else {
                        stack.push(current);
                    }
                    board[j][m-1] = 0; 
                    break;
                }
            }
        }
        
        System.out.println(answer);

	}

}
