import java.util.Scanner;

public class B9663_NQueen_신선영 {
    static int N;
    static int ans;
    static int[] column;

    static void queen(int row) {    // DFS + 백트래킹
        if (row == N) {
            ans++;  // 마지막 행 값까지 채운 경우 답 += 1 (방법의 수 카운트)
            return;
        }

        for (int j = 0; j < N; j++) {   // 0번 열에서 N-1 열까지 확인
            boolean check = true;
            for (int i = 0; i < row; i++) { // 이전 행의 값들로 유망 확인
                if (column[i] == j || (Math.abs(i - row) == Math.abs(column[i] - j))) {
                    check = false;
                    break;
                }
            }
            if (check) {
                column[row] = j;
                queen(row + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        column = new int[N]; // 인덱스는 행, 열의 값만을 담은 1차원 배열
        ans = 0;    // 경로가 완성된 경우 카운트할 답

        queen(0);   // 0번째 행부터 값 확인
        System.out.println(ans);
    }
}
