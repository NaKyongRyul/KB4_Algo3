package Day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B14502_연구소_김원우 {

    static int n,m;
    static int [][] arr;

    static int[] di = new int[]{-1, 1, 0, 0};
    static int[] dj = new int[]{0, 0, -1, 1};
    static int max = Integer.MIN_VALUE;
    static void bfs() {
        int[][] tmpList = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tmpList[i][j] = arr[i][j];
            }
        } // 1차원배열은 clone을 쓰면 깊은복사가 되지만 2차원배열은 깊은복사가 안됐다..
        // 파이썬이랑 다른 부분.
        // 이거때문에 삽질했다.


        Queue<int[]> q = new LinkedList<>();

        System.out.println("-------------------------bfs--------");
        System.out.println(Arrays.deepToString(tmpList));

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tmpList[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
            }
        }
        while (!q.isEmpty()) {
            int [] tmp = q.poll();

            int cur_i = tmp[0];
            int cur_j = tmp[1];

            for (int i = 0; i < 4; i++) {
                int ni = cur_i + di[i];
                int nj = cur_j + dj[i];

                if (ni < 0 || ni >= n || nj < 0 || nj >= m) {
                    continue;
                }
                if (tmpList[ni][nj] == 1) continue;

                if (tmpList[ni][nj] == 0) {
                    tmpList[ni][nj] = 2;
                    q.offer(new int[]{ni, nj});
                }
            }

        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tmpList[i][j] == 0) {
                    cnt++;
                }
            }
        }
        if (max < cnt) max = cnt;
    }
    static void wall(int cnt) {
        if (cnt == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    wall(cnt+1);
                    arr[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 입력끝

        System.out.println("--------------------------------");
        System.out.println(Arrays.deepToString(arr));
        wall(0);
        System.out.println(max);
    }
}
