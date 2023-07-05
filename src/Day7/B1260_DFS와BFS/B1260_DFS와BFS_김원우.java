package Day7.B1260_DFS와BFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1260_DFS와BFS_김원우 {

    static int n;
    static int m;
    static ArrayList<Integer>[] arr;

    static boolean [] visited;
    static void dfs(int cur) {
        visited[cur] = true;
        System.out.print(cur + " ");

        for (int i : arr[cur]) {
            if (visited[i]) continue;
            dfs(i);
        }
    }

    static void bfs(int cur) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(cur);
        visited[cur] = true;

        while (!queue.isEmpty()) {
            int tmp = queue.poll();

            System.out.print(tmp + " ");

            for (int i : arr[tmp]) {
                if (visited[i]) continue;
                visited[i] = true;
                queue.offer(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n+1];
        visited = new boolean[n+1];
        int v = Integer.parseInt(st.nextToken());


        for (int i = 0; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int tmp1 = Integer.parseInt(st.nextToken());
            int tmp2 = Integer.parseInt(st.nextToken());

            arr[tmp1].add(tmp2);
            arr[tmp2].add(tmp1);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(arr[i]);
        }

        dfs(v);
        visited = new boolean[n+1];
        System.out.println();
        bfs(v);
        br.close();
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }

    }
}
