package Day8;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1697_숨바꼭질_김원우 {

    static int n;
    static int k;

    static int [] move = new int[] {1,-1,2};

    static int min_cnt = Integer.MAX_VALUE;
    static int[] visited = new int[100001]; // 인덱스 체크를 잘하자..

    static void bfs(int num) {
        Queue<int []> q = new LinkedList<>();
        q.offer(new int[] {num, 0});

        while (!q.isEmpty()) {
            int [] tmp = q.poll();

//            System.out.println(Arrays.toString(tmp));

            if (tmp[0] == k) {
//                min_cnt = tmp[1];
                System.out.println(tmp[1]);
                break;
            }

            for (int i : new int [] {tmp[0]+1, tmp[0]-1, tmp[0]*2}) {

                if (i > 100000 || i < 0) continue;

                if (visited[i] == 0) {
                    visited[i] = visited[tmp[1]]+1;
                    q.offer(new int [] {i, tmp[1]+1});
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();
//        System.out.println(Arrays.toString(visited));
        bfs(n);
//        System.out.println(min_cnt);

    }
}
