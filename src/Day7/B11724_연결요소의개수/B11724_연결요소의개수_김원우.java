package Day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B11724_연결요소의개수_김원우 {

    static int n;
    static int m;
    static ArrayList<Integer> [] arr;

    static int [] visited;

    static void dfs(int node) {
        visited[node] = 1;

        for (int i : arr[node]) {
            if (visited[i] == 1) continue;
            dfs(i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n+1];
        visited = new int[n+1];

        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int tmp1 = Integer.parseInt(st.nextToken());
            int tmp2 = Integer.parseInt(st.nextToken());

            arr[tmp1].add(tmp2);
            arr[tmp2].add(tmp1);
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (visited[i] == 1) continue;

            dfs(i);
            cnt++;
        }

        System.out.println(cnt);
    }
}
