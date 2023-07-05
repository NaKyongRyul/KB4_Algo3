package Day5.B11725_트리의부모찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class B11725_트리의부모찾기_박창현 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(bf.readLine());

        ArrayList<Integer>[] tree = new ArrayList[N + 1];
        boolean[] isVisit = new boolean[N + 1];
        int[] parent = new int[N + 1];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }

        stack.push(1);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            for (int nextnode : tree[node]) {
                if (isVisit[nextnode]) continue;
                isVisit[nextnode] = true;
                parent[nextnode] = node;
                stack.push(nextnode);
            }
        }
        for (int i = 2; i < parent.length; i++) {
            System.out.println(parent[i]);
        }

    }
}
