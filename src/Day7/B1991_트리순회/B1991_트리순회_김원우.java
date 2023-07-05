package Day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1991_트리순회_김원우 {

    static int n;
    static char [][] arr;

    static void preOrder(char curNode) {
        if (curNode == '.') {
            return;
        }

        System.out.print(curNode);
        int cur_idx = curNode - 'A';
        preOrder(arr[cur_idx][0]);
        preOrder(arr[cur_idx][1]);
    }

    static void postOrder(char curNode) {
        if (curNode == '.') {
            return;
        }

        int cur_idx = curNode - 'A';
        postOrder(arr[cur_idx][0]);
        postOrder(arr[cur_idx][1]);
        System.out.print(curNode);
    }

    static void inOrder(char curNode) {
        if (curNode == '.') {
            return;
        }

        int cur_idx = curNode - 'A';
        inOrder(arr[cur_idx][0]);
        System.out.print(curNode);
        inOrder(arr[cur_idx][1]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new char[26][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int idx = st.nextToken().charAt(0) - 'A';
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            arr[idx] = new char[]{left, right};

        }

        preOrder('A');
        System.out.println();
        inOrder('A');
        System.out.println();
        postOrder('A');
//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(arr[i]));
//        }

    }
}
