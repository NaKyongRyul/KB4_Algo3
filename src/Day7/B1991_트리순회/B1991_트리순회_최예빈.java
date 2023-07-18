package Day7.B1991_트리순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1991_트리순회_최예빈 {

    static int A = 65;
    static int N;
    static int[][] tree;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        tree = new int[N][2];

        int p, l, r;
        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            p = ((int) chars[0]) - A;
            // '.' => -19
            l = ((int) chars[2]) - A;
            r = ((int) chars[4]) - A;
            tree[p][0] = l;
            tree[p][1] = r;
        }

        StringBuilder sb = new StringBuilder();
        preorder(0, sb);
        sb.append("\n");

        inorder(0, sb);
        sb.append("\n");

        postorder(0, sb);

        System.out.println(sb);
    }

    private static void preorder(int node, StringBuilder sb) {
        sb.append((char) (node + A));
        if (tree[node][0] != -19) preorder(tree[node][0], sb);
        if (tree[node][1] != -19) preorder(tree[node][1], sb);
    }

    private static void inorder(int node, StringBuilder sb) {
        if (tree[node][0] != -19) inorder(tree[node][0], sb);
        sb.append((char) (node + A));
        if (tree[node][1] != -19) inorder(tree[node][1], sb);
    }

    private static void postorder(int node, StringBuilder sb) {
        if (tree[node][0] != -19) postorder(tree[node][0], sb);
        if (tree[node][1] != -19) postorder(tree[node][1], sb);
        sb.append((char) (node + A));
    }
}
