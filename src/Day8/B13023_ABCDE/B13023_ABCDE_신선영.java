package day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B13023_ABCDE_신선영 {
    static int N;
    static int M;
    static int ans;
    static ArrayList<Integer>[] friends;
    static boolean[] visited;

    static void search(int start, int cnt) {    // DFS 사용
        if (cnt == 5) {
            ans = 1;
            return;
        }

        visited[start] = true;
        for (int s : friends[start]) {
            if (!visited[s]) {
                search(s, cnt + 1);
            }
        }
        visited[start] = false; // 안하면 틀림
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 사람의 수
        M = Integer.parseInt(st.nextToken());   // 친구 관계의 수


        friends = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            friends[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friends[a].add(b);
            friends[b].add(a);
        }

        ans = 0;

        // 0부터 가능한 경우 탐색
        for (int i = 0; i < N; i++) {
            if (ans == 1) break;    // 이미 답을 찾은 경우 더 진행 X
            visited = new boolean[N];   // visited 매번 리셋
            search(i, 1);
        }

        System.out.println(ans);

    }
}
