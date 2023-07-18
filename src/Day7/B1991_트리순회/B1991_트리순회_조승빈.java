package Day7.B1991_트리순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1991_트리순회_조승빈 {
    static int N;
    static int leafNode = -19;
    static int [][] tree;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        tree = new int [N][2];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int parentNode = st.nextToken().charAt(0) - 'A';
            int leftNode = st.nextToken().charAt(0) - 'A';
            int rightNode = st.nextToken().charAt(0) - 'A';

            tree[parentNode][0] = leftNode;
            tree[parentNode][1] = rightNode;

        }

        preorder(0);
        System.out.println();
        inorder(0);
        System.out.println();
        postorder(0);
    }

    public static void preorder(int nowNode) {

        if(nowNode == leafNode) return;

        System.out.print( (char) (nowNode + 'A') );
        preorder(tree[nowNode][0]);
        preorder(tree[nowNode][1]);
    }

    public static void inorder(int nowNode) {

        if(nowNode == leafNode) return;

        inorder(tree[nowNode][0]);
        System.out.print( (char) (nowNode + 'A') );
        inorder(tree[nowNode][1]);
    }

    public static void postorder(int nowNode) {

        if(nowNode == leafNode) return;

        postorder(tree[nowNode][0]);
        postorder(tree[nowNode][1]);
        System.out.print( (char) (nowNode + 'A') );
    }
}
