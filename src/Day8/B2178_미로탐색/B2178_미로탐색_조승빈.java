package Day8.B2178_미로탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2178_미로탐색_조승빈 {
    static int N;
    static int M;

    static int X = 0;
    static int Y = 1;
    static int D = 2;

    static Queue<int[]> Q;

    static int[][] board;
    static boolean[][] visited;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, -1, 0, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = row.charAt(j) - '0';
            }
        }

        bfs(0, 0);
    }

    private static void bfs(int x, int y) {
        visited[x][y] = true;
        int[] element = new int[] { x, y, 1 };
        Q = new ArrayDeque<>();
        Q.offer(element);
        while(!Q.isEmpty()) {
            int[] now = Q.poll();

            int nd = now[D] + 1;

            if (now[X] == N - 1 && now[Y] == M - 1) {
                System.out.print(now[D]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now[X] + dx[i];
                int ny = now[Y] + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }

                if (!visited[nx][ny] && board[nx][ny] != 0) {
                    visited[nx][ny] = true;
                    Q.offer(new int[] { nx, ny, nd });
                }
            }
        }
    }
}
