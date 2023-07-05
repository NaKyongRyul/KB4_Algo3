package day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1920_수찾기_신선영 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int n = Integer.parseInt(st.nextToken());
            int ans = 0;

            int low = 0;
            int high = N - 1;

            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[mid] < n) {
                    low = mid + 1;
                } else if (arr[mid] > n) {
                    high = mid - 1;
                } else {
                    ans = 1;
                    break;
                }
            }

            System.out.println(ans);
        }

    }
}
