package Day8.B2178_미로탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2178_미로탐색_김진형 {
    static int rowSize;
    static int colSize;

    static int[][] board;
    static boolean[][] visited;
    static int[][] dist;

    static final int[] dx = new int[]{-1, 1, 0, 0};
    static final int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());
        board = new int[rowSize][colSize];
        visited = new boolean[rowSize][colSize];
        dist = new int[rowSize][colSize];
        for (int i = 0; i < rowSize; ++i) {
            String temp = br.readLine();
            for (int j = 0; j < colSize; ++j) {
                board[i][j] = temp.charAt(j) - '0';
            }
        }
        BFS();
        System.out.println(dist[rowSize - 1][colSize - 1]);
    }

    private static void BFS() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        dist[0][0] = 1;
        visited[0][0] = true;
        while (!q.isEmpty()) {
            int[] currNode = q.poll();
            int currRow = currNode[0];
            int currCol = currNode[1];
            if (currRow == rowSize - 1 && currCol == colSize - 1) {
                break;
            }
            for (int i = 0; i < 4; ++i) {
                int tempRow = currRow + dx[i];
                int tempCol = currCol + dy[i];
                if (tempRow < 0 || tempCol < 0 || tempRow >= rowSize || tempCol >= colSize) {
                    continue;
                }
                if (visited[tempRow][tempCol]) {
                    continue;
                }
                if (board[tempRow][tempCol] == 0) {
                    continue;
                }
                visited[tempRow][tempCol] = true;
                dist[tempRow][tempCol] = dist[currRow][currCol] + 1;
                q.offer(new int[]{tempRow, tempCol});
            }
        }
    }
}
