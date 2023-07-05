package Day8.B13023_ABCDE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B13023_ABCDE_박창현 {
    static ArrayList<ArrayList<Integer>> arr;
    static boolean[] isVisited;
    static int count = 0;

    static void dfs(int idx, int c) {
//        arr.get(idx);
        for (Integer i : arr.get(idx)) {
            if (c >= 5) {
                count++;
                return;
            }
            if (isVisited[i]) continue;
            isVisited[i] = true;
            dfs(i, c + 1);
            isVisited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>();
        isVisited = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            arr.add(i, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        for (int i = 0; i < n; i++) {
            System.out.println(i + " " + arr.get(i));
        }
        Arrays.fill(isVisited, false);
        for (ArrayList<Integer> t : arr) {
            if (count!=0)break;
            for (Integer i : t) {
                if (count!=0)break;
                isVisited[i] = true;
                dfs(i, 1);
                isVisited[i] = false;
            }
        }
//        do {
//            int node = Collections.singletonList(isVisited).indexOf(false);
//            System.out.println(node);
//        } while (Collections.singletonList(isVisited).contains(false));
        System.out.println(count > 0 ? 1 : 0);
    }
}
/*
5 4
0 1
1 2
2 3
3 0
 */