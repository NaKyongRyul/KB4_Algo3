package Day6.P_크레인인형뽑기;

import java.util.Stack;

public class P_크레인인형뽑기_염혜정 {
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> res = new Stack<>(); // 결과를 담을 스택 바구니

        for(int i : moves){
            int j = 0;
            while(j<board.length && board[j][i-1]==0) j++;

            if(j==board.length) continue;
            if(res.isEmpty() || ! res.peek().equals(board[j][i-1])) res.push(board[j][i-1]);
            else if (res.peek().equals(board[j][i-1])){
                res.pop();
                answer += 2;
            }
            board[j][i-1] = 0;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        System.out.println(solution(board, moves));

    }
}
