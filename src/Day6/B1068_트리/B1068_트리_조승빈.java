package Day6.B1068_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B1068_트리_조승빈 {
    static List<Integer>[] tree;
    static int N;
    static int target;
    static int root;
    static int cnt = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());

            if (parent == -1) root = i;
            else tree[parent].add(i);
        }

        target = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            tree[i].remove(Integer.valueOf(target));
        }

        DFS(root);

        System.out.println(cnt);
    }

    public static void DFS(int nowNode) {

        if(nowNode == target)
            return;

        if(tree[nowNode].size() == 0) cnt++;

        for(int nextNode : tree[nowNode])
            DFS(nextNode);
    }
}
