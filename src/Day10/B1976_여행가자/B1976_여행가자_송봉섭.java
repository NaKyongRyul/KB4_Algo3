package Day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1976_여행가자_송봉섭 {
    static int N;
    static int M;
    static int[][] city;
    static int[] plan;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        city = new int[N][N];
        plan = new int[M];
        parents = new int[N+1];
        // 배열 초기화
        for (int i = 0; i < N + 1; i++) {
            parents[i] = i;
        }


        String[] strings = new String[N];
        for (int i = 0; i < N; i++) {
            strings = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(strings[j]);
                if (city[i][j] == 1) {
                    //System.out.println("union");
                    union(i, j);
                }
            }
        }

        strings = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            plan[i] = Integer.parseInt(strings[i]) -1; // 하나씩 줄여서 저장
        }

//        System.out.println(Arrays.toString(parents));
//        System.out.println(Arrays.toString(plan));

        //int start = parents[plan[0]];
        for (int i = 0; i < M; i++) {
            if (i == M - 1) {
                System.out.println("YES");
                break;
            }
            if (parents[plan[i]] != parents[plan[i+1]]) {
                System.out.println("NO");
                break;
            }

        }



    }

    public static void union(int a, int b) {
        int x = find(a);
        int y = find(b);
        if (x != y) {
            if (x < y) {
                parents[y] = x;
            }
            else {
                parents[x] = y;
            }
        }
    }

    private static int find(int x) {
        if (x == parents[x]) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }
}

