package Day8.B1697_숨바꼭질;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * 걷거나      x-1 || x+1 (1초)
 * 순간이동     x*2 (1초)
 */
public class B1697_숨바꼭질_최예빈 {

    static int N, K;                    // 수빈, 동생 위치
    static int[] axis;                  // 1차원
    static final int SIZE = 100_001;    // 경계
    static Queue<Ordinate> queue;       // bfs

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        bfs();
    }

    private static void bfs() {

        queue = new ArrayDeque<>();
        axis = new int[SIZE];

        axis[N] = 1;
        queue.add(new Ordinate(N, axis[N]));

        while (!queue.isEmpty()) {
            Ordinate ord = queue.poll();

            if (ord.x == K) {
                System.out.println(ord.second - 1);
                return;
            }

            int[] move = {ord.x - 1, ord.x + 1, ord.x * 2};
            for (int i = 0; i < 3; i++) {
                int next = move[i];
                if (next < 0 || next > SIZE - 1) continue;  // 범위 초과
                if (axis[next] != 0) continue;              // 이미 다녀간 좌표

                axis[next] = ord.second + 1;
                queue.add(new Ordinate(next, axis[next]));
            }
        }
    }

    private static class Ordinate {
        int x, second;

        public Ordinate(int x, int second) {
            this.x = x;
            this.second = second;
        }
    }
}
