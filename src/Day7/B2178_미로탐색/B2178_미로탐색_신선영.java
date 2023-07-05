import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2178_미로탐색_신선영 {
    static int N;
    static int M;
    static int[][] maze;
    static boolean[][] visited;
    static Queue<int[]> que;
    static int[] di;
    static int[] dj;

    static void BFS() {
        que.add(new int[]{1, 1});
        visited[1][1] = true;

        while (!que.isEmpty()) {
            int[] now = que.poll();
            int i = now[0];
            int j = now[1];

            if (i == N && j == M) {
                return;
            }

            for (int d = 0; d < 4; d++) {
                int ni = i + di[d];
                int nj = j + dj[d];

                if (1 <= ni && ni <= N && 1 <= nj && nj <= M && maze[ni][nj] != 0 && !visited[ni][nj]) {
                    maze[ni][nj] = maze[i][j] + 1;
                    visited[ni][nj] = true;
                    que.add(new int[]{ni, nj});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N + 1][M + 1];
        que = new ArrayDeque<>();
        visited = new boolean[N + 1][M + 1];
        di = new int[] {-1, 0, 1, 0};
        dj = new int[] {0, 1, 0, -1};

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 1; j < M + 1; j++) {
                maze[i][j] = str.charAt(j - 1) - 48;
            }
        }

        BFS();
        System.out.println(maze[N][M]);
    }
}
