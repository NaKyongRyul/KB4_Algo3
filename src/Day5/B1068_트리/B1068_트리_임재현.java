package Day5.B1068_트리;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

public class B1068_트리_임재현 {
    static ArrayList<Integer>[] tree;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        tree = new ArrayList[N]; // 자식 노드를 push
        int root = -1;
        int ans = 0;
        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            int v = sc.nextInt();
            if (v == -1) {
                root = i;
                continue;
            }
            tree[v].add(i);
        }
        int target = sc.nextInt();
        sc.close();

        if (target == root) {
            System.out.println(0);
            return;
        }
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(root);

        while (q.size() > 0) {
            int temp = q.poll();
            int len = 0;
            for (int i = 0; i < tree[temp].size(); i++) {
                if (tree[temp].get(i) == target)
                    continue;
                q.add(tree[temp].get(i));
                len++;
            }
            if (len == 0) {
                ans++;
            }
        }
        System.out.println(ans);

    }
}
