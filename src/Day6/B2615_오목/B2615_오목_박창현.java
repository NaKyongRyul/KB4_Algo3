package Day6.B2615_오목;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2615_오목_박창현 {
    static int[][] arr;

    static int[] dx = {0, 1, 1, 1};
    static int[] dy = {1, 0, 1, -1};
    static int[] res = {-1, -1};
    static int[] reversedx = {0, -1, -1, -1};
    static int[] reversedy = {-1, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Queue<Integer[]> q = new ArrayDeque<>();

        int max = 19;
        arr = new int[max][max];
        for (int i = 0; i < max; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < max; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max; j++) {
                if (arr[j][i] != 0) q.add(new Integer[]{arr[j][i], j, i});
            }
        }
        while (!q.isEmpty()) {
            Integer[] node = q.poll();
            for (int i = 0; i < dx.length; i++) {
                int tmp = 1;
                for (int j = 1; j < max; j++) {
                    if (node[1] + dx[i] * j < 0 || node[2] + dy[i] * j < 0 || node[1] + dx[i] * j >= max || node[2] + dy[i] * j >= max)
                        break;
                    if (arr[node[1] + dx[i] * j][node[2] + dy[i] * j] == node[0]) {
                        tmp++;
                    } else break;
                }
                if (tmp != 5) continue;
                for (int j = 1; j < max; j++) {
                    if (node[1] + reversedx[i] * j < 0 || node[2] + reversedy[i] * j < 0 || node[1] + reversedx[i] * j >= max || node[2] + reversedy[i] * j >= max)
                        break;
                    if (arr[node[1] + reversedx[i] * j][node[2] + reversedy[i] * j] == node[0]) {
                        tmp++;
                    } else break;
                }
                if (tmp != 5) continue;
                q.clear();
                res = new int[]{node[1], node[2]};
                break;
            }
        }
        if (res[0] == -1 || res[1] == -1) System.out.println(0);
        else {
            System.out.println(arr[res[0]][res[1]]);
            System.out.println((res[0] + 1) + " " + (res[1] + 1));
        }
    }
}
