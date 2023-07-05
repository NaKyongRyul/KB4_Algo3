package Day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2178_미로탐색_김원우 {

    static int n;
    static int m;
    static int [][] arr;

    static boolean [][] visited;

    static int[] di = new int[]{-1, 1, 0, 0}; // 상하좌우
    static int[] dj = new int[]{0, 0, -1, 1};
    static void bfs(int i, int j) {
        Queue<int []> queue = new LinkedList<>();
        queue.offer(new int[]{i,j});
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cur_i = cur[0];
            int cur_j = cur[1];

            if (cur_i == n-1 && cur_j == m-1) break;

            for (int k = 0; k < 4; k++) {
                int ni = cur_i + di[k];
                int nj = cur_j + dj[k];

                if (ni < 0 || ni >= n|| nj < 0 || nj >= m) continue;
                if (visited[ni][nj]) continue;

                if (arr[ni][nj] == 1) {
                    queue.offer(new int[]{ni, nj});
                    visited[ni][nj] = true;
                    arr[ni][nj] = arr[cur_i][cur_j] + 1;
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
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String a = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = Character.getNumericValue(a.charAt(j));
            }
        }

        bfs(0, 0);
        System.out.println(arr[n-1][m-1]);
    }
}
