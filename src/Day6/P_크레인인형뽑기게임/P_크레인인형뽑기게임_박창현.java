package Day6.P_크레인인형뽑기게임;

import java.util.Arrays;
import java.util.Stack;

public class P_크레인인형뽑기게임_박창현 {
    public static void main(String[] args) {
        int[][] testArr = new int[][]{{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
//                {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] testMove = {1, 2, 3, 4};
        //{1, 5, 3, 5, 1, 2, 1, 4};
        System.out.println(Solution.solution(testArr, testMove));
    }
}

class Solution {
    static Stack<Integer> stack = new Stack<>();
    static int answer = 0;

    static void canPush(int num) {
        boolean flag = false;
        if (!stack.isEmpty()&&stack.peek() == num) {
            stack.pop();
            answer+=2;
            if (!stack.isEmpty()) flag = true;
        } else {
            stack.push(num);
        }
        while (flag) {
            int tmp = stack.pop();
            if (!stack.isEmpty()&&stack.peek() == tmp) {
                stack.pop();
                answer+=2;
            } else {
                stack.push(tmp);
                flag=false;
            }
        }
    }

    static public int solution(int[][] board, int[] moves) {
        int[] tops = new int[board.length];
        //Stack<Integer> basket = new Stack<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 0) {
                    tops[j] = i + 1;
                }
            }
        }
        for (int[] arr : board)
            System.out.println(Arrays.toString(arr));
        System.out.println();
        System.out.println(Arrays.toString(tops));
        System.out.println();
        for (int m : moves) {
            int x = m - 1;
            int y = tops[x];
            if (y > board.length - 1) continue;
            canPush(board[y][x]);
            tops[x]++;
            System.out.println(board[y][x]);
        }
        //System.out.println(Arrays.toString(moves));
        return answer;
    }
}