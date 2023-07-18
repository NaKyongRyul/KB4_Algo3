package Day7.B1991_트리순회;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1991_트리순회_김진형 {
    static final int CTOI = 65;
    static int N;
    static ArrayList<Integer>[] adList;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adList = new ArrayList[N];
        for (int i = 0; i < N; ++i) {
            adList[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int node = st.nextToken().charAt(0) - CTOI;
            int lChild = st.nextToken().charAt(0) - CTOI;;
            int rChild = st.nextToken().charAt(0) - CTOI;;

            adList[node].add(lChild);
            adList[node].add(rChild);
        }
//        for (int i = 0; i < N; ++i) {
//            System.out.println(adList[i]);
//        }
        sb = new StringBuilder();
        preOrder(0);
        sb.append("\n");
        inOrder(0);
        sb.append("\n");
        postOrder(0);
        System.out.println(sb);
    }

    public static void preOrder(int node) {
        sb.append((char) (node+CTOI));
        int leftChild = adList[node].get(0);
        int rightChild = adList[node].get(1);
        if (leftChild == -19 && rightChild == -19) {
            return;
        }
        if (leftChild != -19) {
            preOrder(leftChild);
        }
        if (rightChild != -19) {
            preOrder(rightChild);
        }
    }
    public static void inOrder(int node) {
        int leftChild = adList[node].get(0);
        int rightChild = adList[node].get(1);
        if (leftChild == -19 && rightChild == -19) {
            sb.append((char) (node+CTOI));
            return;
        }
        if (leftChild != -19) {
            inOrder(leftChild);
        }
        sb.append((char) (node+CTOI));
        if (rightChild != -19) {
            inOrder(rightChild);
        }
    }
    public static void postOrder(int node) {
        int leftChild = adList[node].get(0);
        int rightChild = adList[node].get(1);
        if (leftChild == -19 && rightChild == -19) {
            sb.append((char) (node+CTOI));
            return;
        }
        if (leftChild != -19) {
            postOrder(leftChild);
        }
        if (rightChild != -19) {
            postOrder(rightChild);
        }
        sb.append((char) (node+CTOI));
    }
}
