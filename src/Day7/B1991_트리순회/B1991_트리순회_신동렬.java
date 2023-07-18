package Day7.B1991_트리순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1991_트리순회_신동렬 {
        static int[][]tree;
        public static void main(String[] args) throws IOException {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            tree = new int[26][2];
            for(int i=0; i<N; i++){
                st = new StringTokenizer(bf.readLine());
                int node = st.nextToken().charAt(0)- 'A';
                char left = st.nextToken().charAt(0);
                char right = st.nextToken().charAt(0);
                if(left =='.') tree[node][0]=-1 ;
                else tree[node][0]=left-'A';
                if(right=='.')tree[node][1]=-1;
                else tree[node][1]=right-'A';
            }

            preOrder(0);
            System.out.println();
            inOrder(0);
            System.out.println();
            postOrder(0);




        }

        private static void postOrder(int nowNode) {
            if (nowNode==-1)return;
            postOrder(tree[nowNode][0]);
            postOrder(tree[nowNode][1]);
            System.out.print((char)(nowNode+'A'));
        }

        private static void inOrder(int nowNode) {
            if (nowNode==-1)return;
            inOrder(tree[nowNode][0]);
            System.out.print((char)(nowNode+'A'));
            inOrder(tree[nowNode][1]);

        }

        private static void preOrder(int nowNode) {
            if (nowNode==-1)return;
            System.out.print((char)(nowNode+'A'));
            preOrder(tree[nowNode][0]);
            preOrder(tree[nowNode][1]);
        }
    }


}
