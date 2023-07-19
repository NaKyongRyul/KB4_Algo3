package Day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//탐색 그래프
public class B2178_미로탐색_송봉섭 {
    static int[][] maze;
    static int N;
    static int M;
    static boolean[][] visited;

    static int[][] distance;
    static int[] dx = { -1, 1, 0, 0 }; // 상하
    static int[] dy = { 0, 0, -1, 1 }; // 좌우

    static class Index {
        int value;
        int x;
        int y;
        public Index(int value, int x, int y) {
            this.value = value;
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new int[N][M]; //배열

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            String[] strings = s.split("");
            for(int j=0; j<M; j++) {
                maze[i][j] = Integer.parseInt(strings[j]);
            }
        }

        //입력값 확인
//        System.out.println(N);
//        System.out.println(M);
//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }

        visited = new boolean[N][M];
        visited[0][0] = true;

        distance = new int[N][M];
        distance[0][0] = maze[0][0];

        bfs(0,0);

        System.out.println(distance[N - 1][M - 1]);

    }
    private static void bfs(int x, int y) {
        Queue<Index> queue = new ArrayDeque<>();
        queue.add(new Index(maze[x][y], x, y));
        while (!queue.isEmpty()) {
            Index nowIndex = queue.poll();
            int nowX = nowIndex.x;
            int nowY = nowIndex.y;

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                // 0 ~ N-1 , 0 ~ M -1 , 방문
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M
                        ||visited[nextX][nextY] || maze[nextX][nextY] == 0)
                {
                    continue;
                }
                queue.add(new Index(maze[nextX][nextY] , nextX , nextY));
                //System.out.println("queue.add : " + nextX + "," + nextY + "  값 = " + maze[nextX][nextY]);
                distance[nextX][nextY] = distance[nowX][nowY] + 1;
                visited[nextX][nextY] = true;
            }
        }

    }
}
