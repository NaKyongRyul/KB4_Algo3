package Day5;

import java.util.Arrays;
import java.util.Stack;

public class P_크레인인형뽑기_송봉섭 {

    public static void main(String[] args) {

        int [][] board = new int[][]{{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int []moves = {1,5,3,5,1,2,1,4};

        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
        //System.out.println(board[3][0]);

        System.out.println(solution(board,moves));

    }

    public static int solution(int[][] board, int[] moves) {

        int answer = 0;
        Stack<Integer> stack = new Stack<>(); // 바구니
        int pickPlace = 0; // 뽑는 위치

        for (int i = 0; i < moves.length; i++) {
            pickPlace = moves[i]; // 뽑는 위치
            int pick = 0; // 뽑은 인형
            for (int y = 0; y < board.length; y++) { // 세로 탐색
                if (board[y][pickPlace - 1] != 0) { // 0 아닌거 발견
                    pick = board[y][pickPlace - 1];
                    //System.out.println(" pick =" + pick);
                    if (!stack.isEmpty() && pick == stack.peek()) {
                        stack.pop();
                        answer += 2;
                    }
                    else {
                        stack.push(pick);
                    }
                    board[y][pickPlace - 1] = 0; // 뽑힘처리
                    break;

                }

            }
        }
        return answer;
    }
}
