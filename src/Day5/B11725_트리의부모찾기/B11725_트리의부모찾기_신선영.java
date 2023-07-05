package day5;

import java.util.ArrayList;
import java.util.Scanner;

public class B11725_트리의부모찾기_신선영 {
    static int N;
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int[] parents;

    static void search(int i) {
        visited[i] = true;
        for (int t : tree[i]) {
            // 이미 방문한 노드를 마주친 경우 부모일 것임 (만난 적이 있으니까)
            if (visited[t]) {
                parents[i] = t;
            }
            // 방문 안 한 부분 만나면 더 아래로 탐색 (자식일테니까)
            else {
                search(t);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        tree = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < N + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int n = 0; n < N - 1; n++) {
            int a = sc.nextInt();
            int b= sc.nextInt();
            tree[a].add(b);
            tree[b].add(a);
        }

        // 부모 찾기
        parents = new int[N + 1];

        search(1);
        for (int i = 2; i < N + 1; i++) {
            System.out.println(parents[i]);
        }

    }
}
