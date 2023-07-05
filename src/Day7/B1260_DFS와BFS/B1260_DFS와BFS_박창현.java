package Day7.B1260_DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1260_DFS와BFS_박창현 {
    static ArrayList<ArrayList<Integer>> arr;
    static Queue<Integer> queue;
    static boolean[] isVisited;

    static void dfs(int idx) {
        System.out.print(idx + " ");
        isVisited[idx] = true;
        for (Integer i : arr.get(idx)) {
            if (!isVisited[i]) dfs(i);
            isVisited[i] = true;
        }
    }

    static void bfs(int idx) {
        isVisited[idx] = true;
        queue.add(idx);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            for (Integer i : arr.get(node)) {
                if (!isVisited[i]) queue.add(i);
                isVisited[i] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        arr = new ArrayList<>();
        queue = new ArrayDeque<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N + 1; i++) {
            arr.add(i, new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            arr.get(from).add(to);
            arr.get(to).add(from);
        }
        for (ArrayList<Integer> integers : arr) {
            Collections.sort(integers);
        }

        isVisited = new boolean[N + 1];
        dfs(V);
        System.out.println();
        Arrays.fill(isVisited, false);
        bfs(V);
    }
}
/*
4 5 1
1 4
1 3
1 2
4 3
3 2
 */