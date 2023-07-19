package Day8.B13023_ABCDE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B13023_ABCDE_김진형 {
    static int E;
    static int V;

    static ArrayList<Integer>[] adList;
    static boolean[] visited;

    static boolean flag;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        adList = new ArrayList[V];
        for (int i = 0; i < V; ++i) {
            adList[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; ++i) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            adList[n1].add(n2);
            adList[n2].add(n1);
        }
        flag = false;
        for (int i = 0; i < V; ++i) {
            visited = new boolean[V];
            visited[i] = true;
//            System.out.println("============");
            DFS(i, 0);
//            System.out.println("maxLen = " + maxLen);
            if (flag) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

    static void DFS(int currNode, int edgeCnt) {
        if (edgeCnt == 4) {
            flag = true;
            return;
        }
        for (int i = 0; i < adList[currNode].size(); ++i) {
            int nextNode = adList[currNode].get(i);
            if (visited[nextNode]) {
                continue;
            }
            visited[nextNode] = true;
            DFS(nextNode, edgeCnt + 1);
            visited[nextNode] = false;
        }
    }
}