package day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1697_숨바꼭질_신선영 {
    static int N;
    static int K;
    static Queue<Integer> Q;
    static boolean[] visited;
    static int[] arr;

    static void search(int n) { // BFS 이용
        Q.add(n);
        visited[n] = true;
        arr[n] = 0; // 시작점은 비용 0으로 시작

        while (!Q.isEmpty()) {
            int now = Q.poll();
            if (now == K) return;   // 가능하지 않은 경우는 없음
            // 가능한 경우의 수: +1, -1, *2
            int[] cases = new int[] {now - 1, now + 1, now * 2};
            for (int c : cases) {
                // 문제 제공 범위 참고
                if (0 <= c && c <= 100000 && !visited[c]) {
                    visited[c] = true;  // 범위 체크
                    arr[c] = arr[now] + 1;  // 이전 값보다 1 큰 비용 저장
                    Q.add(c);
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 수빈이의 위치
        K = Integer.parseInt(st.nextToken());   // 동생의 위치

        Q = new ArrayDeque<>();
        visited = new boolean[100001];  // 방문 체크 (더 큰 값으로 덮어씌워지지 않게)
        arr = new int[100001];  // 비용 체크

        search(N);
        System.out.println(arr[K]);
    }
}
