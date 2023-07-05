package Day7.B2178_미로탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2178_미로탐색_박창현 {
    static int[][] maze;
    static int Y;
    static int X;
    static int count = 0;

    static void bfs() {
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};

        Queue<int[]> s = new ArrayDeque<>();
        s.add(new int[]{Y-1, X-1});

        while (!s.isEmpty()) {
            int[] now = s.poll();
            int i = now[0];
            int j = now[1];

            if (i == 0 && j == 0) {
                System.out.println((maze[i][j]) + count);
                break;
            }

            for (int k = 0; k < 4; k++) {
                int ni = i + dx[k];
                int nj = j + dy[k];

                if (ni >= 0 && ni < Y && nj >= 0 && nj < X && maze[ni][nj] == 1) {
                    s.add(new int[]{ni, nj});
                    maze[ni][nj] = maze[i][j]+1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(bf.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        byte[][] arr = new byte[Y][X];
        maze = new int[Y][X];

        for (int i = 0; i < Y; i++) {
            arr[i] = bf.readLine().getBytes();
        }

        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                maze[i][j] = Byte.toUnsignedInt(arr[i][j])-'0';
            }
        }

        bfs();

        bf.close();
    }
}
