package Day7.B2178_미로탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x;
    int y;
    int cnt;

    Point() {
    }

    Point(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}

public class B2178_미로탐색_임재현 {
    static int N, M;
    static boolean[][] arr;
    static boolean[][] visited;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        arr = new boolean[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = (line.charAt(j) == '0') ? false : true;
            }
        }
        Queue<Point> q = new ArrayDeque<Point>();
        q.add(new Point(0, 0, 1));
        visited[0][0] = true;
        while (!q.isEmpty()) {
            Point front = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = front.x + dx[k];
                int ny = front.y + dy[k];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                    continue;
                if (visited[nx][ny])
                    continue;
                if (!arr[nx][ny])
                    continue;
                if (nx == N - 1 && ny == M - 1) {
                    System.out.println(front.cnt + 1);
                    return;
                }
                q.add(new Point(nx, ny, front.cnt + 1));
                visited[nx][ny] = true;
            }
        }
    }
}
