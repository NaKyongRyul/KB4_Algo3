package Day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1068_트리_김원우 {

    static int n,root,delete;
    static int cnt=0;
    static int [] parent;
    static int target;
    static boolean [] visited;
    static int ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        parent = new int[n];
        visited = new boolean[n];
        ans = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            parent[i] = tmp;
            if (tmp == -1) {
                root = i;
            }
        }
        delete = Integer.parseInt(br.readLine());
        deleteNode(delete);

        cntLeaf(root);
        System.out.println(cnt);
    }

    static void deleteNode(int delete) {
        parent[delete] = -2;
        for (int i = 0; i < n; i++) {
            if (parent[i] == delete) {
                deleteNode(i);
            }
        }
    }

    static void cntLeaf(int num) {
        boolean isLeaf = true;
        visited[num] = true;

        if (parent[num] != -2) {
            for (int i = 0; i < n; i++) {
                if (parent[i] == num && !visited[i]) {
                    cntLeaf(i);
                    isLeaf = false;
                }
            }
            if (isLeaf) {
                System.out.println("num : " + num);
                cnt++;
            }
        }

    }

}
