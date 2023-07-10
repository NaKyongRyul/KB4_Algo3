package Day1.B10807_개수세기;

import java.util.*;
import java.io.*;

public class B10807_개수세기_이도원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int target = Integer.parseInt(st.nextToken());

        int answer = 0;
        for (int i = 0; i < n; i++){
            if(arr[i] == target) answer++;
        }

        System.out.println(answer);
    }
}
