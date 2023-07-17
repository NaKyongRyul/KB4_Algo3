package Day6.B1068_트리;

import java.util.*;
import java.io.*;

public class B1068_트리_이도원 {
    static List<List<Integer>> graph;
    static int answer = 0;
    static int root = 0;

    public static void dfs(int s, int deleteNode){
        if (s == deleteNode) return;

        if (graph.get(s).size() == 0) {
            answer++;
            return;
        }

        for (int node : graph.get(s)){
            dfs(node, deleteNode);
            if (node == deleteNode && graph.get(s).size() == 1) answer++;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            int parent = Integer.parseInt(st.nextToken());

            if (parent == -1) root = i;
            else graph.get(parent).add(i);
        }

        int deleteNode = Integer.parseInt(br.readLine());

        dfs(root, deleteNode);

        System.out.println(answer);
    }
}
