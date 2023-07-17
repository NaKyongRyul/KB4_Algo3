package Day6.B11725_트리의부모찾기;

import java.util.*;
import java.io.*;

public class B11725_트리의부모찾기_이도원 {
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int[] parent;

    public static void bfs(int s){
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.add(s);

        while(!q.isEmpty()){
            int curNode = q.poll();

            for (int i = 0; i < graph.get(curNode).size(); i++){
                int newNode = graph.get(curNode).get(i);

                if (visited[newNode]) continue;

                visited[newNode] = true;
                parent[newNode] = curNode;
                q.add(newNode);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        parent = new int[n + 1];
        visited = new boolean[n + 1];
        graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < n - 1; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph.get(s).add(e);
            graph.get(e).add(s);
        }

        bfs(1);

        for (int i = 2; i <= n; i++){
            System.out.println(parent[i]);
        }
    }
}
