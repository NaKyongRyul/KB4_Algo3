package Day5.B1182_부분수열의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class B1182_부분수열의합_김원우 {

    static int [] arr;
    static int n;
    static int s;
    static boolean [] visited;
    static int cnt=0;

    static void subset(int num) {

        if (num == n) {
            int sum = 0;
            int flag = 0;

            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    flag = 1;
//                    System.out.print(arr[i] + " ");
                    sum += arr[i];
                }
            }
            if (sum == s && flag != 0) {
                cnt++;
            }
            return;
        }

        visited[num] = true;
        subset(num + 1);
        visited[num] = false;
        subset(num + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        subset(0);
        System.out.println(cnt);
    }
}
