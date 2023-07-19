package Day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class B1697_숨바꼭질_송봉섭 {
    static int N;
    static int K;
    static int[] visited;

    /*
    2 5
     */
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String string= br.readLine();
        String[] strings = string.split(" ");

        N = Integer.valueOf(strings[0]);
        K = Integer.valueOf(strings[1]);
        visited = new int[100001];

//        System.out.println(N);
//        System.out.println(K);
        bfs(N);
    }

    private static void bfs(int x) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(x);

        visited[x] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            // now - 1, now + 1, 2 * now
//            int nowMinus = now - 1;
//            int nowPlus = now + 1;
//            int nowJump = now * 2;

            if (now == K) {
                System.out.println(visited[now] - 1); // 맨처음 시작
            }
            if (now - 1 >= 0 && visited[now - 1] == 0) {
                visited[now - 1] = visited[now] + 1;
                queue.add(now - 1);
            }
            if (now + 1 <= 100000 && visited[now + 1] == 0) {
                visited[now + 1] = visited[now] + 1;
                queue.add(now + 1);
            }
            if (2 * now <= 100000 && visited[2 * now] == 0) {
                visited[2 * now] = visited[now] + 1;
                queue.add(2 * now);
            }
        }

    }


}