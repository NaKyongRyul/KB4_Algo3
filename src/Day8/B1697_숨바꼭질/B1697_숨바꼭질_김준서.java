package Day8.B1697_숨바꼭질;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class B1697_숨바꼭질_김준서 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] visited = new int[100001];
        int answer = 0;
        int from = sc.nextInt();
        int to = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        visited[from] = 0;
        queue.add(from);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == to) {
                System.out.println(visited[cur]);
                return;
            }
            int[] temp = {cur + 1, cur - 1, cur * 2};
            for (int t : temp) {
                if (!(t < 0 || t > 100000 || visited[t] != 0)) {
                    visited[t] = visited[cur] + 1;
                    queue.add(t);
                }
            }
        }
    }
}