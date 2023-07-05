package day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2615_오목_신선영 {
    static int[][] board;
    static int ans = 0;
    static void go1(int x, int y, int len, int dir, int w) {
        if (len == 5) {
            if (dir == 1) { // y 증가 1, x 그대로 (오른쪽)
                if ((y + 1) <= 20 && board[x][y + 1] != w) {
                    System.out.println(w);
                    System.out.print(x + " ");
                    System.out.print(y - 4);
                    ans = 1;
                }
                return;
            } else if (dir == 2) {  // y 그대로, x 증가 1 (아래)
                if ((x + 1) <= 20 && board[x + 1][y] != w) {
                    System.out.println(w);
                    System.out.print(x - 4 + " ");
                    System.out.print(y);
                    ans = 1;
                }
                return;
            } else if (dir == 3) {  // x 감소 1, y 증가 1 (위 대각선)
                if (0 <= (x - 1) && (y + 1) <= 20 && board[x - 1][y + 1] != w) {
                    System.out.println(w);
                    System.out.print(x + 4 + " ");
                    System.out.print(y - 4);
                    ans = 1;
                }
                return;
            } else if (dir == 4) {  // x 증가 1, y 증가 1 (아래 대각선)
                if ((x + 1) <= 20 && (y + 1) <= 20 && board[x + 1][y + 1] != w) {
                    System.out.println(w);
                    System.out.print(x - 4 + " ");
                    System.out.print(y - 4);
                    ans = 1;
                }
                return;
            }
        }

        if (dir == 1) {
            if ((y + 1) < 20 && board[x][y + 1] == w) {
                go1(x, y + 1, len + 1, 1, w);
            }
        } else if (dir == 2) {
            if ((x + 1) < 20 && board[x + 1][y] == w) {
                go1(x + 1, y, len + 1, 2, w);
            }
        } else if (dir == 3) {
            if (0 <= (x - 1) && (y + 1) < 20 && board[x - 1][y + 1] == w) {
                go1(x - 1, y + 1, len + 1, 3, w);
            }
        } else if (dir == 4) {
            if ((x + 1) < 20 && (y + 1) < 20 && board[x + 1][y + 1] == w) {
                go1(x + 1, y + 1, len + 1, 4, w);
            }
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        board = new int[21][21];

        for (int i = 0; i < 18; i++) {
            for (int j = 0; j < 19; j++) {
                board[i + 1][j + 1] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
        }

        for (int j = 0; j < 19; j++) {
            board[19][j + 1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (board[i][j] == 1) {
                    if ((j - 1) >= 0 && board[i][j - 1] != 1) {
                        go1(i, j, 1, 1, 1);
                    }
                    if ((i - 1) >= 0 && board[i - 1][j] != 1) {
                        go1(i, j, 1, 2, 1);
                    }
                    if (0 <= (j - 1) && (i + 1) < 20 && board[i + 1][j - 1] != 1) {
                        go1(i, j, 1, 3, 1);
                    }
                    if (0 <= (i - 1) && 0 <= (j - 1) && board[i - 1][j - 1] != 1) {
                        go1(i, j, 1, 4, 1);
                    }
                }
                if (board[i][j] == 2) {
                    if ((j - 1) >= 0 && board[i][j - 1] != 2) {
                        go1(i, j, 1, 1, 2);
                    }
                    if ((i - 1) >= 0 && board[i - 1][j] != 2) {
                        go1(i, j, 1, 2, 2);
                    }
                    if (0 <= (j - 1) && (i + 1) < 20 && board[i + 1][j - 1] != 2) {
                        go1(i, j, 1, 3, 2);
                    }
                    if (0 <= (i - 1) && 0 <= (j - 1) && board[i - 1][j - 1] != 2) {
                        go1(i, j, 1, 4, 2);
                    }
                }
            }
        }

        if (ans == 0) {
            System.out.println(0);
        }

    }
}
