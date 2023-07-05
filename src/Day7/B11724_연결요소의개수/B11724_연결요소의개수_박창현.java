package Day7.B11724_연결요소의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11724_연결요소의개수_박창현 {
    static ArrayList<Integer>[] arr;
    static Boolean[] isVisited;

    static void dfs(int nodeidx) {
        isVisited[nodeidx] = true;
        for (int i : arr[nodeidx]) {
            if (isVisited[i]) continue;
            isVisited[i] = true;
            dfs(i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N + 1];
        isVisited = new Boolean[N + 1];
        Arrays.fill(isVisited, false);

        int count = 0;
        for (int i = 0; i < N + 1; i++) arr[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }

        for (int i = 1; i < N + 1; i++) {
            if (isVisited[i]) continue;
            dfs(i);
            count++;
        }
        System.out.println(count);
    }
}
//        boolean flag = true;
//        int idx = 1;
//        while (flag) {
//            count++;
//            if (isVisited.contains(false)) {
//                idx = isVisited.indexOf(false);
//            } else flag = false;
////            System.out.println(flag+" "+idx);
////            System.out.println(Arrays.toString(arr));
////            System.out.println(isVisited);
//        }
/*
 */