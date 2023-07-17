package Day6.B11725_트리의부모찾기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class B11725_트리의부모찾기_김진형 {
    public class Main {
        public static void main(String[] args) throws Exception{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            ArrayList<Integer>[] adList = new ArrayList[N + 1];
            for (int i = 1; i < N + 1; ++i) {
                adList[i] = new ArrayList<>();
            }
            for (int i = 0; i < N - 1; ++i) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int node1 = Integer.parseInt(st.nextToken());
                int node2 = Integer.parseInt(st.nextToken());
                adList[node2].add(node1);
                adList[node1].add(node2);
            }
            int[] ans = new int[N + 1];
            boolean[] visited = new boolean[N + 1];
            Queue<Integer> q = new LinkedList<>();
            q.offer(1);
            visited[1] = true;
            while (!q.isEmpty()) {
                int currNode = q.poll();
                for (Integer child : adList[currNode]) {
                    if (visited[child]) {
                        continue;
                    }
                    ans[child] = currNode;
                    q.offer(child);
                    visited[child] = true;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 2; i <= N; ++i) {
                sb.append(ans[i]);
                sb.append("\n");
            }
            System.out.println(sb);
        }
    }
}
