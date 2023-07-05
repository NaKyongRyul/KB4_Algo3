package Day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class B11725_트리의부모찾기_김원우 {

    static int n;
    static int [] ans;
//    static Stack<Integer> stack;
    static boolean [] visited;
    static ArrayList<Integer>[] arr;
    static void dfs(int num) {
        for (int i : arr[num]) {
            if (!visited[i]) {
                ans[i] = num;
                visited[num] = true;
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new ArrayList[n+1];

        visited = new boolean[n+1];
        ans = new int[n+1];

        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<Integer>();
        }

        for (int i = 1; i <= n-1; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int tmp1 = Integer.parseInt(st.nextToken());
            int tmp2 = Integer.parseInt(st.nextToken());

            arr[tmp1].add(tmp2);
            arr[tmp2].add(tmp1);
        }
        dfs(1);
        for (int i = 2; i <= n; i++) {
            System.out.println(ans[i]);
        }
    }
}
