package Day8.B9663_N-Queen;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B9663_N_Queen_김진형 {
    static int N;
    static int[] array;
    static long ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        // 상,하,좌,우,대각
        ans = 0;
        array = new int[N];

        for (int i = 0; i < N; ++i) { // 0행 열 설정
            array[0] = i;
            DFS(1);
        }
        System.out.println(ans);
    }

    private static void DFS(int currRow) {
        if (currRow == N) {
            ++ans;
            return;
        }
        for (int i = 0; i < N; ++i) {
            if (checkVertical(currRow, i) && checkDiagonal(currRow, i)) {
                array[currRow] = i;
                DFS(currRow + 1);
            }
        }
    }

    private static boolean checkDiagonal(int currRow, int colPos) {
        for (int row = 0; row < currRow; ++row) {
            if (Math.abs(array[row] - colPos) == Math.abs(row - currRow)) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkVertical(int currRow, int colPos) {
        for (int i = 0; i < currRow; ++i) {
            if (array[i] == colPos) {
                return false;
            }
        }
        return true;
    }
}
