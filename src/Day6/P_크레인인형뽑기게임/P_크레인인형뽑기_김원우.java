package Day6;
import java.util.Stack;

public class P_크레인인형뽑기_김원우 {

    static int solution(int[][] board, int[] moves) {

        int len_move = moves.length;
        int len_board = board.length;
        Stack<Integer> bucket = new Stack<>();

        int cnt = 0;
        int ans = 0;

        for (int i = 0; i < len_move; i++) {
            for (int j = 0; j < len_board; j++) {
                if (board[j][moves[i]-1] != 0) {

                    if (!bucket.isEmpty() && board[j][moves[i] - 1] == bucket.peek()) {
                        ans += 2;
                        bucket.pop();
                        board[j][moves[i]-1] = 0;
                        break;
                    }
                    bucket.add(board[j][moves[i]-1]);
                    board[j][moves[i]-1] = 0;
                    break;
                }
            }
        }
        System.out.println(ans);

        int answer = ans;
        return answer;
    }
    public static void main(String[] args) {
        int[][] board = new int[][]{{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = new int[]{1, 5, 3, 5, 1, 2, 1, 4};
        solution(board, moves);

    }
}
