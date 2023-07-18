package Day6;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1260_DFS와BFS_송봉섭 {
    static ArrayList <Integer> [] lists; // 인접리스트

    static Stack<Integer> stack ;
    static Queue<Integer> queue;
    static int N;
    static int M;
    static int start;

    static int node;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");

        N = Integer.parseInt(strings[0]); // 1~N  정점
        M = Integer.parseInt(strings[1]); // 간선의 갯수
        start = Integer.parseInt(strings[2]); // 시작점



        lists = new ArrayList[N+1];

        for(int i=0; i<lists.length; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            strings = br.readLine().split(" ");
            int x = Integer.parseInt(strings[0]);
            int y = Integer.parseInt(strings[1]);
            lists[x].add(y);
            lists[y].add(x);
        }


        for (int i = 0; i < lists.length; i++) {
            Collections.sort(lists[i], Collections.reverseOrder());
            //System.out.println(lists[i]);
        }
        stack = new Stack<>();
        visited = new boolean[N+1]; // false로 초기화
        stack.push(start);
        visited[start] = true;
        System.out.print(start + " ");
        DFS(start);

        System.out.println();


        for (int i = 0; i < lists.length; i++) {
            Collections.sort(lists[i]);
            //System.out.println(lists[i]);
        }

        queue = new ArrayDeque<>();
        visited = new boolean[N+1];
        queue.add(start);
        visited[start] = true;
        System.out.print(start + " ");
        BFS(start);
    }

    private static void BFS(int start) {
        while(!queue.isEmpty()) {
            int node = queue.poll();
            if (visited[node]==false) {
                System.out.print(node+" ");
                visited[node] = true;
            }

            for (int next : lists[node]) {
                if (visited[next]==true) continue;
                queue.add(next); // push
            }
        }
    }

    private static void DFS(int v) {
        while(!stack.isEmpty()) {
            int node = stack.pop();
            if (visited[node]==false) {
                System.out.print(node+" ");
                visited[node] = true;
            }

            for (int next : lists[node]) {
                if (visited[next]==true) continue;
                stack.add(next); // push
            }
        }

        }


}