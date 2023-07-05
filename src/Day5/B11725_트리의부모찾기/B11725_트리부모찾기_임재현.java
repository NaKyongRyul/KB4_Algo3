package Day5.B11725_트리의부모찾기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class B11725_트리부모찾기_임재현 {
    static int N;
    static ArrayList<Integer> tree[];

    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader((System.in)));
        Stack<Integer> st = new Stack<Integer>();
        StringBuilder builder = new StringBuilder();
        StringTokenizer token = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(token.nextToken());
        tree = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        int[] ans = new int[N + 1]; // 부모노드 번호만 기록

        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            token = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(token.nextToken());
            int v = Integer.parseInt(token.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }

        st.push(1);

        while (!st.empty()) {
            int top = st.pop();
            visited[top] = true;
            for (int i = 0; i < tree[top].size(); i++) {
                int target = tree[top].get(i);
                if (visited[target])
                    continue;
                else {
                    st.push(target);
                    ans[target] = top;
                }
            }
        }

        for (int i = 2; i <= N; i++) {
            builder.append(ans[i] + "\n");
        }
        System.out.print(builder);
    }
}
