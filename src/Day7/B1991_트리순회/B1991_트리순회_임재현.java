package Day7.B1991_트리순회;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1991_트리순회_임재현 {
    static int N;
    static ArrayList<Integer>[] tree;
    StringBuilder builder;

    static void preOrder(int node) {
        char nodeName = (char) ('A' + node);
        System.out.print(nodeName);
        int left = tree[node].get(0);
        if (left > -1)
            preOrder(left);
        int right = tree[node].get(1);
        if (right > -1)
            preOrder(right);
    }

    static void inOrder(int node) {
        int left = tree[node].get(0);
        if (left > -1)
            inOrder(left);
        char nodeName = (char) ('A' + node);
        System.out.print(nodeName);
        int right = tree[node].get(1);
        if (right > -1)
            inOrder(right);
    }

    static void postOrder(int node) {
        int left = tree[node].get(0);
        if (left > -1)
            postOrder(left);
        int right = tree[node].get(1);
        if (right > -1)
            postOrder(right);
        char nodeName = (char) ('A' + node);
        System.out.print(nodeName);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        tree = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            int idx = token.nextToken().charAt(0) - 'A';
            tree[idx] = new ArrayList<Integer>();

            char left = token.nextToken().charAt(0);
            tree[idx].add((left != '.') ? left - 'A' : -1);

            char right = token.nextToken().charAt(0);
            tree[idx].add((right != '.') ? right - 'A' : -1);
        }

        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
        System.out.println();
    }
}
