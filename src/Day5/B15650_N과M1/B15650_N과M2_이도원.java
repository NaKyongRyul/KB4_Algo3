package Day5.B15650_N과M1;

import java.util.*;
import java.io.*;

public class B15650_N과M2_이도원 {
    static List<Integer> list = new ArrayList<>();

    public static void combination(int[] arr, int n, int m, int idx, int cnt){
        if (cnt == m){
            for(int num : list){
                System.out.print(num + " ");
            }
            System.out.println();
        }

        for (int i = idx; i < n; i++){
            list.add(arr[i]);
            combination(arr, n, m, i + 1, cnt + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 1; i <= n; i++){
            arr[i - 1] = i;
        }

        combination(arr, n, m, 0, 0);
    }
}
