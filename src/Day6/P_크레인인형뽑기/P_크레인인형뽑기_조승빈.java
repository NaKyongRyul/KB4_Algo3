package Day6.P_크레인인형뽑기;

import java.util.Stack;

public class P_크레인인형뽑기_조승빈 {
    static int[][] board;
    static int[] moves;
    static Stack bucket;

    static int answer = 0;

    public int solution(int[][] board, int[] moves) {
        this.board = board;
        this.moves = moves;

        bucket = new Stack<Integer>();

        for (int i = 0; i < moves.length; i++) {
            int depth = 0;
            int target = moves[i] - 1;

            while(board[depth][target] == 0) {
                depth++;
                if (depth == board.length - 1) break;
            }

            int doll = board[depth][target];
            if (doll != 0) {
                board[depth][target] = 0;
                checkDollInBucket(doll);
            }
        }

        return answer;
    }

    private void checkDollInBucket(int doll) {
        if (!bucket.isEmpty()) {
            int topDoll = (int) bucket.peek();

            if (topDoll == doll) {
                bucket.pop();
                answer += 2;
            } else {
                bucket.add(doll);
            }
        } else {
            bucket.add(doll);
        }
    }
}
