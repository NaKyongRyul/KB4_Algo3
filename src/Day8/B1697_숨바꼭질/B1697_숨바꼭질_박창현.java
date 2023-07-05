package Day8.B1697_숨바꼭질;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1697_숨바꼭질_박창현 {
    static Queue<Integer> q;
    static int[] arr = new int[100_100];

    static void bfs(int start, int end) {
        q.add(start);
        int now = 0;
        while (!q.isEmpty()) {
            now = q.poll();
            if (now == end) break;
            if (now + 1 >= 0 && now + 1 < 100_100 && arr[now + 1] == 0) {
                q.add(now + 1);
                arr[now + 1] = arr[now] + 1;
            }
            if (now - 1 >= 0 && now - 1 < 100_100 && arr[now - 1] == 0) {
                q.add(now - 1);
                arr[now - 1] = arr[now] + 1;
            }
            if (now * 2 >= 0 && now * 2 < 100_100 && arr[now * 2] == 0) {
                q.add(now * 2);
                arr[now * 2] = arr[now] + 1;
            }
        }
        System.out.println(arr[now]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        q = new ArrayDeque<>();
        bfs(N, K);
    }
}
