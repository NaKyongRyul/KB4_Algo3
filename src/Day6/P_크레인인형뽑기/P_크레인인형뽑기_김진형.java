package Day6.P_크레인인형뽑기;

import java.util.Stack;

public class P_크레인인형뽑기_김진형 {
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        int rowSize = board.length;
        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < moves.length; ++i) {
            int currCol = moves[i] - 1;
            for (int j = 0; j < rowSize; ++j) {
                if (board[j][currCol] == 0) {
                    continue;
                }
                if (!stk.isEmpty()) {
                    if (stk.peek() == board[j][currCol]) {
                        answer += 2;
                        stk.pop();
                    } else {
                        stk.push(board[j][currCol]);
                    }
                } else {
                    stk.push(board[j][currCol]);
                }
                board[j][currCol] = 0;
            }
        }
        return answer;
    }
}
