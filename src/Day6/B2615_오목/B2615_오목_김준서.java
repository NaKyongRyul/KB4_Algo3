package Day6.B2615_오목;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2615_오목_김준서 {
    static int[][] board;
    static int dx[] = {0,1,0,-1,-1,1,-1,1};
    static int dy[] = {1,0,-1,0,-1,1,1,-1};
    static boolean terminate = false;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        board = new int[19][19];
        for (int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 19; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                for (int k = 0; k < 8; k++) {
                    if (board[j][i] != 0) {
                        dfs(j, i, 1, k);
                    }
                }
            }
        }
        if (!terminate) {
            System.out.println(0);
        }

    }

    public static void dfs(int x, int y,int level,int dir) {
        int user = board[x][y];
        if (terminate) {
            return;
        }
        if (level == 5) {
            int tX = x+dx[dir];
            int tY = y + dy[dir];
            if (!(0 <= tX && tX < 19 && 0 <= tY && tY < 19) || board[tX][tY] != user ) {
                terminate=true;
                int X =x-dx[dir]*4;
                int Y = y-dy[dir]*4;
                System.out.println(user);
                System.out.println((X+1)+" "+(Y+1));
            }
            return;
        }
        int X = x + dx[dir];
        int Y = y + dy[dir];
        int pX = x - dx[dir];
        int pY = y - dy[dir];

        if (level!=1 || !(0<=pX && pX<19 && 0<=pY && pY<19) || board[pX][pY] != user) {
            if (0 <= X && X < 19 && 0 <= Y && Y < 19 && board[X][Y] == user) {
//            System.out.println("user : "+user+ " cur_level : "+level + " from "+(x+1)+" "+(y+1)+" to " +(X+1)+" "+(Y+1)+" dir "+dir);
                dfs(X, Y, level + 1, dir);
            }
        }

    }

}
