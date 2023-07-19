package Day8.B9663_N-Queen;

import java.util.Scanner;

/**
 * 퀸 규칙:
 * 오와 열을 따라 이동하는 것은 물론 대각선으로도 이동할 수 있다.
 * 이동 중에 방향을 바꾸는 것은 허용되지 않는다.
 * 다른 말을 뛰어넘어 이동할 수 없다.
 */
public class B9663_N_Queen_최예빈 {

    static int N;
    static int[] board;
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        board = new int[N];

        backtracking(0);
        System.out.println(count);
    }

    private static void backtracking(int row) {
        if (row == N) { // n-queen success
            count++;
            return;
        }

        for (int col = 0; col < N; col++) {
            boolean possible = true;
            for (int before = row - 1; before >= 0; before--) {
                int diff = row - before;
                int nw = col - diff; // north-west
                int ne = col + diff; // north-east
                // 같은 열 금지 || 대각선 금지
                if (board[before] == col || board[before] == nw || board[before] == ne) {
                    possible = false;
                    break;
                }
            }

            // 해당 열에 퀸을 놓을 수 있다
            if (possible) {
                board[row] = col;
                backtracking(row + 1);
            }
        }
    }
}
