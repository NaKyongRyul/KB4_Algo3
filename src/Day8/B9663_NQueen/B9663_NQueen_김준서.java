package Day8.B9663_NQueen;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class B9663_NQueen_김준서 {
    static int[] board;
    static int N, answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        board = new int[N];
        for (int i = 0; i < N; i++) {
            board[0]=i;
            dfs(1);
        }
        System.out.println(answer);
    }

    static void dfs(int level) {
        if (level == N) {
            answer+=1;
            return;
        }
        for (int i = 0; i < N; i++) {
            boolean isOk = true;
            for (int j = 0; j < level; j++) {
                if (board[j] == i || Math.abs(board[j] - i) == Math.abs(j - level)) {
                    isOk = false;
                    break;
                }
            }
            if (isOk) {
                board[level] = i;
                dfs(level + 1);
            }
        }
    }
}