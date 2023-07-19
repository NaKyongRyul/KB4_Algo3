package Day8.B1697_숨바꼭질;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1697_숨바꼭질_조승빈 {
    static final int MAX = 100000;
    static int N, K;
    static int[] time;
    static boolean[] visited;
    static Queue<Integer> Q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        time = new int[MAX + 1];
        visited = new boolean[MAX + 1];

        bfs(N);
        System.out.println(time[K]);
    }

    private static void bfs(int start) {
        visited[start] = true;
        time[start] = 0;
        Q = new ArrayDeque<>();
        Q.add(start);

        while(!Q.isEmpty()) {
            int x = Q.poll();

            if(x == K) break;

            nxtMove(x, x * 2);
            nxtMove(x, x - 1);
            nxtMove(x, x + 1);
        }
    }

    private static void nxtMove(int x, int next) {
        if(next >= 0 && next <= MAX && !visited[next]) {
            visited[next] = true;
            Q.add(next);
            time[next] = time[x] + 1;
        }
    }
}
