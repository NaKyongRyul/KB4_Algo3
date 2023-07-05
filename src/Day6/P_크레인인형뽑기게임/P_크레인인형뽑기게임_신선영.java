import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int N = board.length;
        Stack <Integer> stack = new Stack<>();
        
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
        
        for (int m : moves) {
            for (int i = 0; i < N; i++) {
                int cur = board[i][m - 1];
                if (cur != 0) {
                    if (!stack.isEmpty() && stack.peek() == cur) {
                        answer += 2;
                        stack.pop();
                    } else {
                        stack.push(board[i][m - 1]);
                    }
                    board[i][m - 1] = 0;
                    break;
                }
            }
        }
        
        
        return answer;
    }
}
