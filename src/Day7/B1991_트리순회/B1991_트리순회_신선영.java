package day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B1991_트리순회_신선영 {
    static LinkedList<Integer>[] tree;
    static int N;

    /**
     * 전위 순회
     * @param n
     */
    static void pre(int n) {
        if (n == -19) return;
        System.out.print((char)(n + 65));
        pre(tree[n].get(0));
        pre(tree[n].get(1));
    }

    /**
     * 중위 순회
     * @param n
     */
    static void in(int n) {
        if (n == -19) return;
        in(tree[n].get(0));
        System.out.print((char)(n + 65));
        in(tree[n].get(1));
    }

    /**
     * 후위 순회
     * @param n
     */
    static void post(int n) {
        if (n == -19) return;
        post(tree[n].get(0));
        post(tree[n].get(1));
        System.out.print((char)(n + 65));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        tree = new LinkedList[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = st.nextToken().charAt(0) - 65;
            int b = st.nextToken().charAt(0)- 65;
            int c = st.nextToken().charAt(0) - 65;

            tree[a] = new LinkedList<>();
            tree[a].add(b);
            tree[a].add(c);
        }

        pre(0);
        System.out.println();
        in(0);
        System.out.println();
        post(0);



    }
}
