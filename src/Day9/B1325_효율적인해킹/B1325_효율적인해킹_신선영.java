package day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1325_효율적인해킹_신선영 {
    static int N;
    static int M;
    static int max;
    static int[] ans;
    static ArrayList<Integer>[] computers;

    static void hack(int start) {
        int cnt = 0;
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int n : computers[cur]) {
                if (!visited[n]) {
                    visited[n] = true;
                    ans[n]++;
                    q.add(n);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 컴퓨터: 1 ~ N번
        M = Integer.parseInt(st.nextToken());   // 신뢰하는 관계: M개

        // 입력 받을 arr 생성: 1 ~ N번까지의 컴퓨터 (0 사용 X)
        computers = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            computers[i] = new ArrayList<>();
        }

        // 신뢰 관계 입력 받기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            computers[a].add(b);
        }


        ans = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            hack(i);
        }

        max = 0;
        for (int a : ans) {
            if (a > max) max = a;
        }

        for (int i = 0; i <= N; i++) {
            if (ans[i] == max) {
                System.out.print(i + " ");
            }
        }
    }
}
