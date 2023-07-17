package Day6.B11725_트리의부모찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B11725_트리의부모찾기_조승빈 {

    static int N;

    static boolean[] visited;
    static int[] parentNode;
    static List<List<Integer>> tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        tree = new ArrayList<>();

        for (int i = 1; i <= N + 1; i++) {
            tree.add(new ArrayList<>());
        }

        int firstNode, secondNode;

        for (int i = 1; i <= N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            firstNode = Integer.parseInt(st.nextToken());
            secondNode = Integer.parseInt(st.nextToken());

            tree.get(firstNode).add(secondNode);
            tree.get(secondNode).add(firstNode);
        }

        visited = new boolean[N + 1];
        parentNode = new int[N + 1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        while (!queue.isEmpty()) {
            int v = queue.remove();
            for (int node : tree.get(v))
                if (!visited[node]) {
                    visited[node] = true;
                    queue.add(node);
                    parentNode[node] = v; // 부모 노드 찾은 후 저장
                }
        }

        for (int i = 2; i <= N; i++) {
            System.out.println(parentNode[i]);
        }
    }
}
