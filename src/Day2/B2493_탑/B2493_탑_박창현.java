package Day2.B2493_탑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2493_탑_박창현 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] res = new int[N];
        int top = -1;
        for (int i = 0; i < N; i++) {
            while (top >= 0 && arr[res[top]] < arr[i]) {
                top--;
            }
            if (top >= 0) {
                sb.append(res[top] + 1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
            res[++top] = i;
        }
        System.out.println(sb);
    }
}