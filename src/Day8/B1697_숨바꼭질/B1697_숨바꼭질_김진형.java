package Day8.B1697_숨바꼭질;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1697_숨바꼭질_김진형 {
    static final int MAX_ARRAY_SIZE = 100001;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (N >= K) {
            System.out.println(N - K);
            return;
        }
        boolean[] visited = new boolean[MAX_ARRAY_SIZE];
        int[] dist = new int[MAX_ARRAY_SIZE];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        visited[N] = true;
        dist[N] = 0;
        while (!q.isEmpty()) {
            int currNum = q.poll();
            if (currNum == K) {
                break;
            }
            // X-1
            if (currNum - 1 > -1 && !visited[currNum - 1]) {
                dist[currNum - 1] = Math.min(dist[currNum - 1], dist[currNum] + 1);
                q.offer(currNum - 1);
                visited[currNum - 1] = true;
            }
            // X+1
            if (currNum + 1 < MAX_ARRAY_SIZE && !visited[currNum + 1]) {
                dist[currNum + 1] = Math.min(dist[currNum + 1], dist[currNum] + 1);
                q.offer(currNum + 1);
                visited[currNum + 1] = true;
            }
            // X*2
            if (currNum * 2 < MAX_ARRAY_SIZE && !visited[currNum * 2]) {
                dist[currNum * 2] = Math.min(dist[currNum * 2], dist[currNum] + 1);
                q.offer(currNum * 2);
                visited[currNum * 2] = true;
            }
        }
        System.out.println(dist[K]);
    }
}