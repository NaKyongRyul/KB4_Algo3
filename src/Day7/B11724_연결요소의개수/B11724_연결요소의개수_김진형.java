package Day7.B11724_연결요소의개수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class B11724_연결요소의개수_김진형 {
    static int V;
    static int E;

    static ArrayList<Integer>[] adList;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        //== 입력&초기화 ==//
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        adList = new ArrayList[V + 1];

        for (int i = 1; i <= V; ++i) {
            adList[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; ++i) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            adList[node1].add(node2);
            adList[node2].add(node1);
        }

        int ans = 0;

//        //== DFS 방식 ==//
//        visited = new boolean[V + 1];
//        for (int i = 1; i < V + 1; ++i) {
//            if (visited[i]) {
//                continue;
//            }
//            DFS(i);
//            ++ans;
//        }
        //== BFS 방식 ==//
        visited = new boolean[V + 1];
        for (int i = 1; i < V + 1; ++i) {
            if (visited[i]) {
                continue;
            }
            BFS(i);
            ++ans;
        }
        //== 출력 ==//
        System.out.println(ans);
    }

    private static void BFS(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visited[node] = true;
        while (!q.isEmpty()) {
            int currNode = q.poll();
            for (Integer nextNode : adList[currNode]) {
                if (visited[nextNode]) {
                    continue;
                }
                visited[nextNode] = true;
                q.offer(nextNode);
            }
        }
    }

    private static void DFS(int node) {
        Stack<Integer> stk = new Stack<>();
        stk.push(node);
        visited[node] = true;

        while (!stk.isEmpty()) {
            int currNode = stk.pop();
            for (Integer nextNode : adList[currNode]) {
                if (visited[nextNode]) {
                    continue;
                }
                stk.push(nextNode);
                visited[nextNode] = true;
            }
        }
    }
}
