package Day9.B14502_연구소;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class B14502_연구소_김준서 {
    static int[][] board;
    static int safe,N,M ;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static ArrayList<pos> virus;
    static ArrayList<pos> safeArea;
    public static class pos{
        public int x,y;

        public pos() {

        }

        public pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int answer = 0;
        board = new int[N][M];
        virus =new ArrayList<pos>();
        safeArea = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 0) {
                    safe++;
                    safeArea.add(new pos(i, j));
                } else if (board[i][j] == 2) {
                    virus.add(new pos(i, j));
                }
            }
        }
        for (int i = 0; i < safeArea.size()-2; i++) {
            int ix = safeArea.get(i).x;
            int iy = safeArea.get(i).y;
            board[ix][iy]=1;
            for (int j = i + 1; j < safeArea.size()-1; j++) {
                int jx = safeArea.get(j).x;
                int jy = safeArea.get(j).y;
                board[jx][jy]=1;
                for (int k = j + 1; k < safeArea.size(); k++) {
                    int kx = safeArea.get(k).x;
                    int ky = safeArea.get(k).y;
                    board[kx][ky]=1;
                    int tp = safe-3;
                    boolean[][] visited = new boolean[N][M];
                    for (pos vir : virus) {
                        int x = vir.x;
                        int y = vir.y;
                        tp -= bfs(x, y, visited);
                    }
                    answer = Math.max(answer, tp);
                    board[kx][ky]=0;
                }
                board[jx][jy]=0;
            }
            board[ix][iy]=0;
        }
        System.out.println(answer);

    }

    public static int bfs(int x, int y, boolean[][] visited) {
        int ans = 0;
        Queue<pos> queue = new LinkedList<>();
        queue.add(new pos(x, y));
        visited[x][y]=true;
        while (!queue.isEmpty()) {
            pos temp = queue.poll();
            int tx = temp.x;
            int ty = temp.y;
            for (int i = 0; i < 4; i++) {
                int X = tx + dx[i];
                int Y = ty + dy[i];
                if (0 <= X && X < N && 0 <= Y && Y < M && board[X][Y]==0 && !visited[X][Y]) {
                    queue.add(new pos(X, Y));
                    visited[X][Y]=true;
                    ans++;
                }
            }
        }
        return ans;
    }
}