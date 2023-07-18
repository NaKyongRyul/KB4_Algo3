package Day7.B1260_DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1260_DFS와BFS_조승빈 {
    static int N;
    static int M;
    static int V;

    static List<Integer>[] board;
    static Queue<Integer> Q;

    static boolean[] dfsVisited;
    static boolean[] dfsWithRecursiveVisited;
    static boolean[] bfsVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        board = new ArrayList[N + 1];
        for(int i = 0; i <= N; i++) {
            board[i] = new ArrayList<>();
        }

        dfsVisited = new boolean[N + 1];
        bfsVisited = new boolean[N + 1];
        dfsWithRecursiveVisited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int firstNode = Integer.parseInt(st.nextToken());
            int secondNode = Integer.parseInt(st.nextToken());

            board[firstNode].add(secondNode);
            board[secondNode].add(firstNode);
        }

        for (List<Integer> row : board) {
            Collections.sort(row);
        }

        dfs(V);
        System.out.println();
        bfs(V);
        System.out.println();
        dfsWithRecursive(V);
    }

    private static void dfsWithRecursive(int start) {
        if (dfsWithRecursiveVisited[start]) return;
        System.out.print(start + " ");
        dfsWithRecursiveVisited[start] = true;
        for (int nxt : board[start]) {
            if (nxt == 0) continue;
            dfsWithRecursive(nxt);
        }
    }

    private static void dfs(int start) {
        dfsVisited[start] = true;
        System.out.print(start + " ");
        for (int nxt : board[start]) {
            if (nxt == 0) continue;
            if (!dfsVisited[nxt]) dfs(nxt);
        }
    }

    private static void bfs(int start) {
        bfsVisited[start] = true;
        Q = new LinkedList<>();
        Q.offer(start);
        while (!Q.isEmpty()) {
            int nowNode = Q.poll();
            System.out.print(nowNode + " ");
            for (int nxt : board[nowNode]) {
                if (nxt == 0) continue;
                if (!bfsVisited[nxt]) {
                    bfsVisited[nxt] = true;
                    Q.offer(nxt);
                }
            }
        }
    }
}
