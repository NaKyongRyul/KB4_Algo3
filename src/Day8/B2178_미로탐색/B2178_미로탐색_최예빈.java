package Day8.B2178_미로탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 최솟값. bfs 추천.
 */
public class B2178_미로탐색_최예빈 {

    static int N, M;
    static int[][] maze, visited;
    static Queue<Coordinate> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N][M];
        visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                maze[i][j] = Integer.parseInt(String.valueOf(chars[j]));
            }
        }

        bfs(0, 0);

        System.out.println(visited[N - 1][M - 1]);
    }

    private static void bfs(int x, int y) {

        queue = new ArrayDeque<>();

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        queue.add(new Coordinate(x, y, 1));
        visited[x][y] = 1;

        while (!queue.isEmpty()) {
            Coordinate co = queue.poll();

            if (co.x == N - 1 && co.y == M - 1) return; // 도착

            for (int d = 0; d < 4; d++) {
                int nx = co.x + dx[d];
                int ny = co.y + dy[d];

                if (nx < 0 || nx > N - 1 || ny < 0 || ny > M - 1) continue;
                if (maze[nx][ny] == 0 || visited[nx][ny] != 0) continue;

                queue.add(new Coordinate(nx, ny, co.ord + 1));
                visited[nx][ny] = co.ord + 1;
            }
        }
    }

    private static class Coordinate {
        int x, y, ord;

        public Coordinate(int x, int y, int ord) {
            this.x = x;
            this.y = y;
            this.ord = ord;
        }
    }
}
