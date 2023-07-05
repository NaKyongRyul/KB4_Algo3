package Day8;

import java.util.Scanner;

public class B9663_NQueen_김원우 {
    static int n;
    static int [] graph;
    static int cnt = 0;

    static boolean is_Possible(int x) {
        for (int i = 0; i < x; i++) {
            if (graph[x] == graph[i] || Math.abs(x - i) == Math.abs(graph[x] - graph[i])) {
                // 같은 열에 있는지? 왼쪽 오른쪽 윗 대각 방향에 있는지?
                return false;
            }
        }
        return true;
    }

    static void dfs(int num) {
        if (num == n) {
            // 0~n-1 까지 다 돌았다는건 퀸의 배치가 다 이뤄졌다는 뜻
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) {
            graph[num] = i;
            // (num, i)에 퀸을 둔다.
            // 아래의 함수를 통과하지 못한 경우 재귀가 이뤄지지 않아 graph[num]은 다시 갱신됨.
            if (is_Possible(num)) {
                dfs(num+1);
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        graph = new int[n];
        dfs(0);
        System.out.println(cnt);
    }
}
